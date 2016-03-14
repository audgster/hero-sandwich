package com.herosandwich.util.persistence;

import com.herosandwich.models.map.aoe.*;
import com.herosandwich.util.PositionHex;
import org.w3c.dom.Element;

public class XmlAoeProcesser
{
    public HealDamageAoE processHealDamageElement(Element healDamage)
    {
        int heal = XmlUtil.extractAttributeAsInt(healDamage, "heal-per-tick");
        PositionHex pos = XmlUtil.extractPosition(healDamage);

        return new HealDamageAoE(heal, pos);
    }

    public InstaDeathAoE processInstaDeathElement(Element instaDeath)
    {
        PositionHex pos = XmlUtil.extractPosition(instaDeath);

        return new InstaDeathAoE(pos);
    }

    public TakeDamageAoE processTakeDamageElement(Element takeDamage)
    {
        int damage = XmlUtil.extractAttributeAsInt(takeDamage, "dmg-per-tick");
        PositionHex pos = XmlUtil.extractPosition(takeDamage);

        return new TakeDamageAoE(damage, pos);
    }

    public TeleportAoE processTeleporElement(Element teleport)
    {
        Element destinationElement = (Element)teleport.getElementsByTagName("destination").item(0);
        PositionHex destination = XmlUtil.extractPosition(destinationElement);
        PositionHex pos = XmlUtil.extractPosition(teleport);

        return new TeleportAoE(destination, pos);
    }

    public XpAoE processXpElement(Element xp)
    {
        int xpPerTick = XmlUtil.extractAttributeAsInt(xp, "xp-per-tick");
        PositionHex pos = XmlUtil.extractPosition(xp);

        return new XpAoE(xpPerTick, pos);
    }
}
