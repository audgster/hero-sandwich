package models.items;

import models.entities;

public class EquipableItem extends TakeableItem
{
    /* ATTRIBUTES */
    EquipmentType eType;
    StatModifiers statsRestrictions = new StatModifiers();
    String occupRestriction = "";
    
    
    
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
    public StatModifiers setStatRestrictions(StatModifiers s){
    	statRestrictions = s;
    }

    public String setOccupationRestriction(String s){
    	occupRestriction = s;
    }

    public StatModifiers getStatsRestrictions(){
    	return statsRestrictions;
    }

    public String getOccupationRestriction(){
    	return occupRestriction;
    }
}
