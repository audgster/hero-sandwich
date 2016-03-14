package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.map.Map;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;
import com.herosandwich.util.visitor.movement.MovementCheckVisitor;

public class TeleportAoE extends AoE
{
    PositionHex destination;
    Map map;

    public TeleportAoE(PositionHex position, PositionHex destination)
    {
        super(position);
        this.destination = destination;
    }
    public void setMap(Map map){
        this.map = map;
    }

    public PositionHex getDestination()
    {
        return destination;
    }

    @Override
    public void executeEffect(Entity entity) {
        MovementCheckVisitor visitor = new MovementCheckVisitor();
        map.getTile(entity.getPosition()).acceptTileVisitor(visitor);
        if(visitor.canMove()) {
            entity.updatePosition(destination);
        }
    }

    @Override
    public String toString()
    {
        return "TeleportAoE";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitTeleportAoE(this);
    }
}
