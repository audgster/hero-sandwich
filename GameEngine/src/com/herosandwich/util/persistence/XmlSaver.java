package com.herosandwich.util.persistence;

import com.herosandwich.models.Game;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

// Eventually make a saver superclass with the public interface for saving
public class XmlSaver implements Saver
{
    private Document doc;
    private String filePath;

    DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder icBuilder;

    // Should I do save path?
    public XmlSaver(String filePath)
    {
        this.filePath = filePath;

        icFactory = DocumentBuilderFactory.newInstance();

        try {
            icBuilder = icFactory.newDocumentBuilder();
            this.doc = icBuilder.newDocument();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    //Public interface of saver
    @Override
    public void saveGame(Game game)
    {}

    public void saveGameFile()
    {
        this.doc = icBuilder.newDocument();
    }

    private Node saveMap(Map map)
    {
        Element mapRoot = doc.createElement("map");

        for( Tile t : map.getTiles())
        {

        }

        return mapRoot;
    }

    private Node saveAvatarPosition(Character avatar)
    {
        Element avatarPosition = doc.createElement("avatar-position");

        int q = avatar.getPosition().getQ();
        int r = avatar.getPosition().getR();
        int s = avatar.getPosition().getS();

        String direction = avatar.getDirection().toString().toLowerCase();

        avatarPosition.setAttribute("q", Integer.toString(q));
        avatarPosition.setAttribute("r", Integer.toString(r));
        avatarPosition.setAttribute("s", Integer.toString(s));

        avatarPosition.setAttribute("direction", direction);

        return avatarPosition;
    }
}
