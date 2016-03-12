package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.map.aoe.*;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSaveAoEVisitor implements AoEVisitor
{
    private Document doc;

    private Element aoeElement;

    public XmlSaveAoEVisitor(Document doc)
    {
        this.doc = doc;

        aoeElement = doc.createElement("aoes");
    }

    @Override
    public void visitAoE(AoE aoE)
    {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        doc.appendChild(element);
    }

    @Override
    public void visitInstaDeathAoE(InstaDeathAoE aoE) {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        doc.appendChild(element);
    }

    @Override
    public void visitXpAoE(XpAoE aoE) {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        int xp = aoE.getXpPerTick();

        element.setAttribute("xp-per-tick", Integer.toString(xp));

        doc.appendChild(element);
    }

    @Override
    public void visitHealDamageAoE(HealDamageAoE aoE) {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        int heal = aoE.getHealPerTick();

        element.setAttribute("heal-per-tick", Integer.toString(heal));

        doc.appendChild(element);
    }

    @Override
    public void visitTakeDamageAoE(TakeDamageAoE aoE) {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        int dmg = aoE.getDamagePerTick();

        element.setAttribute("dmg-per-tick", Integer.toString(dmg));

        doc.appendChild(element);
    }

    @Override
    public void visitTeleportAoE(TeleportAoE aoE) {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        Element destPos = doc.createElement("destination");

        destPos.setAttribute("q", Integer.toString(aoE.getDestination().getQ()));
        destPos.setAttribute("r", Integer.toString(aoE.getDestination().getR()));
        destPos.setAttribute("s", Integer.toString(aoE.getDestination().getS()));

        element.appendChild(destPos);

        doc.appendChild(element);
    }

    @Override
    public void visitTrapAoE(InstantDamageAoETrap aoE) {
        Element element = retrieveNameElement(aoE);
        element = retrievePosition(element, aoE);

        element.setAttribute("dmg-amt", Integer.toString(aoE.getInstantDamage()));

        doc.appendChild(element);
    }

    private Element retrievePosition(Element element, AoE aoE)
    {
        PositionHex pos = aoE.getPosition();

        element.setAttribute("q", Integer.toString(pos.getQ()));
        element.setAttribute("r", Integer.toString(pos.getR()));
        element.setAttribute("s", Integer.toString(pos.getS()));

        return element;
    }

    private Element retrieveNameElement(AoE aoE)
    {
        return doc.createElement(aoE.toString());
    }
}
