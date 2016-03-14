package com.herosandwich.util.persistence;

import com.herosandwich.creation.init.ItemInit;
import com.herosandwich.models.Game;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.items.Item;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.models.map.aoe.AoE;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import javafx.geometry.Pos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlLoader implements Loader
{
    File saveFile;
    Document saveDocument;

    DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder icBuilder;

    public XmlLoader(File saveFile)
    {
        this.saveFile = saveFile;

        try {
            icBuilder = icFactory.newDocumentBuilder();
            this.saveDocument = icBuilder.parse(saveFile);

            this.saveDocument.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game loadGame()
    {
        Game game = new Game();

        Map map = loadMap();
        Character avatar = loadAvatar(map);

        game.setMap(map);
        game.setAvatar(avatar);

        return game;
    }

    @Override
    public Game loadGame(Character newPlayer) {
        Game game = new Game();

        Map map = loadMap();
        PositionHex pos = getAvatarPostition();

        //System.out.println(map.getTile(pos).getTerrain());

        map.addEntity(pos, newPlayer);

        game.setAvatar(newPlayer);
        game.setMap(map);

        return game;
    }

    public Map loadMap()
    {
        Element mapElement = (Element)saveDocument.getElementsByTagName("map").item(0);

        Node tilesNode = mapElement.getElementsByTagName("tiles").item(0);

        List<Node> tileList = XmlUtil.getElementNodesAsList(tilesNode.getChildNodes());
        List<Tile> tiles = processTileNodes(tileList);

        Map map =  new Map(25);

        map.initialize(tiles);

        return map;
    }

    private PositionHex getAvatarPostition()
    {
        Element avatarPosition = (Element)saveDocument.getElementsByTagName("avatar-position").item(0);

        PositionHex pos = XmlUtil.extractPosition(avatarPosition);

        return pos;
    }

    public Character loadAvatar(Map map)
    {
        Element avatarPosition = (Element)saveDocument.getElementsByTagName("avatar-position").item(0);

        PositionHex pos = getAvatarPostition();
        DirectionHex dir = DirectionHex.convertFromString(avatarPosition.getAttribute("direction"));

        Tile tile = map.getTile(pos);

        Character character = (Character) tile.getEntity();

        character.updateDirection(dir);

        return character;
    }

    private List<Tile> processTileNodes(List<Node> tileNodeList)
    {
        List<Tile> tileList = new ArrayList<>();

        for (Node n: tileNodeList)
        {
            Element tileElement = (Element)n;

            PositionHex pos = XmlUtil.extractPosition(tileElement);
            String terrainType = tileElement.getAttribute("terrain-type");

            Tile t = new Tile(pos, Tile.Terrain.convertFromString(terrainType));

            //Process AoEs
            Element aoeElements = (Element)tileElement.getElementsByTagName("aoes").item(0);
            List<Node> aoes = XmlUtil.getElementNodesAsList(aoeElements.getChildNodes());

            for (Node m : aoes)
            {
                AoE currentAoE = processAoE((Element)m);

                t.addAoE(currentAoE);
            }

            //Process Items
            Element itemElements = (Element)tileElement.getElementsByTagName("tile-items").item(0);
            List<Node> items = XmlUtil.getElementNodesAsList(itemElements.getChildNodes());

            ItemInit init = ItemInit.getInstance();

            for (Node m : items)
            {
                int itemId = XmlUtil.extractAttributeAsInt((Element)m, "item-id");

                Item itemObj = init.getItem(itemId);

                t.addItem(itemObj);
            }

            //Process Entities
            Node entityNode = tileElement.getElementsByTagName("entities").item(0);

            Entity entity = processEntity((Element)entityNode);

            if (entity != null)
            {
                t.addEntity(entity);
            }

            tileList.add(t);
        }

        return tileList;
    }

    private Entity processEntity(Element entity)
    {
        List<Node> filteredNodeList = XmlUtil.getElementNodesAsList(entity.getChildNodes());

        if (filteredNodeList.size() == 1)
        {
            XmlEntityProcesser processer = new XmlEntityProcesser();

            Element entityElement = (Element)filteredNodeList.get(0);

            String entityTag = entityElement.getTagName();

            switch (entityTag)
            {
                case "entity":
                    return processer.processEntityNode(entityElement);
                case "pet":
                    return processer.processPetNode(entityElement);
                case "character":
                    return processer.processCharacterNode(entityElement);
                case "npc":
                    return processer.processNpcNode(entityElement);
                case "mount":
                    return processer.processMountNode(entityElement);
                case "player":
                    return processer.processPlayerNode(entityElement);
                default:
                    return null;
            }
        }

        return null;
    }

    private AoE processAoE(Element aoe)
    {
        String tagName = aoe.getTagName().toLowerCase();

        XmlAoeProcesser processer = new XmlAoeProcesser();

        switch (tagName)
        {
            case "healdamageaoe":
                return processer.processHealDamageElement(aoe);
            case "instadeathaoe":
                return processer.processInstaDeathElement(aoe);
            case "trap":
                return processer.processTrapElement(aoe);
            case "takedamageaoe":
                return processer.processTakeDamageElement(aoe);
            case "teleportaoe":
                return processer.processTeleporElement(aoe);
            case "xpaoe":
                return processer.processXpElement(aoe);
            default:
                return null;
        }
    }
}
