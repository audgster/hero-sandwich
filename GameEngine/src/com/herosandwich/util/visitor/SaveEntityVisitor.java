package com.herosandwich.util.visitor;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SaveEntityVisitor implements EntityVisitor
{
    private Document doc;

    private Element entityNode = null;

    public SaveEntityVisitor(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public void visit(Entity entity)
    {
        retreiveStats(entity);
    }

    @Override
    public void visit(Character character)
    {
        retreiveStats(character);
    }

    @Override
    public void visit(Pet pet)
    {
        retreiveStats(pet);
    }

    @Override
    public void visit(Npc npc) {

    }

    @Override
    public void visit(Player player) {

    }

    public Node retriveSavedEntity()
    {
        return this.entityNode;
    }

    private void retreiveStats(Entity entity)
    {
        String name = entity.getName();

        int lives = entity.getLives();
        int strength = entity.getStrength();
        int agility = entity.getAgility();
        int intellect = entity.getIntellect();
        int hardiness = entity.getHardiness();
        int experience = entity.getExperience();
        int movement = entity.getMovement();

        int currentLife = entity.getCurrentLife();
        int currentMana = entity.getCurrentMana();

        entityNode = doc.createElement("Entity");

        entityNode.setAttribute("name", name);

        Element statsElement = doc.createElement("Stats");

        statsElement.setAttribute("lives"       , Integer.toString(lives));
        statsElement.setAttribute("strength"    , Integer.toString(strength));
        statsElement.setAttribute("agility"     , Integer.toString(agility));
        statsElement.setAttribute("intellect"   , Integer.toString(intellect));
        statsElement.setAttribute("hardiness"   , Integer.toString(hardiness));
        statsElement.setAttribute("experience"  , Integer.toString(experience));
        statsElement.setAttribute("movement"    , Integer.toString(movement));
        statsElement.setAttribute("currentLife" , Integer.toString(currentLife));
        statsElement.setAttribute("currentMana" , Integer.toString(currentMana));

        entityNode.appendChild(statsElement);
    }
}
