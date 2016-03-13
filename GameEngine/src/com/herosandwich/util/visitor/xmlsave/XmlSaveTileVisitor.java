package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.TileVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlSaveTileVisitor implements TileVisitor
{
    private Document doc;

    private Element tileNode = null;

    public XmlSaveTileVisitor(Document doc)
    {
        this.doc = doc;

        tileNode = doc.createElement("tiles");
    }

    @Override
    public void visitTile(Tile tile)
    {
        Element element = doc.createElement("tile");

        element = retrievePosition(tile, element);
        element = retrieveTerrainType(tile, element);
        element = retrieveEntities(tile, element);
        element = retrieveItems(tile, element);
        element = retrieveAoe(tile, element);

        tileNode.appendChild(element);
    }

    public Element retrievePosition(Tile tile, Element e)
    {
        PositionHex position = tile.getPosition();

        int q = position.getQ();
        int r = position.getR();
        int s = position.getS();

        e.setAttribute("q", Integer.toString(q));
        e.setAttribute("r", Integer.toString(r));
        e.setAttribute("s", Integer.toString(s));

        return e;
    }

    public Element retrieveTerrainType(Tile tile, Element e)
    {
        e.setAttribute("terrain-type", tile.getTerrain().toString().toLowerCase());

        return e;
    }

    public Element retrieveItems(Tile tile, Element e)
    {
        XmlSaveItemVisitor visitor = new XmlSaveItemVisitor(doc);

        tile.acceptItemVisitor(visitor);

        e.appendChild(visitor.retrieveSavedObject());

        return e;
    }

    public Element retrieveAoe(Tile tile, Element e)
    {
        XmlSaveAoEVisitor visitor = new XmlSaveAoEVisitor(doc);

        tile.acceptAoEVisitor(visitor);

        e.appendChild(visitor.retrieveSavedObject());

        return e;
    }

    public Element retrieveEntities(Tile tile, Element e)
    {
        XmlSaveEntityVisitor visitor = new XmlSaveEntityVisitor(doc);

        tile.acceptEntityVisitor(visitor);

        e.appendChild(visitor.retrieveSavedObject());

        return e;
    }

    public Node retrieveSavedItem()
    {
        Node node = this.tileNode;

        this.tileNode = null;

        return node;
    }
}
