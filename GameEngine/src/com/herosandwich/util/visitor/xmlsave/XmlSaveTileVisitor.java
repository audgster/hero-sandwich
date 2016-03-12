package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.map.Tile;
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
    }

    @Override
    public void visitTile(Tile tile)
    {

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

    }

    public Node retrieveSavedItem()
    {
        Node node = this.tileNode;

        this.tileNode = null;

        return node;
    }
}
