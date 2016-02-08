package views;

import models.entities.*;
import views.StatsProgressBarUI;

import javax.swing.*;
import java.awt.*;

public class StatsView extends View{
	
	private EntityStats avatarStats;
	private Font statFont = new Font("Comic Sans MS", Font.PLAIN, 30);
	private Entity avatar;
	
	public StatsView(Entity avatar){
		this.avatar = avatar;
		this.avatarStats = avatar.getEntityStats();
		avatar.addListener(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	protected void render(){
		removeAll();
		setBackground(Color.BLACK);
		GridBagConstraints c = new GridBagConstraints();

		String imgPath = "../images/" + avatar.getOccupation().toString() + ".gif";
		JLabel img = new JLabel(new ImageIcon(imgPath));
		img.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(img);

		JLabel avatarName = new JLabel(avatar.getName());
		setFontAndColor(avatarName);
		avatarName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(avatarName);

		JLabel avatarOccupation = new JLabel(avatar.getOccupation().toString());
		setFontAndColor(avatarOccupation);
		avatarOccupation.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(avatarOccupation);

		JPanel statsPanel = new JPanel(new GridBagLayout());
		statsPanel.setBackground(Color.BLACK);
		//draw level icon, set label to level
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		JLabel levelLabel = new JLabel("Lvl: ");
		setFontAndColor(levelLabel);
		statsPanel.add(levelLabel, c);
		c.gridx = 1;
		levelLabel = new JLabel("" + avatarStats.getLevel());
		setFontAndColor(levelLabel);
		statsPanel.add(levelLabel, c);
		
		//draw XP icon, draw XP bar (currXP - lastLevelXP)/(nextLevelXP - lastLevelXP)
		c.gridx = 0;
		c.gridy = 1;
		JLabel xpLabel = new JLabel("Xp: ");
		setFontAndColor(xpLabel);
		statsPanel.add(xpLabel, c);
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
		statsPanel.add(xpBar, c);
		
		//draw lives icon, set label to numLives
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		JLabel livesLabel = new JLabel("Loaves: ");
		setFontAndColor(livesLabel);
		statsPanel.add(livesLabel, c);
		c.gridx = 1;
		livesLabel = new JLabel("" + avatarStats.getLivesLeft());
		setFontAndColor(livesLabel);
		statsPanel.add(livesLabel, c);
		
		//draw health icon, draw lifebar currHealth/maxHealth
		c.gridx = 0;
		c.gridy = 3;
		JLabel hpLabel = new JLabel("Hp: ");
		setFontAndColor(hpLabel);
		statsPanel.add(hpLabel, c);
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
		statsPanel.add(healthBar, c);

		//draw mana icon, draw manabar currMana/maxMana
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		JLabel mpLabel = new JLabel("Mp: ");
		setFontAndColor(mpLabel);
		statsPanel.add(mpLabel, c);
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
		statsPanel.add(manaBar, c);
		
		//draw offense icon, set label to offense score
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		JLabel atkLabel = new JLabel("Atk: ");
		setFontAndColor(atkLabel);
		statsPanel.add(atkLabel, c);
		c.gridx = 1;
		atkLabel = new JLabel("" + avatarStats.getOffRating());
		setFontAndColor(atkLabel);
		statsPanel.add(atkLabel, c);
		
		//draw defense icon, set label defense score
		c.gridx = 2;
		c.gridy = 5;
		JLabel defLabel = new JLabel("Def: ");
		setFontAndColor(defLabel);
		statsPanel.add(defLabel, c);
		c.gridx = 3;
		defLabel = new JLabel("" + avatarStats.getDefRating());
		setFontAndColor(defLabel);
		statsPanel.add(defLabel, c);
		
		//draw movement speed icon, set label to movement
		c.gridx = 0;
		c.gridy = 6;
		JLabel spdLabel = new JLabel("Spd: ");
		setFontAndColor(spdLabel);
		statsPanel.add(spdLabel, c);
		c.gridx = 1;
		spdLabel = new JLabel("" + avatarStats.getModMovement());
		setFontAndColor(spdLabel);
		statsPanel.add(spdLabel, c);
		
		//draw armor icon, set label to armor score
		c.gridx = 2;
		c.gridy = 6;
		JLabel armLabel = new JLabel("Arm: ");
		setFontAndColor(armLabel);
		statsPanel.add(armLabel, c);
		c.gridx = 3;
		armLabel = new JLabel("" + avatarStats.getArmorRating());
		setFontAndColor(armLabel);
		statsPanel.add(armLabel, c);
		
		//draw strength icon, set label to strength score
		c.gridx = 0;
		c.gridy = 7;
		JLabel strLabel = new JLabel("Str: ");
		setFontAndColor(strLabel);
		statsPanel.add(strLabel, c);
		c.gridx = 1;
		strLabel = new JLabel("" + avatarStats.getModStrength());
		setFontAndColor(strLabel);
		statsPanel.add(strLabel, c);
		
		//draw agility icon, set label to agility score
		c.gridx = 2;
		c.gridy = 7;
		JLabel aglLabel = new JLabel("Agl: ");
		setFontAndColor(aglLabel);
		statsPanel.add(aglLabel, c);
		c.gridx = 3;
		aglLabel = new JLabel("" + avatarStats.getModAgility());
		setFontAndColor(aglLabel);
		statsPanel.add(aglLabel, c);
		
		//draw intellect icon, set label to intellect score
		c.gridx = 0;
		c.gridy = 8;
		JLabel intLabel = new JLabel("Int: ");
		setFontAndColor(intLabel);
		statsPanel.add(intLabel, c);
		c.gridx = 1;
		intLabel = new JLabel("" + avatarStats.getModIntellect());
		setFontAndColor(intLabel);
		statsPanel.add(intLabel, c);
		
		//draw hardiness icon, set label for hardiness score
		c.gridx = 2;
		c.gridy = 8;
		JLabel hrdLabel = new JLabel("Hrd: ");
		setFontAndColor(hrdLabel);
		statsPanel.add(hrdLabel, c);
		c.gridx = 3;
		hrdLabel = new JLabel("" + avatarStats.getModHardiness());
		setFontAndColor(hrdLabel);
		statsPanel.add(hrdLabel, c);

		add(statsPanel);
		
	}
	
	public void update(){
		
		render();
	}
	public void setFontAndColor(JComponent component){
		component.setFont(statFont);
		component.setForeground(Color.WHITE);
	}
}