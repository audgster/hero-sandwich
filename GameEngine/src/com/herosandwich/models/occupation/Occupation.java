package com.herosandwich.models.occupation;


import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Npc;
import com.herosandwich.models.entity.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class Occupation{
    protected Character owner;
    protected HashMap<Skill, Integer> occupationSkills;
    protected List<Skill> learned_skills;

    public Occupation(){
        occupationSkills = new HashMap<>();
        learned_skills = new ArrayList<>();
        learned_skills.add(Skill.BIND_WOUNDS);
        learned_skills.add(Skill.BARGAIN);
        learned_skills.add(Skill.OBSERVATION);
    }

    public Occupation(Character owner){
        this.owner = owner;
        occupationSkills = new HashMap<>();
        learned_skills = new ArrayList<>();
        learned_skills.add(Skill.BIND_WOUNDS);
        learned_skills.add(Skill.BARGAIN);
        learned_skills.add(Skill.OBSERVATION);
    }

    /*
    * General Skills
    */

    // heals some damage
    public final void bindWounds(){
        if(owner.getCurrentMana() == owner.getMaxMana()){
            return;
        }

        if(successfulAction(Skill.BIND_WOUNDS) ){
            int healingAmount = (int)(1 + (getLevelOfSkill(Skill.BIND_WOUNDS)*.3));
            owner.modifyCurrentMana(healingAmount);
        }
    }

    //if successful the following two conditions will occur
    //1) an npc that is selling will lower her prices for each item it sells!
    //2) an npc that is buying it will offer the character more money for each of her items!
    public final void bargain(Npc npc){
        if(successfulAction(Skill.BARGAIN)) {
            int bargain_skill_level = getLevelOfSkill(Skill.BARGAIN);

            //lowering the price of each item the npc sells
            HashMap<Integer, Integer> npc_selling_list = npc.getSell();
            Set<Integer> npc_sellable_item_ids =  npc_selling_list.keySet();
            for(int item_id : npc_sellable_item_ids){
                int costOfItem =  npc_selling_list.get(item_id);
                int newCostOfItem = (int)(costOfItem * (1 - bargain_skill_level*(.01)));
                npc_selling_list.replace(item_id, newCostOfItem);
            }

            //increasing the price of each item the npc wants to buy from character
            HashMap<Integer, Integer> npc_buying_list = npc.getBuy();
            Set<Integer> npc_buyable_item_ids = npc_buying_list.keySet();
            for(int item_id : npc_buyable_item_ids){
                int costOfItem =  npc_buying_list.get(item_id);
                int newCostOfItem = (int)(costOfItem * (1 + bargain_skill_level*(.01)));
                npc_buying_list.replace(item_id, newCostOfItem);
            }
        }
    }

    public final void observation(){
        if(successfulAction(Skill.OBSERVATION)){

        }
    }

    //probability of action success. More likely to be successful if occupation has
    //a high level for that skill!!
    public boolean successfulAction(Skill skill){
        int skillLevel = getLevelOfSkill(skill);
        int prob = (int) Math.ceil(Math.random() * 100) + skillLevel;
        if(prob > 50){
            return true;
        }
        return false;
    }

    public final void updateOccupationSkills(){
        for(Skill skill : learned_skills){
            if(occupationSkills.containsKey(skill)){
                occupationSkills.replace(skill, owner.getNumberOfSkillPoints(skill));
            }else{
                occupationSkills.put(skill, owner.getNumberOfSkillPoints(skill));
            }
        }
    }

    public int getLevelOfSkill(Skill skill){
        return occupationSkills.get(skill);
    }

    public void setOwner(Character owner){
        this.owner = owner;
        updateOccupationSkills();
    }

    public abstract String getDescription();

    public List<Skill> getLearnedSkills(){
        return learned_skills;
    }

    public String toString() {
        return "Occupation";
    }

}
