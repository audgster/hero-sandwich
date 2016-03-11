package com.herosandwich.util.visitor;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;

public interface EntityVisitor
{
    void visitEntity(Entity entity);
    void visitCharacter(Character character);
    void visitPet(Pet pet);
    void visitNpc(Npc npc);
    void visitPlayer(Player player);
    void visitMount(Mount mount);
}
