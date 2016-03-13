package com.herosandwich.util.persistence;

import com.herosandwich.models.Game;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
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
    public Game loadGame() {
        Game game = new Game();

        Map map = loadMap();
        Player avater = loadAvatar(map);

        game.setAvatar(avater);
        game.setMap(map);

        return game;
    }

    public Map loadMap()
    {
        Element mapElement = (Element)saveDocument.getElementsByTagName("map").item(0);

        Node tilesNode = mapElement.getElementsByTagName("tiles").item(0);

        List<Node> tileList = makeFilteredList(tilesNode.getChildNodes());
        List<Tile> tiles = processTileNodes(tileList);

        Map map =  new Map(25);

        map.initialize(tiles);

        return map;
    }

    public Player loadAvatar(Map map)
    {
        return new Player();
    }

    private List<Node> makeFilteredList(NodeList list) {
        List<Node> nodeArray = new ArrayList<>();
        for(int i = 0; i < list.getLength(); i++)
            if(list.item(i).getNodeType() == Node.ELEMENT_NODE)
                nodeArray.add(list.item(i));

        return nodeArray;
    }

    private List<Tile> processTileNodes(List<Node> tileNodeList)
    {
        List<Tile> tileList = new ArrayList<>();

        for (Node n: tileNodeList)
        {
            Element tileElement = (Element)n;

            int q = Integer.parseInt(tileElement.getAttribute("q"));
            int r = Integer.parseInt(tileElement.getAttribute("r"));
            int s = Integer.parseInt(tileElement.getAttribute("s"));

            String terrainType = tileElement.getAttribute("terrain-type");

            Tile t = new Tile(new PositionHex(q, r, s), convertToEnum(terrainType));

            //Process AoEs

            //Process Items

            //Process Entities
            Node entityNode = tileElement.getElementsByTagName("entities").item(0);

            Entity entity = processEntity((Element)entityNode);

            tileList.add(t);
        }

        return tileList;
    }

    private Tile.Terrain convertToEnum(String s)
    {
        switch (s)
        {
            case "grass":
                return Tile.Terrain.GRASS;
            case "mountain":
                return Tile.Terrain.MOUNTAIN;
            case "water":
                return Tile.Terrain.WATER;
            default:
                return Tile.Terrain.GRASS;
        }
    }

    private Entity processEntity(Element entity)
    {
        List<Node> filteredNodeList = makeFilteredList(entity.getChildNodes());

        if (filteredNodeList.size() == 1)
        {
            Element entityElement = (Element)filteredNodeList.get(0);

            String entityTag = entityElement.getTagName();

            switch (entityTag)
            {
                case "entity":
                case "pet":
                case "character":
                case "npc":
                case "mount":
                case "player":
                default:
                    return null;
            }
        }

        return null;
    }
}
