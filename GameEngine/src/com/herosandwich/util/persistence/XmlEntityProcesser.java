package com.herosandwich.util.persistence;

import com.herosandwich.creation.entity.*;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Sneak;
import com.herosandwich.models.occupation.Summoner;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

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

        Occupation occup;

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
        NpcFactory factory = new NpcFactory();

        Character character = processCharacterNode(npc);

        // TODO Parse out trade
        // TODO Parse out attitude
        // TODO Parse out things to say

        return factory.vendDefaultInstance();
    }

    public Mount processMountNode(Element mount)
    {
        String name = mount.getAttribute("name");

        int movement = Integer.parseInt(mount.getAttribute("movement"));

        Element location = (Element)mount.getElementsByTagName("location").item(0);

        int q = Integer.parseInt(location.getAttribute("q"));
        int r = Integer.parseInt(location.getAttribute("r"));
        int s = Integer.parseInt(location.getAttribute("s"));

        MountFactory factory = new MountFactory();

        Mount mountObj = factory.vendCustomMount(name, movement, null);

        if (mount.hasChildNodes())
        {
            Element rider = (Element) mount.getElementsByTagName("rider").item(0);

            List<Node> riderObjlist= makeFilteredList(rider.getChildNodes());

            Element riderObj = (Element) riderObjlist.get(0);

            Character character;

            if (riderObj.getNodeName() == "character")
                character  = processCharacterNode(riderObj);
            else
                character = processPlayerNode(riderObj);

            mountObj.mount(character);
        }

        mountObj.updatePosition(new PositionHex(q,r,s));

        return mountObj;
    }

    public Player processPlayerNode(Element player)
    {
        PlayerFactory factory = new PlayerFactory();

        Character character = processCharacterNode(player);

        Element skillPointsAvail = (Element)player.getElementsByTagName("skillpoints");

        int availablepoints = Integer.parseInt(skillPointsAvail.getAttribute("available"));

        return factory.transformFromCharacter(character, availablepoints);
    }

    private List<Node> makeFilteredList(NodeList list) {
        List<Node> nodeArray = new ArrayList<>();
        for(int i = 0; i < list.getLength(); i++)
            if(list.item(i).getNodeType() == Node.ELEMENT_NODE)
                nodeArray.add(list.item(i));

        return nodeArray;
    }
}
