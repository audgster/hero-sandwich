package com.herosandwich.menus;

import com.herosandwich.models.entity.Entity;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;



/**
 * Created by Brandon on 3/11/2016.
 */
public class StatsMenu implements Menu{
    private Pane statsView;
    private Pane content;
    private Entity entity;
    public StatsMenu(){
        statsView = new Pane();
        content = new Pane();
    }
    public void createMenu(Pane display){
        VBox statsMenu = new VBox();
        StackPane entityInfo = createEntityInfo();
        StackPane entityStats = createEntityStats();

        statsMenu.getChildren().addAll(entityInfo,entityStats);
        display.getChildren().add(statsMenu);
    }

    private StackPane createEntityInfo(){
        ImageView avatarImg = new ImageView();
            avatarImg.setId("Smasher_image2");
            avatarImg.setFitWidth(200);
            avatarImg.setFitHeight(200);

        Label avatarName = new Label("Smasher");
        Label avatarLvl = new Label("Lvl");
        Label avatarHp = new Label("Hp");
        Label avatarMp = new Label("Mp");

        VBox basicInfo = new VBox();
            basicInfo.getChildren().addAll(avatarName, avatarLvl, avatarHp, avatarMp);
        HBox imgAndInfo = new HBox(5);
        imgAndInfo.getChildren().addAll(avatarImg,basicInfo);

        StackPane avatarInfo = new StackPane();
            avatarInfo.getChildren().add(imgAndInfo);
            avatarInfo.setId("stats_menu");
            avatarInfo.setMinWidth(1200);
        return avatarInfo;
    }

    private StackPane createEntityStats(){
        Label str = new Label("Str: ");
        Label spd = new Label("Spd: ");
        Label atk = new Label("Atk: ");
        Label def = new Label("Def: ");

        VBox statsList = new VBox(5);
            statsList.getChildren().addAll(str,spd,atk,def);

        StackPane avatarStats = new StackPane();
            avatarStats.getChildren().add(statsList);
            avatarStats.setId("stats_menu");
            avatarStats.setMinWidth(600);
        return avatarStats;
    }

}
