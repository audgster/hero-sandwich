package views;

import models.entities.*;

import javax.swing.*;
import java.awt.*;

public class StatsView extends View{
	
	private EntityStats avatarStats;
	private Font statFont = new Font("Comic Sans MS", Font.PLAIN, 30);
	
	public StatsView(Entity avatar){
		this.avatarStats = avatar.getEntityStats();
		avatar.addListener(this);
		setLayout(new GridBagLayout());
	}
	
	protected void render(){
		removeAll();
		setBackground(Color.WHITE);
		this.setFont(statFont);
		GridBagConstraints c = new GridBagConstraints();
		
		//draw level icon, set label to level
		c.gridx = 0;
		c.gridy = 0;
		JLabel levelLabel = new JLabel("Lvl: ");
		levelLabel.setFont(statFont);
		add(levelLabel, c);
		c.gridx = 1;
		levelLabel = new JLabel("" + avatarStats.getLevel());
		levelLabel.setFont(statFont);
		add(levelLabel, c);
		
		//draw XP icon, draw XP bar (currXP - lastLevelXP)/(nextLevelXP - lastLevelXP)
		c.gridx = 0;
		c.gridy = 1;
		JLabel xpLabel = new JLabel("Xp: ");		
		xpLabel.setFont(statFont);
		add(xpLabel, c);
		c.gridx = 1;
		xpLabel = new JLabel("" + avatarStats.getXp());		
		xpLabel.setFont(statFont);
		add(xpLabel, c);
		
		//draw lives icon, set label to numLives
		c.gridx = 0;
		c.gridy = 2;
		JLabel livesLabel = new JLabel("Loaves: ");
		livesLabel.setFont(statFont);
		add(livesLabel, c);
		c.gridx = 1;
		livesLabel = new JLabel("" + avatarStats.getLivesLeft());
		livesLabel.setFont(statFont);
		add(livesLabel, c);
		
		//draw health icon, draw lifebar currHealth/maxHealth
		c.gridx = 0;
		c.gridy = 3;
		JLabel hpLabel = new JLabel("Hp: ");
		hpLabel.setFont(statFont);
		add(hpLabel, c);
		c.gridx = 1;
		// hpLabel = new JLabel(avatarStats.getCurrentLife() + 
		// 		" / " + avatarStats.getLife());
		// hpLabel.setFont(statFont);
		// add(hpLabel, c);
		JProgressBar healthBar = new JProgressBar (0,100);
		add(healthBar, c);
		
		//draw mana icon, draw manabar currMana/maxMana
		c.gridx = 0;
		c.gridy = 4;
		JLabel mpLabel = new JLabel("Mp: ");
		mpLabel.setFont(statFont);
		add(mpLabel, c);
		c.gridx = 1;
		mpLabel = new JLabel(avatarStats.getCurrentMana() + 
				" / " + avatarStats.getMana());
		mpLabel.setFont(statFont);
		add(mpLabel, c);
		
		//draw offense icon, set label to offense score
		c.gridx = 0;
		c.gridy = 5;
		JLabel atkLabel = new JLabel("Atk: ");
		atkLabel.setFont(statFont);
		add(atkLabel, c);
		c.gridx = 1;
		atkLabel = new JLabel("" + avatarStats.getOffRating());
		atkLabel.setFont(statFont);
		add(atkLabel, c);
		
		//draw defense icon, set label defense score
		c.gridx = 2;
		c.gridy = 5;
		JLabel defLabel = new JLabel("Def: ");
		defLabel.setFont(statFont);
		add(defLabel, c);
		c.gridx = 3;
		defLabel = new JLabel("" + avatarStats.getDefRating());
		defLabel.setFont(statFont);
		add(defLabel, c);
		
		//draw movement speed icon, set label to movement
		c.gridx = 0;
		c.gridy = 6;
		JLabel spdLabel = new JLabel("Spd: ");
		spdLabel.setFont(statFont);
		add(spdLabel, c);
		c.gridx = 1;
		spdLabel = new JLabel("" + avatarStats.getModMovement());
		spdLabel.setFont(statFont);
		add(spdLabel, c);
		
		//draw armor icon, set label to armor score
		c.gridx = 2;
		c.gridy = 6;
		JLabel armLabel = new JLabel("Arm: ");
		armLabel.setFont(statFont);
		add(armLabel, c);
		c.gridx = 3;
		armLabel = new JLabel("" + avatarStats.getArmorRating());
		armLabel.setFont(statFont);
		add(armLabel, c);
		
		//draw strength icon, set label to strength score
		c.gridx = 0;
		c.gridy = 7;
		JLabel strLabel = new JLabel("Str: ");
		strLabel.setFont(statFont);
		add(strLabel, c);
		c.gridx = 1;
		strLabel = new JLabel("" + avatarStats.getModStrength());
		strLabel.setFont(statFont);
		add(strLabel, c);
		
		//draw agility icon, set label to agility score
		c.gridx = 2;
		c.gridy = 7;
		JLabel aglLabel = new JLabel("Agl: ");		
		aglLabel.setFont(statFont);
		add(aglLabel, c);
		c.gridx = 3;
		aglLabel = new JLabel("" + avatarStats.getModAgility());		
		aglLabel.setFont(statFont);
		add(aglLabel, c);
		
		//draw intellect icon, set label to intellect score
		c.gridx = 0;
		c.gridy = 8;
		JLabel intLabel = new JLabel("Int: ");
		intLabel.setFont(statFont);
		add(intLabel, c);
		c.gridx = 1;
		intLabel = new JLabel("" + avatarStats.getModIntellect());
		intLabel.setFont(statFont);
		add(intLabel, c);
		
		//draw hardiness icon, set label for hardiness score
		c.gridx = 2;
		c.gridy = 8;
		JLabel hrdLabel = new JLabel("Hrd: ");
		hrdLabel.setFont(statFont);
		add(hrdLabel, c);
		c.gridx = 3;
		hrdLabel = new JLabel("" + avatarStats.getModHardiness());
		hrdLabel.setFont(statFont);
		add(hrdLabel, c);
		
	}
	
	public void update(){
		
		render();
	}
	
}