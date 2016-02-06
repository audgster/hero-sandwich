package models.items;

import models.entities.*;

public class EquipableItem extends TakeableItem
{

    /* ATTRIBUTES */
    EquipmentType eType;
    StatModifiers statsBoosts;
    StatModifiers statsRestrictions;
    String occupRestriction = "";

    @Override
    public boolean executeInteraction(Entity entity) {
        return entity.addItem(this);
    }
    public StatModifiers setStatRestrictions(StatModifiers s){
    	statsRestrictions = s;
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

    /* Constructor */
    public EquipableItem(String name, EquipmentType eType, StatModifiers statsMods, StatModifiers statRestrict, String occRestrict)
    {
        super(name);
	this.eType = eType;
	statsBoosts = statsMods;
	statsRestrictions = statsRestrict;
	String occupRestriction = occRestrict;
    }

    @Override
    String toString() {
	String str = "";
	return str;
    }
}
