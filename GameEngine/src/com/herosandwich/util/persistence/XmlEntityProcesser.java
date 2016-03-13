package com.herosandwich.util.persistence;

import com.herosandwich.creation.entity.CharacterFactory;
import com.herosandwich.creation.entity.EntityFactory;
import com.herosandwich.creation.entity.PetFactory;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.occupation.Property;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Sneak;
import com.herosandwich.models.occupation.Summoner;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlEntityProcesser
{
    public Entity processEntityNode(Element entity)
    {
        String name = entity.getAttribute("name");

        // Process stat node
        Element statNode = (Element)entity.getElementsByTagName("stats").item(0);

        int agility = Integer.parseInt(statNode.getAttribute("agility"));
        int experience = Integer.parseInt(statNode.getAttribute("experience"));
        int hardiness = Integer.parseInt(statNode.getAttribute("hardiness"));
        int intellect = Integer.parseInt(statNode.getAttribute("intellect"));
        int strength = Integer.parseInt(statNode.getAttribute("strength"));
        int movement = Integer.parseInt(statNode.getAttribute("movement"));

        int lives = Integer.parseInt(statNode.getAttribute("lives"));

        int currentLife = Integer.parseInt(statNode.getAttribute("currentLife"));
        int currentMana = Integer.parseInt(statNode.getAttribute("currentMana"));

        // Process location node
        Element locationNode = (Element)entity.getElementsByTagName("location");

        DirectionHex direction = DirectionHex.convertFromString(locationNode.getAttribute("direction"));

        int q = Integer.parseInt(locationNode.getAttribute("q"));
        int r = Integer.parseInt(locationNode.getAttribute("r"));
        int s = Integer.parseInt(locationNode.getAttribute("s"));

        EntityFactory factory = new EntityFactory();

        Entity entityObj =  factory.vendCustomInstance(
                name,
                lives,
                strength,
                agility,
                intellect,
                hardiness,
                experience,
                movement,
                new ModiferWithWeightStatStrategy(10)
        );

        entityObj.setCurrentMana(currentMana);
        entityObj.setCurrentLife(currentLife);

        entityObj.updatePosition(new PositionHex(q,r,s));
        entityObj.updateDirection(direction);

        return entityObj;
    }

    public Pet processPetNode(Element pet)
    {
        PetFactory factory = new PetFactory();

        Entity entity = processEntityNode(pet);

        return factory.transformFromEntity(entity);
    }

    public Character processCharacterNode(Element character)
    {
        CharacterFactory factory = new CharacterFactory();

        Entity entity = processEntityNode(character);

        // occupation
        Element occupation = (Element)character.getElementsByTagName("occupation");
        String occupString = occupation.getTextContent().toLowerCase();

        Property occup;

        switch (occupString)
        {
            case "summoner":
                occup = new Summoner();
            case "smasher":
                occup = new Smasher();
            case "sneak":
                occup = new Sneak();
            default:
                occup = new Smasher();
        }

        Character characterObj = factory.transfromEntity(entity, occup);

        // inventory
        // TODO: implement when mitch finishes the look up table

        // equipment
        // TODO: implement when mitch finishes the look up table

        // skill points
        Element skillPoints = (Element)character.getElementsByTagName("skillpoints");
        NodeList skillpointlist = skillPoints.getChildNodes();

        for (int i = 0; i < skillpointlist.getLength(); i++)
        {
            Element skill = (Element)skillpointlist.item(i);

            Skill skillObj = Skill.convertFromString(skill.getAttribute("skillName"));

            int skillPointAmount = Integer.parseInt(skill.getAttribute("pointAmount"));

            characterObj.allocateSkillPoints(skillObj, skillPointAmount);
        }

        return characterObj;
    }

    public Npc processNpcNode(Element npc)
    {
        return new Npc();
    }

    public Mount processMountNode(Element mount)
    {
        return new Mount();
    }

    public Player processPlayerNode(Element player)
    {
        return new Player();
    }
}
