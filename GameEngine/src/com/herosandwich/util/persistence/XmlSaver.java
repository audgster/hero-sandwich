package com.herosandwich.util.persistence;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.map.Map;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.XmlSaveEntityVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Collection;

// Eventually make a saver superclass with the public interface for saving
public class XmlSaver
{
    private String saveName;

    private Document doc;

    // Should I do save path?
    public XmlSaver(String saveName)
    {
        this.saveName = saveName;

        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
    }

    //Public interface of saver
    //@Override
    //public void saveGame(Game game)
    //{}

    private Node saveEntities(Collection<Entity> entities)
    {
        Element entitiesElement = doc.createElement("Entities");

        for (Entity e : entities)
        {
            XmlSaveEntityVisitor eVisitor = new XmlSaveEntityVisitor(doc);

            e.accept(eVisitor);

            Node node = eVisitor.retrieveSavedObject();

            entitiesElement.appendChild(node);
        }

        return entitiesElement;
    }

    private Node saveMaps(Collection<Map> maps)
    {
        Element mapsElement = doc.createElement("Maps");

        return mapsElement;
    }
}
