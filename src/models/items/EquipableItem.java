package models.items;

import models.entities.*;

public class EquipableItem extends TakeableItem
{
	StatModifiers statRestrictions = new StatModifiers();
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

    public StatModifiers getStatRestrictions(){
    	return statRestrictions;
    }

    public String getOccupationRestriction(){
    	return occupRestriction;
    }
}
