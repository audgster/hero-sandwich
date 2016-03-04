package com.herosandwich.models.entity;

public class Mount extends Entity
{
    private Entity rider;
    private int movement;

    /*
    * Constructors
    * */

    public Mount()
    {
        this.rider = null;
        this.movement = 1;
    }

    public Mount(Entity entity)
    {
        this.rider = entity;
        this.movement = 1;
    }

    public Mount(int movement)
    {
        this.rider = null;
        this.movement = movement;
    }

    public Mount(Entity rider, int movement)
    {
        this.rider = rider;
        this.movement = movement;
    }

    public Mount(Mount mount)
    {
        this.rider = mount.getRider();
        this.movement = mount.getMovement();
    }

    /*
    * Accessors
    * */

    public Entity getRider()
    {
        return this.rider;
    }

    @Override
    public int getMovement()
    {
        return this.movement;
    }

    // Which methods should be forwarded to the rider?

    /*
    * Modifiers
    * */

    /*
    * Methods
    * */

    public Entity ejectRider()
    {
        Entity currRider = this.rider;
        this.rider = null;
        return currRider;
    }

    public Entity mount(Entity newRider)
    {
        this.rider = newRider;

        return this;
    }
}
