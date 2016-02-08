package models.items;

import models.entities.*;
import models.map.Tile;

import java.util.ArrayList;
import java.util.List;

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
	occupRestriction = "none";
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
    public boolean executeInteraction(Entity entity, Tile tile)
    {
        if (entity.addItem(this))
        {
            tile.removeItem(this);
            return true;
        }

        return false;
    }

    /* Mutators */
    public void setStatRestrictions(StatModifiers s){
    	statsRestrictions = s;
    }

    public void setOccupationRestriction(String s){
    	occupRestriction = s;
    }

    /* Accessors */
    public EquipmentType getEquipmentType() {
	return eType;
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
	strBuilder.append("Equipment Name: " + getName() + "\n");
	strBuilder.append("Equipment Type: " + eType.name() + "\n");	
	strBuilder.append("Stat Boosts: " + statsBoosts.toString() + "\n");	
	strBuilder.append("Stats Restrictions: " + statsRestrictions.toString() + "\n");
	strBuilder.append("Occupation Restriction: " + occupRestriction + "\n");
	strBuilder.append("]");
	String str = strBuilder.toString();
	return str;
    }

    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("Name: " + getName() + " " + System.getProperty("line.separator") + " ");
        state.add("EquipmentType: " + eType.name() + System.getProperty("line.separator") + " ");
        state.add("StatBoost {" + System.getProperty("line.separator") + " ");
        state.addAll(statsBoosts.getSaveState());
        state.add("}" + System.getProperty("line.separator") + " ");
        state.add("StatRestrictions { " + System.getProperty("line.separator") + " ");
        state.addAll(statsRestrictions.getSaveState());
        state.add("}" + System.getProperty("line.separator") + " ");
        state.add("OccupationRestriction: " + occupRestriction + System.getProperty("line.separator") + " ");
        return state;
    }
}
    
