package com.herosandwich.util.persistence;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.SaveEntityVisitor;

import java.util.Collection;

public class Saver
{
    public void saveEntities(Collection<Entity> entities)
    {
        for (Entity e : entities)
        {
            //EntityVisitor eVisitor = new SaveEntityVisitor();

            //e.accept(eVisitor);
        }
    }

    public void saveMaps() {}
}
