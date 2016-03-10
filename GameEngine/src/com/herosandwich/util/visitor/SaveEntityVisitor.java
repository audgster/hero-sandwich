package com.herosandwich.util.visitor;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class SaveEntityVisitor extends SaveVisitor implements EntityVisitor
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
        retrieveStats(entity);
    }

    @Override
    public void visit(Character character)
    {
        retrieveStats(character);
        retriveOccupation(character);
        retrieveInventory(character);
        retrieveEquipment(character);
    }

    @Override
    public void visit(Pet pet)
    {
        retrieveStats(pet);
    }

    @Override
    public void visit(Npc npc) {
        retrieveStats(npc);
    }

    @Override
    public void visit(Player player) {
        retrieveStats(player);
    }


    private void retrieveStats(Entity entity)
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

    private void retriveOccupation(Character character)
    {
        String occupation = character.getOccupation().toString();

        Element occup = doc.createElement("occupation");

        Text occupText = doc.createTextNode(occupation);

        occup.appendChild(occupText);

        entityNode.appendChild(occup);
    }

    private void retrieveInventory(Character character)
    {
        SaveInventoryVisitor visitor = new SaveInventoryVisitor(doc);
        character.getInventory().accept(visitor);

        entityNode.appendChild(visitor.retreiveSavedObject());
    }

    private void retrieveEquipment(Character character)
    {
        SaveEquipmentVisitor visitor = new SaveEquipmentVisitor(doc);
        character.getEquipment().accept(visitor);

        entityNode.appendChild(visitor.retreiveSavedObject());
    }

    @Override
    public Node retreiveSavedObject() {
        Node node = this.entityNode;

        this.entityNode = null;

        return node;
    }
}
