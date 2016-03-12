package com.herosandwich.util.persistence;

import com.herosandwich.models.Game;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.visitor.xmlsave.XmlSaveTileVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Eventually make a saver superclass with the public interface for saving
public class XmlSaver implements Saver
{
    private Document doc;
    private File file;

    DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder icBuilder;

    // Should I do save path?
    public XmlSaver(File saveFile)
    {
        this.file = saveFile;

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
    {
        Node mapElements = saveMap(game.getMap());
        Node avatarPosition = saveAvatarPosition(game.getAvatar());

        Node docRoot = doc.createElement("hero-sandwich");

        docRoot.appendChild(mapElements);
        docRoot.appendChild(avatarPosition);

        doc.appendChild(docRoot);

        writeGameFile();
    }

    public void writeGameFile()
    {
        try {
            PrintWriter writer = new PrintWriter(file);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            StreamResult fileWriter = new StreamResult(writer);
            transformer.transform(source, fileWriter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Node saveMap(Map map)
    {
        Element mapRoot = doc.createElement("map");

        XmlSaveTileVisitor visitor = new XmlSaveTileVisitor(doc);

        for( Tile t : map.getTiles())
        {
            t.acceptTileVisitor(visitor);
        }

        mapRoot.appendChild(visitor.retrieveSavedItem());

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
