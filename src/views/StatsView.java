package views;

import models.entities.*;

import javax.swing.*;
import java.awt.*;

public class StatsView extends View{
	
	private EntityStats avatarStats;
	private Font statFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	private Entity avatar;
	
	public StatsView(Entity avatar){
		this.avatar = avatar;
		this.avatarStats = avatar.getEntityStats();
		avatar.addListener(this);
		setLayout(new GridBagLayout());
	}
	
	protected void render(){
		removeAll();
		setBackground(Color.BLACK);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.ipady = 20;
		//c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		String imgPath = "resources/images/" + avatar.getOccupation().toString() + ".gif";
		JLabel img = new JLabel(new ImageIcon(imgPath));
		img.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(img, c);
		
		c.gridx = 0;
		c.gridy = 1;
		JLabel avatarName = new JLabel(avatar.getName());
		setFontAndColor(avatarName);
		avatarName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(avatarName, c);
		
		c.gridx = 0;
		c.gridy = 2;
		JLabel avatarOccupation = new JLabel(avatar.getOccupation().toString());
		setFontAndColor(avatarOccupation);
		avatarOccupation.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(avatarOccupation, c);

		//JPanel statsPanel = new JPanel(new GridBagLayout());
		//statsPanel.setBackground(Color.BLACK);
		//draw level icon, set label to level
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.ipady = 0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		JLabel levelLabel = new JLabel("Lvl: " + avatarStats.getLevel());
		setFontAndColor(levelLabel);
		add(levelLabel, c);
		
		//draw XP icon, draw XP bar (currXP - lastLevelXP)/(nextLevelXP - lastLevelXP)
		c.gridx = 0;
		c.gridy = 4;
		JLabel xpLabel = new JLabel("Xp: ");
		setFontAndColor(xpLabel);
		add(xpLabel, c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		JProgressBar xpBar = new JProgressBar (0, 100);
		xpBar.setStringPainted(true);
		xpBar.setString((avatarStats.getXp()%100) + "/" + "100");
		setFontAndColor(xpBar);
		xpBar.setBackground(Color.BLACK);
		xpBar.setForeground(Color.GREEN);
		xpBar.setBorderPainted(false);
		xpBar.setUI(new StatsProgressBarUI());
		xpBar.setValue(avatarStats.getXp()%100);
		add(xpBar, c);
		
		//draw lives icon, set label to numLives
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		JLabel livesLabel = new JLabel("Loaves: " + avatarStats.getLivesLeft());
		setFontAndColor(livesLabel);
		add(livesLabel, c);
		
		//draw health icon, draw lifebar currHealth/maxHealth
		c.gridx = 0;
		c.gridy = 6;
		JLabel hpLabel = new JLabel("Hp: ");
		setFontAndColor(hpLabel);
		add(hpLabel, c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		JProgressBar healthBar = new JProgressBar (0, avatarStats.getLife());
		healthBar.setStringPainted(true);
		healthBar.setString(avatarStats.getCurrentLife()+"/"+avatarStats.getLife());
		setFontAndColor(healthBar);
		healthBar.setBackground(Color.BLACK);
		healthBar.setForeground(Color.RED);
		healthBar.setBorderPainted(false);
		healthBar.setUI(new StatsProgressBarUI());
		healthBar.setValue(avatarStats.getCurrentLife());
		add(healthBar, c);

		//draw mana icon, draw manabar currMana/maxMana
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		JLabel mpLabel = new JLabel("Mp: ");
		setFontAndColor(mpLabel);
		add(mpLabel, c);
		c.gridx = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		JProgressBar manaBar = new JProgressBar (0, avatarStats.getMana());
		manaBar.setStringPainted(true);
		manaBar.setString(avatarStats.getCurrentMana()+"/"+avatarStats.getMana());
		setFontAndColor(manaBar);
		manaBar.setBackground(Color.BLACK);
		manaBar.setForeground(Color.BLUE);
		manaBar.setBorderPainted(false);
		manaBar.setUI(new StatsProgressBarUI());
		manaBar.setValue(avatarStats.getCurrentMana());
		add(manaBar, c);
		
		//draw offense icon, set label to offense score
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		JLabel atkLabel = new JLabel("Atk: " + avatarStats.getOffRating());
		setFontAndColor(atkLabel);
		add(atkLabel, c);
		
		//draw defense icon, set label defense score
		c.gridx = 2;
		c.gridy = 8;
		JLabel defLabel = new JLabel("Def: " + avatarStats.getDefRating());
		setFontAndColor(defLabel);
		add(defLabel, c);
		
		//draw movement speed icon, set label to movement
		c.gridx = 0;
		c.gridy = 9;
		JLabel spdLabel = new JLabel("Spd: " + avatarStats.getModMovement());
		setFontAndColor(spdLabel);
		add(spdLabel, c);
		
		//draw armor icon, set label to armor score
		c.gridx = 2;
		c.gridy = 9;
		JLabel armLabel = new JLabel("Arm: " + avatarStats.getArmorRating());
		setFontAndColor(armLabel);
		add(armLabel, c);
		
		//draw strength icon, set label to strength score
		c.gridx = 0;
		c.gridy = 11;
		JLabel strLabel = new JLabel("Str: " + avatarStats.getModStrength());
		setFontAndColor(strLabel);
		add(strLabel, c);
		
		//draw agility icon, set label to agility score
		c.gridx = 2;
		c.gridy = 11;
		JLabel aglLabel = new JLabel("Agl: " + avatarStats.getModAgility());
		setFontAndColor(aglLabel);
		add(aglLabel, c);
		
		//draw intellect icon, set label to intellect score
		c.gridx = 0;
		c.gridy = 12;
		JLabel intLabel = new JLabel("Int: " + avatarStats.getModIntellect());
		setFontAndColor(intLabel);
		add(intLabel, c);
		
		//draw hardiness icon, set label for hardiness score
		c.gridx = 2;
		c.gridy = 12;
		JLabel hrdLabel = new JLabel("Hrd: " + avatarStats.getModHardiness());
		setFontAndColor(hrdLabel);
		add(hrdLabel, c);
		
	}
	
	public void update(){
		
		render();
	}
	public void setFontAndColor(JComponent component){
		component.setFont(statFont);
		component.setForeground(Color.WHITE);
	}
}