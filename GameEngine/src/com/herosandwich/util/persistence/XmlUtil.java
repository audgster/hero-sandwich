package com.herosandwich.util.persistence;

import com.herosandwich.util.PositionHex;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class XmlUtil
{
    public static List<Node> getElementNodesAsList(NodeList list) {
        List<Node> nodeArray = new ArrayList<>();
        for(int i = 0; i < list.getLength(); i++)
            if(list.item(i).getNodeType() == Node.ELEMENT_NODE)
                nodeArray.add(list.item(i));

        return nodeArray;
    }

    public static PositionHex extractPosition(Element element)
    {
        int q = Integer.parseInt(element.getAttribute("q"));
        int r = Integer.parseInt(element.getAttribute("r"));
        int s = Integer.parseInt(element.getAttribute("s"));

        return new PositionHex(q,r,s);
    }

    public static int extractAttributeAsInt(Element element, String attribute)
    {
        return Integer.parseInt(element.getAttribute(attribute));
    }
}
