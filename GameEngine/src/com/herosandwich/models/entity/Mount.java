package com.herosandwich.models.entity;

public class Mount extends Entity
{
    private Entity rider;

    public Mount()
    {
        rider = null;
    }

    public Mount(Entity entity)
    {
        this.rider = entity;
    }

    /*
    * Accessors
    * */

    public Entity getRider()
    {
        return this.rider;
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
