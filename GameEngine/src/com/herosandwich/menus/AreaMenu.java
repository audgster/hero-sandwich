package com.herosandwich.menus;

import com.herosandwich.models.entity.Entity;

import com.herosandwich.models.occupation.Property;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Stack;


/**
 * Created by Brandon on 3/11/2016.
 */
public class AreaMenu{
    private double WIDTH,HEIGHT;
    private Pane statsView;
    private Pane content;
    private Entity entity;
    private Property occupation;
    public AreaMenu(double width, double height){
        WIDTH = width;
        HEIGHT = height;
        statsView = new Pane();
        content = new Pane();
        entity = new Entity();
    }
    public Pane createMenu(){
        StackPane entityInfo = createEntityInfo();
        HBox characterInfo = new HBox();
            characterInfo.getChildren().addAll(createEntityStats(),createOtherStatsPart());
        Rectangle blackRec = new Rectangle(WIDTH,HEIGHT-WIDTH, Color.BLACK);
        VBox areaMenu = new VBox();
        areaMenu.getChildren().addAll(entityInfo, characterInfo, blackRec);
        content.getChildren().addAll(areaMenu);
        return content;
    }

    private StackPane createEntityInfo(){
        ImageView avatarImg = new ImageView();
            avatarImg.setId("Smasher_image2");
            avatarImg.setFitWidth(WIDTH/3);
            avatarImg.setFitHeight(WIDTH/3);

        Label avatarName = new Label("Smasher");
            avatarName.setId("stats_text");
        Label avatarLvl = new Label("Lvl");
            avatarLvl.setId("stats_text");
        Label avatarHp = new Label("Hp");
            avatarHp.setId("stats_text");
        Label avatarMp = new Label("Mp");
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
        Label str = new Label("Str: ");
            str.setId("stats_text");
        Label spd = new Label("Spd: ");
            spd.setId("stats_text");
        Label atk = new Label("Atk: ");
            atk.setId("stats_text");
        Label def = new Label("Def: ");
            def.setId("stats_text");

        VBox statsList = new VBox(5);
            statsList.getChildren().addAll(str,spd,atk,def);

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
        StackPane occupationSkills = new StackPane();
        occupationSkills.setMinWidth(WIDTH*2/3);
        occupationSkills.setMinHeight(WIDTH/3);
        occupationSkills.setId("stats_menu");
        return occupationSkills;
    }

}
