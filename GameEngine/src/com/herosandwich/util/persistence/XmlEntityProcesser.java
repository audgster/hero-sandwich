package com.herosandwich.util.persistence;

import com.herosandwich.creation.entity.*;
import com.herosandwich.creation.init.ItemInit;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Sneak;
import com.herosandwich.models.occupation.Summoner;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.movement.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.List;

public class XmlEntityProcesser
{
    public Entity processEntityNode(Element entity)
    {
        String name = entity.getAttribute("name");

        MovementVisitor visitor;

        String visitorString = entity.getAttribute("move-visitor").toLowerCase();

        switch (visitorString)
        {
            case "alpine":
                visitor = new AlpineMovementVisitor();
                break;
            case "amphibious":
                visitor = new AmphibiousMovementVisitor();
                break;
            case "aquatic":
                visitor = new AquaticMovementVisitor();
                break;
            case "flying":
                visitor = new FlyingMovementVisitor();
                break;
            case "ground":
                visitor = new GroundMovementVisitor();
                break;
            default:
                throw new IllegalArgumentException("String " + " could not be converted to a Movement Visitor");
        }


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
        Element locationNode = (Element)entity.getElementsByTagName("location").item(0);

        DirectionHex direction = DirectionHex.convertFromString(locationNode.getAttribute("direction"));

        PositionHex pos = XmlUtil.extractPosition(locationNode);

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
                new ModiferWithWeightStatStrategy(10),
                visitor
        );

        entityObj.setCurrentMana(currentMana);
        entityObj.setCurrentLife(currentLife);

        entityObj.updatePosition(pos);
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
        Element occupation = (Element)character.getElementsByTagName("occupation").item(0);
        String occupString = occupation.getTextContent().toLowerCase();

        Occupation occup;

        switch (occupString)
        {
            case "summoner":
                occup = new Summoner();
                break;
            case "smasher":
                occup = new Smasher();
                break;
            case "sneak":
                occup = new Sneak();
                break;
            default:
                throw new IllegalArgumentException("Cannot convert type " + occupString + " to an occupation");
        }

        Character characterObj = factory.transfromEntity(entity, occup);

        ItemInit init = ItemInit.getInstance();

        // equipment
        Element equipmentElement = (Element)character.getElementsByTagName("equipment").item(0);

        List<Node> equipmentList = XmlUtil.getElementNodesAsList(equipmentElement.getChildNodes());

        for (Node n : equipmentList)
        {
            int id = Integer.parseInt(((Element)n).getAttribute("item-id"));

            EquipableItem item = init.getEquipableItem(id);

            characterObj.equipItem(item);
        }

        // inventory
        Element inventoryElement = (Element)character.getElementsByTagName("items").item(0);

        List<Node> inventoryList = XmlUtil.getElementNodesAsList(inventoryElement.getChildNodes());

        for (Node n : inventoryList)
        {
            int id = Integer.parseInt(((Element)n).getAttribute("item-id"));

            TakeableItem item = init.getTakeableItem(id);

            characterObj.insertItemToInventory(item);
        }

        // skill points
        Element skillPoints = (Element)character.getElementsByTagName("skillpoints").item(0);
        NodeList skillpointlist = skillPoints.getChildNodes();

        for (int i = 0; i < skillpointlist.getLength(); i++)
        {
            Element skill = (Element)skillpointlist.item(i);

            Skill skillObj = Skill.convertFromString(skill.getAttribute("skillName"));

            int skillPointAmount = Integer.parseInt(skill.getAttribute("pointAmount"));

            characterObj.allocateSkillPoints(skillObj, skillPointAmount);
        }

        Element currency = (Element) character.getElementsByTagName("cash").item(0);

        int currencyAmt = Integer.parseInt(currency.getAttribute("amount"));

        return characterObj;
    }

    public Npc processNpcNode(Element npc)
    {
        NpcFactory factory = new NpcFactory();

        Character character = processCharacterNode(npc);

        // Parse out sell
        HashMap<Integer, Integer> sales = new HashMap<>();
        Element salesElement = (Element) npc.getElementsByTagName("sales").item(0);
        List<Node> salesList = XmlUtil.getElementNodesAsList(salesElement.getChildNodes());

        for (Node n : salesList)
        {
            Element sale = (Element)n;

            int itemId = Integer.parseInt(sale.getAttribute("item-id"));
            int price = Integer.parseInt(sale.getAttribute("price"));

            sales.put(itemId, price);
        }

        // Parse out buy
        HashMap<Integer, Integer> buys = new HashMap<>();
        Element buysElement = (Element) npc.getElementsByTagName("buys").item(0);
        List<Node> buysList = XmlUtil.getElementNodesAsList(buysElement.getChildNodes());

        for (Node n : buysList)
        {
            Element buy = (Element)n;

            int itemId = Integer.parseInt(buy.getAttribute("item-id"));
            int price = Integer.parseInt(buy.getAttribute("price"));

            buys.put(itemId, price);
        }

        // Parse out attitude
        Element attitude = (Element) npc.getElementsByTagName("towards-player").item(0);
        Attitude attitudeToPlayer = Attitude.convertFromString(attitude.getAttribute("attitude"));

        // Parse out things to say
        Element thingsToSay = (Element)npc.getElementsByTagName("things-to-say").item(0);
        List<Node> thingsToSayList = XmlUtil.getElementNodesAsList(thingsToSay.getChildNodes());

        String[] things2say = new String[thingsToSayList.size()];
        for (int i = 0; i < thingsToSayList.size(); i++)
        {
            String thingToSay = ((Element)thingsToSayList.get(i)).getAttribute("text");

            things2say[i] = thingToSay;
        }

        return factory.transformFromCharacter(character, attitudeToPlayer, sales, buys, things2say);
    }

    public Mount processMountNode(Element mount)
    {
        String name = mount.getAttribute("name");

        int movement = Integer.parseInt(mount.getAttribute("movement"));

        MovementVisitor visitor;
        String visitorString = mount.getAttribute("move-visitor").toLowerCase();

        switch (visitorString)
        {
            case "alpine":
                visitor = new AlpineMovementVisitor();
                break;
            case "amphibious":
                visitor = new AmphibiousMovementVisitor();
                break;
            case "aquatic":
                visitor = new AquaticMovementVisitor();
                break;
            case "flying":
                visitor = new FlyingMovementVisitor();
                break;
            case "ground":
                visitor = new GroundMovementVisitor();
                break;
            default:
                throw new IllegalArgumentException("String " + " could not be converted to a Movement Visitor");
        }

        Element location = (Element)mount.getElementsByTagName("location").item(0);

        PositionHex pos = XmlUtil.extractPosition(location);

        MountFactory factory = new MountFactory();

        Mount mountObj = factory.vendCustomMount(name, movement, null, visitor);

        if (mount.hasChildNodes())
        {
            Element rider = (Element) mount.getElementsByTagName("rider").item(0);

            List<Node> riderObjlist= XmlUtil.getElementNodesAsList(rider.getChildNodes());

            Element riderObj = (Element) riderObjlist.get(0);

            Character character;

            if (riderObj.getNodeName() == "character")
                character  = processCharacterNode(riderObj);
            else
                character = processPlayerNode(riderObj);

            mountObj.mount(character);
        }

        mountObj.updatePosition(pos);

        return mountObj;
    }

    public Player processPlayerNode(Element player)
    {
        PlayerFactory factory = new PlayerFactory();

        Character character = processCharacterNode(player);

        Element skillPointsAvail = (Element)player.getElementsByTagName("skillpoints").item(0);

        int availablepoints = Integer.parseInt(skillPointsAvail.getAttribute("available"));

        return factory.transformFromCharacter(character, availablepoints);
    }
}
