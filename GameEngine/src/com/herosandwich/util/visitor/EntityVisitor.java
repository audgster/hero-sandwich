package com.herosandwich.util.visitor;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;

public interface EntityVisitor
{
    void visit(Entity entity);
    void visit(Character character);
    void visit(Pet pet);
    void visit(Npc npc);
    void visit(Player player);
}
