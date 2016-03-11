package com.herosandwich.util.visitor;

import com.herosandwich.models.equipment.Equipment;

public interface EquipmentVisitor
{
    void visitEquipment(Equipment equipment);
}
