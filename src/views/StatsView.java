package views;

import models.entities.*;

import javax.swing.*;
import java.awt.*;

public class StatsView extends View{
	
	private EntityStats avatarStats;
	
	public StatsView(Entity avatar){
		this.avatarStats = avatar.getEntityStats();
		avatar.addListener(this);
		setLayout(new GridBagLayout());
	}
	
	protected void render(){
		removeAll();
		setBackground(Color.BLUE);
		GridBagConstraints c = new GridBagConstraints();
		
		//draw level icon, set label to level
		c.gridx = 0;
		c.gridy = 0;
		JLabel levelLabel = new JLabel("Lvl: ");
		add(levelLabel, c);
		c.gridx = 1;
		levelLabel = new JLabel("" + avatarStats.getLevel());
		add(levelLabel, c);
		
		//draw XP icon, draw XP bar (currXP - lastLevelXP)/(nextLevelXP - lastLevelXP)
		c.gridx = 0;
		c.gridy = 1;
		JLabel xpLabel = new JLabel("Xp: ");
		add(xpLabel, c);
		c.gridx = 1;
		xpLabel = new JLabel("" + avatarStats.getXp());
		add(xpLabel, c);
		
		//draw lives icon, set label to numLives
		c.gridx = 0;
		c.gridy = 2;
		JLabel livesLabel = new JLabel("Loaves: ");
		add(livesLabel, c);
		c.gridx = 1;
		livesLabel = new JLabel("" + avatarStats.getLivesLeft());
		add(livesLabel, c);
		
		//draw health icon, draw lifebar currHealth/maxHealth
		c.gridx = 0;
		c.gridy = 3;
		JLabel hpLabel = new JLabel("Hp: ");
		add(hpLabel, c);
		c.gridx = 1;
		hpLabel = new JLabel(avatarStats.getCurrentLife() + 
				" / " + avatarStats.getLife());
		add(hpLabel, c);
		
		//draw mana icon, draw manabar currMana/maxMana
		c.gridx = 0;
		c.gridy = 3;
		JLabel mpLabel = new JLabel("Mp: ");
		add(mpLabel, c);
		c.gridx = 1;
		mpLabel = new JLabel(avatarStats.getCurrentMana() + 
				" / " + avatarStats.getMana());
		add(mpLabel, c);
		
		//draw offense icon, set label to offense score
		c.gridx = 0;
		c.gridy = 4;
		JLabel atkLabel = new JLabel("Atk: ");
		add(atkLabel, c);
		c.gridx = 1;
		atkLabel = new JLabel("" + avatarStats.getOffRating());
		add(atkLabel, c);
		
		//draw defense icon, set label defense score
		c.gridx = 2;
		c.gridy = 4;
		JLabel defLabel = new JLabel("Def: ");
		add(defLabel, c);
		c.gridx = 3;
		defLabel = new JLabel("" + avatarStats.getDefRating());
		add(defLabel, c);
		
		//draw movement speed icon, set label to movement
		c.gridx = 0;
		c.gridy = 5;
		JLabel spdLabel = new JLabel("Spd: ");
		add(spdLabel, c);
		c.gridx = 1;
		spdLabel = new JLabel("" + avatarStats.getModMovement());
		add(spdLabel, c);
		
		//draw armor icon, set label to armor score
		c.gridx = 2;
		c.gridy = 5;
		JLabel armLabel = new JLabel("Arm: ");
		add(armLabel, c);
		c.gridx = 3;
		armLabel = new JLabel("" + avatarStats.getArmorRating());
		add(armLabel, c);
		
		//draw strength icon, set label to strength score
		c.gridx = 0;
		c.gridy = 6;
		JLabel strLabel = new JLabel("Str: ");
		add(strLabel, c);
		c.gridx = 1;
		strLabel = new JLabel("" + avatarStats.getModStrength());
		add(strLabel, c);
		
		//draw agility icon, set label to agility score
		c.gridx = 2;
		c.gridy = 6;
		JLabel aglLabel = new JLabel("Agl: ");
		add(aglLabel, c);
		c.gridx = 3;
		aglLabel = new JLabel("" + avatarStats.getModAgility());
		add(aglLabel, c);
		
		//draw intellect icon, set label to intellect score
		c.gridx = 0;
		c.gridy = 7;
		JLabel intLabel = new JLabel("Int: ");
		add(intLabel, c);
		c.gridx = 1;
		intLabel = new JLabel("" + avatarStats.getModIntellect());
		add(intLabel, c);
		
		//draw hardiness icon, set label for hardiness score
		c.gridx = 2;
		c.gridy = 7;
		JLabel hrdLabel = new JLabel("Hrd: ");
		add(hrdLabel, c);
		c.gridx = 3;
		hrdLabel = new JLabel("" + avatarStats.getModHardiness());
		add(hrdLabel, c);
		
	}
	
	public void update(){
		
		render();
	}
	
}