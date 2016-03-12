package com.herosandwich.models.map.aoe;

public interface Trap
{
    boolean isDiscovered();
    boolean isActive();

    void deactivate();
    void activate();
}
