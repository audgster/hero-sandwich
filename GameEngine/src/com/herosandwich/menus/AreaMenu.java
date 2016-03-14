package com.herosandwich.menus;

import com.herosandwich.models.entity.Entity;

import com.herosandwich.models.entity.EntityStats;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.occupation.Occupation;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

import java.util.*;


/**
 * Created by Brandon on 3/11/2016.
 */
public class AreaMenu{
    private double WIDTH,HEIGHT;
    private Pane content;
    private Player entity;
    private Occupation occupation;
    private VBox textOptions;
    private boolean visible;
    private String testing = "";
    public AreaMenu(double width, double height, Player entity){
        WIDTH = width;
        HEIGHT = height;
        content = new Pane();
        this.entity = entity;
        occupation = entity.getOccupation();
        textOptions = new VBox(5);
            textOptions.setMaxSize(WIDTH,HEIGHT-WIDTH);
    }
    public Pane createMenu(){
        StackPane entityInfo = createEntityInfo();
        HBox characterInfo = new HBox();
            characterInfo.getChildren().addAll(createEntityStats(),createOtherStatsPart());
        VBox areaMenu = new VBox();
        areaMenu.getChildren().addAll(entityInfo, characterInfo, createTalkBox());
        content.getChildren().addAll(areaMenu);
        createTesting();
        return content;
    }
    public void update(){
        testing+=".";
        content.getChildren().clear();
        textOptions.getChildren().clear();
        StackPane entityInfo = createEntityInfo();
        HBox characterInfo = new HBox();
        characterInfo.getChildren().addAll(createEntityStats(),createOtherStatsPart());
        VBox areaMenu = new VBox();
        areaMenu.getChildren().addAll(entityInfo, characterInfo, createTalkBox());
        content.getChildren().addAll(areaMenu);
        createTesting();
    }

    private StackPane createEntityInfo(){
        ImageView avatarImg = new ImageView();
            avatarImg.setId("Smasher_image2");
            avatarImg.setFitWidth(WIDTH/3);
            avatarImg.setFitHeight(WIDTH/3);

        Label avatarName = new Label(entity.getName());
            avatarName.setId("stats_text");
        Label avatarLvl = new Label("Lvl       "+entity.getLevel());
            avatarLvl.setId("stats_text");
        Label avatarHp = new Label("Hp        "+entity.getCurrentLife()+"/"+entity.getMaxLife());
            avatarHp.setId("stats_text");
        Label avatarMp = new Label("Mp        "+entity.getCurrentMana()+"/"+entity.getMaxMana());
            avatarMp.setId("stats_text");

        VBox basicInfo = new VBox();
            basicInfo.getChildren().addAll(avatarName, avatarLvl, avatarHp, avatarMp);
        HBox imgAndInfo = new HBox(10);
        imgAndInfo.getChildren().addAll(avatarImg,basicInfo);

        StackPane avatarInfo = new StackPane();
            avatarInfo.getChildren().add(imgAndInfo);
            avatarInfo.setId("stats_menu");
            avatarInfo.setMinWidth(WIDTH);
            avatarInfo.setMinHeight(WIDTH / 3);
        return avatarInfo;
    }

    private StackPane createEntityStats(){
        Label str = new Label("Str:");
            str.setId("stats_text");
        Label entityStr = new Label(""+entity.getStrength());
            entityStr.setId("stats_text");
        Label agl = new Label("Agl:");
            agl.setId("stats_text");
        Label entityAgl = new Label(""+entity.getAgility());
            entityAgl.setId("stats_text");
        Label inte = new Label("Int:");
            inte.setId("stats_text");
        Label entityInte = new Label(""+entity.getIntellect());
            entityInte.setId("stats_text");
        Label hard = new Label("Hard:");
            hard.setId("stats_text");
        Label entityHard = new Label(""+entity.getHardiness());
            entityHard.setId("stats_text");
        Label entityXp = new Label("Xp: "+entity.getExperience()+"/100");
            entityXp.setId("stats_text");
        Label filler = new Label(" ");

        GridPane statsList = new GridPane();
            statsList.add(filler,1,0);
            statsList.add(entityXp,0,0);
            statsList.add(str,0,1);
            statsList.add(agl,0,2);
            statsList.add(inte,0,3);
            statsList.add(hard,0,4);
            statsList.add(entityStr,2,1);
            statsList.add(entityAgl,2,2);
            statsList.add(entityInte,2,3);
            statsList.add(entityHard,2,4);

        StackPane avatarStats = new StackPane();
            avatarStats.getChildren().add(statsList);
            avatarStats.setId("stats_menu");
        avatarStats.setMinWidth(WIDTH/3);
            avatarStats.setMinHeight(WIDTH*2/3);
        return avatarStats;
    }
    private StackPane createOtherStatsPart(){
        StackPane entitySkills = createOccupationSkills();
        StackPane temp2 = new StackPane();
        temp2.setMinWidth(WIDTH*2/3);
        temp2.setMinHeight(WIDTH/3);
        temp2.setId("stats_menu");

        VBox vbox = new VBox();
            vbox.getChildren().addAll(entitySkills,temp2);

        StackPane temp3 = new StackPane();
        temp3.getChildren().addAll(vbox);
        temp3.setId("stats_menu");
        return temp3;
    }

    private StackPane createOccupationSkills(){
        List<Skill> skillList = occupation.getLearnedSkills();
        List<Integer> skillLevels = new ArrayList<>(skillList.size());
        for(Skill skill: skillList){
            skillLevels.add(entity.getNumberOfSkillPoints(skill));
        }
        VBox skillHBox = new VBox();
        for(int i = 0; i < skillList.size();i++){
            Label skill = new Label(skillList.get(i)+"  lvl "+skillLevels.get(i));
                skill.setId("stats_text2");
                skill.autosize();
            skillHBox.getChildren().add(skill);
        }
        StackPane occupationSkills = new StackPane();
        occupationSkills.setMinWidth(WIDTH*2/3);
        occupationSkills.setMinHeight(WIDTH / 3);
        occupationSkills.getChildren().add(skillHBox);
        occupationSkills.setId("stats_menu");
        return occupationSkills;
    }

    private StackPane createTalkBox(){
        Rectangle blackRec = new Rectangle(WIDTH,HEIGHT-WIDTH, Color.BLACK);
        blackRec.setTranslateX(-2);

        StackPane areaMenu = new StackPane();
            areaMenu.getChildren().addAll(blackRec, textOptions);
        return areaMenu;
    }

    private void setText(String text){
        Label areaText = new Label(text);
            areaText.setWrapText(true);
            areaText.setId("stats_text");
        textOptions.getChildren().addAll(areaText);

    }
    private StackPane getButton(String option){
        Label btnText = new Label(option);
            btnText.setId("button_text");
        Rectangle bg = new Rectangle(WIDTH, HEIGHT/15);
            bg.setId("button_rectangle");
        StackPane btn = new StackPane();
            btn.setMaxSize(WIDTH, HEIGHT/15);
            btn.setAlignment(Pos.CENTER);
            btn.getChildren().addAll(bg, btnText);
            btn.setVisible(true);
            btn.setOnMouseEntered(event -> {
            bg.setId("button_rectangle_hover");
            btnText.setId("button_text_hover");
        });
            btn.setOnMouseExited(event -> {
                bg.setId("button_rectangle");
                btnText.setId("button_text");
            });
        return btn;
    }

    private void createTesting(){
        //setText("Hello, and welcome to my Special Sandwich Shop. How can I help you?");
        setText(testing);
        StackPane btn = getButton("Buy");
        btn.setOnMouseClicked(event->{
            update();
        });
        textOptions.getChildren().addAll(btn,getButton("Sell"),getButton("Exit"));
    }

}
