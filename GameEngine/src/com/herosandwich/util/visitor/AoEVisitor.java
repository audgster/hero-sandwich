package com.herosandwich.util.visitor;

import com.herosandwich.models.map.aoe.*;

public interface AoEVisitor
{
    void visitAoE(AoE aoE);
    void visitInstaDeathAoE(InstaDeathAoE aoE);
    void visitXpAoE(XpAoE aoE);
    void visitHealDamageAoE(HealDamageAoE aoE);
    void visitTakeDamageAoE(TakeDamageAoE aoE);
    void visitTeleportAoE(TeleportAoE aoE);
    void visitTrap(Trap aoE);
}
