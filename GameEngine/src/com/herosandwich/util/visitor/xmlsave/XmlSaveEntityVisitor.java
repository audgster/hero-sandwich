package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.visitor.EntityVisitor;
import org.w3c.dom.*;

import java.util.HashMap;
import java.util.Map;

public class XmlSaveEntityVisitor implements EntityVisitor
{
    private Document doc;

    private Element entityNode = null;

    public XmlSaveEntityVisitor(Document doc)
    {
        this.doc = doc;

        entityNode = doc.createElement("entities");
    }

    @Override
    public void visitEntity(Entity entity)
    {
        Element entityElement = retrieveStats(entity, doc.createElement("entity"));
        entityElement = retrieveLocation(entity, entityElement);

        entityNode.appendChild(entityElement);
    }

    @Override
    public void visitCharacter(Character character)
    {
        Element entityElement = retrieveStats(character, doc.createElement("character"));
        entityElement = retrieveLocation(character, entityElement);
        entityElement = retrieveOccupation(character, entityElement);
        entityElement = retrieveInventory(character, entityElement);
        entityElement = retrieveEquipment(character, entityElement);
        entityElement = retrieveSkillPoints(character, entityElement);

        entityNode.appendChild(entityElement);
    }

    @Override
    public void visitPet(Pet pet)
    {
        Element entityElement = retrieveStats(pet, doc.createElement("pet"));
        entityElement = retrieveLocation(pet, entityElement);

        entityNode.appendChild(entityElement);
    }

    @Override
    public void visitNpc(Npc npc) {
        Element entityElement = retrieveStats(npc, doc.createElement("npc"));
        entityElement = retrieveLocation(npc, entityElement);
        entityElement = retrieveOccupation(npc, entityElement);
        entityElement = retrieveInventory(npc, entityElement);
        entityElement = retrieveEquipment(npc, entityElement);
        entityElement = retrieveSkillPoints(npc, entityElement);

        entityNode.appendChild(entityElement);
    }

    @Override
    public void visitPlayer(Player player) {
        Element entityElement = retrieveStats(player, doc.createElement("player"));
        entityElement = retrieveLocation(player, entityElement);
        entityElement = retrieveOccupation(player, entityElement);
        entityElement = retrieveInventory(player, entityElement);
        entityElement = retrieveEquipment(player, entityElement);
        entityElement = retrieveSkillPoints(player, entityElement);

        entityNode.appendChild(entityElement);
    }

    @Override
    public void visitMount(Mount mount)
    {
        Element entityElement = retrieveMountStats(mount, doc.createElement("mount"));
        entityElement = retrieveLocation(mount, entityElement);

        entityNode.appendChild(entityElement);
    }

    private Element retrieveStats(Entity entity, Element entityElement)
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

        entityElement.setAttribute("name", name);

        Element statsElement = doc.createElement("stats");

        statsElement.setAttribute("lives"       , Integer.toString(lives));
        statsElement.setAttribute("strength"    , Integer.toString(strength));
        statsElement.setAttribute("agility"     , Integer.toString(agility));
        statsElement.setAttribute("intellect"   , Integer.toString(intellect));
        statsElement.setAttribute("hardiness"   , Integer.toString(hardiness));
        statsElement.setAttribute("experience"  , Integer.toString(experience));
        statsElement.setAttribute("movement"    , Integer.toString(movement));
        statsElement.setAttribute("currentLife" , Integer.toString(currentLife));
        statsElement.setAttribute("currentMana" , Integer.toString(currentMana));

        entityElement.appendChild(statsElement);

        return entityElement;
    }

    private Element retrieveLocation(Entity entity, Element entityElement)
    {
        String direction = entity.getDirection().toString().toLowerCase();

        int q = entity.getPosition().getQ();
        int r = entity.getPosition().getR();
        int s = entity.getPosition().getS();

        Element locationElement = doc.createElement("location");

        locationElement.setAttribute("q", Integer.toString(q));
        locationElement.setAttribute("r", Integer.toString(r));
        locationElement.setAttribute("s", Integer.toString(s));

        locationElement.setAttribute("direction", direction);

        entityElement.appendChild(locationElement);

        return entityElement;
    }

    private Element retrieveOccupation(Character character, Element entityElement)
    {
        String occupation = character.getOccupation().toString();

        Element occup = doc.createElement("occupation");

        Text occupText = doc.createTextNode(occupation.toLowerCase());

        occup.appendChild(occupText);

        entityElement.appendChild(occup);

        return entityElement;
    }

    private Element retrieveInventory(Character character, Element entityElement)
    {
        XmlSaveInventoryVisitor visitor = new XmlSaveInventoryVisitor(doc);
        character.getInventory().accept(visitor);

        entityElement.appendChild(visitor.retrieveSavedObject());

        return entityElement;
    }

    private Element retrieveEquipment(Character character, Element entityElement)
    {
        XmlSaveEquipmentVisitor visitor = new XmlSaveEquipmentVisitor(doc);
        character.getEquipment().accept(visitor);

        entityElement.appendChild(visitor.retrieveSavedObject());

        return entityElement;
    }

    private Element retrieveSkillPoints(Character character, Element entityElement)
    {
        Element skills = doc.createElement("skillpoints");

        HashMap<Skill, Integer> skillPoints = character.getSkillPoints();

        for (Map.Entry<Skill, Integer> e : skillPoints.entrySet())
        {
            Element skill = doc.createElement("skill");

            skill.setAttribute("skillName", e.getKey().toString().toLowerCase());
            skill.setAttribute("pointAmount", e.getValue().toString().toLowerCase());

            skills.appendChild(skill);
        }

        entityElement.appendChild(skills);

        return entityElement;
    }

    private Element retrieveSkillPoints(Player player, Element entityElement)
    {
        Element skills = doc.createElement("skillpoints");

        int available = player.getAvailablePoints();

        skills.setAttribute("available", Integer.toString(available));

        HashMap<Skill, Integer> skillPoints = player.getSkillPoints();

        for (Map.Entry<Skill, Integer> e : skillPoints.entrySet())
        {
            Element skill = doc.createElement("skill");

            skill.setAttribute("skillName", e.getKey().toString().toLowerCase());
            skill.setAttribute("pointAmount", e.getValue().toString().toLowerCase());

            skills.appendChild(skill);
        }

        entityElement.appendChild(skills);

        return entityElement;
    }

    private Element retrieveMountStats(Mount mount, Element element)
    {
        int movement = mount.getMovement();

        String name = mount.getName();

        element.setAttribute("name", name);
        element.setAttribute("movement", Integer.toString(movement));

        if (mount.getRider() != null)
        {
            XmlSaveEntityVisitor riderVisitor = new XmlSaveEntityVisitor(doc);
            mount.getRider().accept(riderVisitor);

            Node rider = riderVisitor.retrieveSavedObject();

            Element riderElement = doc.createElement("rider");

            Node riderNode = rider.getFirstChild();

            riderElement.appendChild(riderNode);

            element.appendChild(riderElement);
        }

        return element;
    }

    public Node retrieveSavedObject() {
        Node node = this.entityNode;

        this.entityNode = null;

        return node;
    }
}