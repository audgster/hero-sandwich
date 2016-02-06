package models.items;

import models.entities.*;

public class EquipableItem extends TakeableItem
{

    /* ATTRIBUTES */
    EquipmentType eType;
    StatModifiers statsBoosts;
    StatModifiers statsRestrictions;
    String occupRestriction;
    /* METHODS */

    /* No Restrictions Constructor */
    public EquipableItem(String name, EquipmentType eType, StatModifiers statsMods) {
	super(name);
	this.eType = eType;
	statsBoosts = statsMods;
	statsRestrictions = new StatModifiers();
	occupRestriction = "";
    }

    /* Fully Parameterized Constructor */
    public EquipableItem(String name, EquipmentType eType, StatModifiers statsMods, StatModifiers statsRestrict, String occRestrict)
    {
	super(name);
	this.eType = eType;
	statsBoosts = statsMods;
	statsRestrictions = statsRestrict;
	occupRestriction = occRestrict;
    }
    
    @Override
    public boolean executeInteraction(Entity entity) {
        return entity.addItem(this);
    }
    public void setStatRestrictions(StatModifiers s){
    	statsRestrictions = s;
    }

    public void setOccupationRestriction(String s){
    	occupRestriction = s;
    }

    public StatModifiers getStatsRestrictions(){
    	return statsRestrictions;
    }

    public String getOccupationRestriction(){
    	return occupRestriction;
    }

    /* Accessors */
    public StatModifiers getStatModifiers() {
	return statsBoosts;
    }

    @Override
    public String toString() {
	StringBuilder strBuilder = new StringBuilder();
	//	strBuilder.append( super.toString() );
	strBuilder.append("Equipment Type: " + eType.name() + "\n");	
	strBuilder.append("Stat Boosts: " + statsBoosts.toString() + "\n");	
	strBuilder.append("Stats Restrictions: " + statsRestrictions.toString() + "\n");
	strBuilder.append("Occupation Restriction: " + occupRestriction + "\n");
	strBuilder.append("]");
	String str = strBuilder.toString();
	return str;
}
