package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

/**
 * Created by Mitchell on 3/14/2016.
 */
public class Trap extends AoE {

    private boolean discovered;
    private boolean activated;
    private AoE effect;


    public Trap(PositionHex position, boolean discovered, boolean activated, AoE mechanism){
        super(position);
        this.discovered = discovered;
        this.activated = activated;
        this.effect = mechanism;
    }

    public Trap(Trap copy){
        super(copy.getPosition());
        this.discovered = copy.discovered;
        this.activated = copy.activated;
        this.effect = copy.effect;
    }

    public boolean isDiscovered(){
        return this.discovered;
    }

    public boolean isActivated(){
        return this.activated;
    }

    public void discover(){
        this.discovered = true;
    }

    public void deactivate(){
        this.activated = false;
    }

    public AoE getEffect(){
        return this.effect;
    }

    @Override
    public void executeEffect(Entity entity){
        if(!activated){
            return;
        }
        effect.executeEffect(entity);
    }

    @Override
    public String toString()
    {
        return "Trap";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitTrap(this);
    }

    public void acceptForEffect(AoEVisitor visitor){
        effect.accept(visitor);
    }

}
