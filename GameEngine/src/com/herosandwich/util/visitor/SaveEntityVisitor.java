package com.herosandwich.util.visitor;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class SaveEntityVisitor implements EntityVisitor
{
    private Document doc;

    private Element entityNode = null;

    public SaveEntityVisitor(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public void visitEntity(Entity entity)
    {
        retrieveStats(entity);
    }

    @Override
    public void visitCharacter(Character character)
    {
        retrieveStats(character);
        retrieveOccupation(character);
        retrieveInventory(character);
        retrieveEquipment(character);
        retrieveSkillPoints(character);
    }

    @Override
    public void visitPet(Pet pet)
    {
        retrieveStats(pet);
    }

    @Override
    public void visitNpc(Npc npc) {
        retrieveStats(npc);
        retrieveOccupation(npc);
        retrieveInventory(npc);
        retrieveEquipment(npc);
        retrieveSkillPoints(npc);
    }

    @Override
    public void visitPlayer(Player player) {
        retrieveStats(player);
        retrieveOccupation(player);
        retrieveInventory(player);
        retrieveEquipment(player);
        retrieveSkillPoints(player);
    }

    @Override
    public void visitMount(Mount mount)
    {
        retrieveMountStats(mount);
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

    private void retrieveOccupation(Character character)
    {
        String occupation = character.getOccupation().toString();

        Element occup = doc.createElement("occupation");

        Text occupText = doc.createTextNode(occupation.toLowerCase());

        occup.appendChild(occupText);

        entityNode.appendChild(occup);
    }

    private void retrieveInventory(Character character)
    {
        SaveInventoryVisitor visitor = new SaveInventoryVisitor(doc);
        character.getInventory().accept(visitor);

        entityNode.appendChild(visitor.retrieveSavedObject());
    }

    private void retrieveEquipment(Character character)
    {
        SaveEquipmentVisitor visitor = new SaveEquipmentVisitor(doc);
        character.getEquipment().accept(visitor);

        entityNode.appendChild(visitor.retrieveSavedObject());
    }

    private void retrieveSkillPoints(Character character)
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

        entityNode.appendChild(skills);
    }

    private void retrieveSkillPoints(Player player)
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

        entityNode.appendChild(skills);
    }

    private void retrieveMountStats(Mount mount)
    {
        int movement = mount.getMovement();

        String name = mount.getName();

        entityNode = doc.createElement("Mount");

        entityNode.setAttribute("name", name);
        entityNode.setAttribute("mount-movement", Integer.toString(movement));

        if (mount.getRider() != null)
        {
            SaveEntityVisitor riderVisitor = new SaveEntityVisitor(doc);
            mount.getRider().accept(riderVisitor);
            entityNode.appendChild(riderVisitor.retrieveSavedObject());
        }
    }

    public Node retrieveSavedObject() {
        Node node = this.entityNode;

        this.entityNode = null;

        return node;
    }
}
