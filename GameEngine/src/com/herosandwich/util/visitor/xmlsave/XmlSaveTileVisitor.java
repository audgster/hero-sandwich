package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.map.Tile;
import com.herosandwich.util.DirectionHex;
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

        tileNode = doc.createElement("tile");
    }

    @Override
    public void visitTile(Tile tile)
    {
        retrievePosition(tile);

        retrieveEntities(tile);
    }

    public void retrievePosition(Tile tile)
    {
        PositionHex position = tile.getPosition();

        int q = position.getQ();
        int r = position.getR();
        int s = position.getS();

        tileNode.setAttribute("q", Integer.toString(q));
        tileNode.setAttribute("r", Integer.toString(r));
        tileNode.setAttribute("s", Integer.toString(s));
    }

    public void retrieveItems(Tile tile)
    {
        //tile.acceptItemVisitor();
    }

    public void retrieveAoe(Tile tile)
    {

    }

    public void retrieveEntities(Tile tile)
    {
        XmlSaveEntityVisitor visitor = new XmlSaveEntityVisitor(doc);

        tile.acceptEntityVisitor(visitor);

        tileNode.appendChild(visitor.retrieveSavedObject());
    }

    public Node retrieveSavedItem()
    {
        Node node = this.tileNode;

        this.tileNode = null;

        return node;
    }
}
