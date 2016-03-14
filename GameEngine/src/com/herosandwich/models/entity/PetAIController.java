package com.herosandwich.models.entity;

import com.herosandwich.menus.areaviewdrawables.Listener;
import com.herosandwich.models.map.Map;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.movement.MovementCheckVisitor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adamfortier on 3/14/16.
 */
public class PetAIController implements Listener{
    private Character owner;
    private Pet pet;
    private Map map;

    public PetAIController(Character owner, Map map) {
        this.owner = owner;
        this.map = map;
        registerAsListenerToOwner();
        initPetForOwner();
    }

    private void registerAsListenerToOwner() {
        owner.addListener(this);
    }

    private void initPetForOwner() {
        pet = new Pet(new Entity("olive", new PrimaryStats(), new ModiferWithWeightStatStrategy(1), new MovementCheckVisitor()));
        pet.updatePosition(owner.getPosition().getPosInDirection(DirectionHex.SOUTH));
        map.addEntity(pet.getPosition(), pet);
    }

    public void addPetOwner(Character owner) {
        this.owner = owner;
        owner.addListener(this);
    }

    private void AI() {
//        listen to a character so I can follow
//                --if it moves so do i;
//
//        look for items in a fan of tiles
//                --if I am mischief like now... steal unimportant items;

        //get the viewableTile hex positions to find items????

    }

    @Override
    public void update() {
        DirectionHex ownerMovement = owner.getDirection();
        boolean moved = pet.move(ownerMovement, map);
        if(!moved) {
            PositionHex ownerPosition = owner.getPosition();
            Set<PositionHex> avatarInViewTilePositions = map.drawCircle(ownerPosition, 3, true).keySet();
            Set<PositionHex> petInViewTilePositions = map.drawCircle(pet.getPosition(), 1, true).keySet();


            DirectionHex towardsOwner = DirectionHex.makeDirectionTo(pet.getPosition(), ownerPosition);
            if(pet.move(towardsOwner, map))
                return;
            else if(pet.move(DirectionHex.clockwise(towardsOwner), map))
                return;
            else if(pet.move(DirectionHex.counterClockwise(towardsOwner), map))
                return;
            else if(pet.move(DirectionHex.clockwise(DirectionHex.clockwise(towardsOwner)), map))
                return;
            else if(pet.move(DirectionHex.counterClockwise(DirectionHex.counterClockwise(towardsOwner)), map))
                return;
            else
                pet.move(DirectionHex.clockwise(DirectionHex.clockwise(DirectionHex.clockwise(towardsOwner))), map);
//            else if(flase) {
//                System.out.println("Trying to move pet to: " + position.getQ() + " " + position.getR() + " " + position.getS());
//
//                if(pet.move(DirectionHex.makeDirectionTo(pet.getPosition(), position), map)) {
//                    //get direction to owner move there...
//
//                    break;
//                }
//
//            //Find first tile in direction towards entity
//            for(PositionHex position : avatarInViewTilePositions) {
//
//                }
            //}
        }
    }
}
