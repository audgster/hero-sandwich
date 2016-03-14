package  com.herosandwich.menus;

import com.herosandwich.creation.init.ItemInit;
import com.herosandwich.menus.areaviewdrawables.SpriteMap;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;


public class ShopMenu implements Menu {
    private double WIDTH, HEIGHT;
    private Npc shopKeeper;
    private Player avatar;
    private VBox content;
    private StackPane itemList;
    private ArrayList<ShopItem> npcInventory, playerInventory, selectedInventory;
    private HashMap<Integer,Integer> shopSellHash,shopBuyHash;
    private ShopItem selectedItem;
    private ImageView itemImg;
    private Label itemDescription;
    private Inventory i;
    private VBox itemListVBox;
    private StackPane inventoryList;
    private Label btnText;
    private StackPane btnArea;

    public ShopMenu(double width, double height,Npc shopKeeper, Player avatar){
        WIDTH = width;
        HEIGHT = height;
        this.shopKeeper = shopKeeper;
        this.avatar = avatar;
        content = new VBox();
        inventoryList = new StackPane();
        itemList = new StackPane();
        itemImg = new ImageView();
        itemDescription = new Label();
        i = avatar.getInventory();
        npcInventory = new ArrayList<ShopItem>();
        playerInventory = new ArrayList<ShopItem>();

        shopSellHash = shopKeeper.getSell();
        shopBuyHash = shopKeeper.getBuy();

        ItemInit init = ItemInit.getInstance();

        for (Integer value : shopSellHash.values()) {
            npcInventory.add(new ShopItem(init.getTakeableItem(value)));
        }

        selectedInventory = npcInventory;
    }
    @Override
    public void createMenu(Pane root) {
        createInventorys();
        StackPane shopDescription = createTopShopDescription();
        StackPane itemInfo = createItemInfo(selectedItem);

        StackPane inventory = createItemList(selectedInventory);


        content.getChildren().addAll(shopDescription,itemInfo,inventory);
        root.getChildren().add(content);
        content.setVisible(false);
    }

    private void createInventorys(){
        playerInventory.clear();
        for(int a = 0; a < i.getCapacity(); a++){
            TakeableItem item = i.getInventory().get(a);
            if(item!=null){
                playerInventory.add(new ShopItem(item));
            }
            else{
                playerInventory.add(new ShopItem());
            }
        }
    }

    private void updateBtn(){

    }

    private StackPane createTopShopDescription(){
        StackPane top = createBackGround(WIDTH, HEIGHT/7);
        Label shopDescription = new Label("Welcome to my specialty shop");
        top.getChildren().add(shopDescription);
        return top;
    }
    private StackPane createShopOptions(){
        StackPane shopOptions = createBackGround(WIDTH/4,HEIGHT/3.5);
            StackPane buyBtn = createBtn("Shop");
                buyBtn.setOnMouseClicked(event -> {
                    selectedInventory = npcInventory;
                    btnText.setText("Buy");
                    updateList();
                });
            StackPane sellBtn = createBtn("Inventory");
                sellBtn.setOnMouseClicked(event -> {
                    selectedInventory = playerInventory;
                    btnText.setText("Sell");
                    updateList();
                });
            StackPane exitBtn = createBtn("Exit");
                exitBtn.setOnMouseClicked(event -> {
                    content.setVisible(false);
                });
            VBox btnOptions = new VBox();
            btnOptions.getChildren().addAll(buyBtn,sellBtn,exitBtn);
            shopOptions.getChildren().add(btnOptions);
        return shopOptions;
    }

    public void setVisible(){
        createInventorys();
        updateList();
        content.setVisible(true);
    }

    private StackPane createItemInfo(){
        StackPane itemInfo = createBackGround(WIDTH*3/4,HEIGHT/3.5);
        if(selectedItem!=null){
            int itemPrice = shopBuyHash.get(selectedItem.item.getItemId());
            itemImg.setImage(selectedItem.itemImage);
            itemImg.setFitHeight(HEIGHT*2/7);
            itemImg.setFitWidth(WIDTH/10);
            itemDescription.setText(selectedItem.item.getName() + "     Price: " + itemPrice);
            itemDescription.wrapTextProperty();
        }
        HBox itemHBox = new HBox();
        itemHBox.getChildren().addAll(itemImg,itemDescription);
        itemInfo.getChildren().add(itemHBox);
        return itemInfo;
    }

    private StackPane createItemInfo(ShopItem item){
        StackPane createItemInfo = new StackPane();
        StackPane shopOptions = createShopOptions();
        StackPane itemDescription = createItemInfo();
        HBox itemHBox = new HBox();
            itemHBox.getChildren().addAll(shopOptions,itemDescription);
        createItemInfo.getChildren().add(itemHBox);
        return createItemInfo;
    }

    private StackPane createItemList(ArrayList<ShopItem> inventory){
        createList(inventory);
        itemList = createBackGround(WIDTH,HEIGHT*4/7);
        inventoryList = createBackGround(WIDTH*4/7,HEIGHT*4/7);
            inventoryList.getChildren().add(itemListVBox);
        StackPane itemBtn = createItemBtn();

        HBox tempHBox = new HBox();
        tempHBox.getChildren().addAll(inventoryList,itemBtn);
        itemList.getChildren().add(tempHBox);
        return itemList;
    }

    private void createList(ArrayList<ShopItem> inventory){
        itemListVBox = new VBox();
        inventoryList.getChildren().clear();
        inventoryList.getChildren().add(itemListVBox);
        for(int i = 0; i < inventory.size(); i++){
            ShopItem item = inventory.get(i);
            if(item.item != null){
                StackPane info = new StackPane();
                ImageView itemImg = new ImageView(item.itemImage);
                itemImg.setFitWidth(50);
                itemImg.setFitHeight(50);
                Label itemName = new Label(item.item.getName());
                StackPane bg = createBackGround(WIDTH*4/7,50);
                bg.setVisible(false);
                HBox hbox = new HBox();
                hbox.getChildren().addAll(itemImg,itemName);
                info.getChildren().addAll(bg, hbox);
                info.setOnMouseEntered(event -> {
                    bg.setVisible(true);
                });
                info.setOnMouseExited(event -> {
                    bg.setVisible(false);
                });
                info.setOnMouseClicked(event -> {
                    selectedItem = item;
                    updateItem();
                });
                itemListVBox.getChildren().add(info);
            }
        }
    }

    private StackPane createItemBtn(){
        btnArea = createBackGround(WIDTH*3/7,HEIGHT*4/7);
        Rectangle btnBg = new Rectangle(WIDTH*3/8,HEIGHT*2/8);
            btnBg.setId("button_rectangle");
            btnBg.setArcHeight(20);
            btnBg.setArcWidth(20);
        btnText = new Label("Buy");
            btnText.setMaxSize(WIDTH*3/8,HEIGHT*2/8);
            btnText.setAlignment(Pos.CENTER);
            btnText.setId("button_text");
        btnArea.getChildren().addAll(btnBg, btnText);
        btnText.setOnMouseEntered(event -> {
            btnText.setId("button_text_hover");
            btnBg.setId("button_rectangle_hover");
        });
        btnText.setOnMouseExited(event -> {
            btnText.setId("button_text");
            btnBg.setId("button_rectangle");
        });
        btnText.setOnMouseClicked(event -> {
            i.removeItem(selectedItem.item);
            selectedInventory.remove(selectedItem);
            selectedItem.delete();
            updateList();
        });
        return btnArea;
    }

    private void updateList(){
        createList(selectedInventory);
        if(selectedInventory.isEmpty()){
             btnArea.setVisible(false);
        }
        else{
            btnArea.setVisible(true);
        }
        updateItem();
    }
    private void updateItem(){
        if(selectedItem != null && selectedItem.item != null){
            itemImg.setImage(selectedItem.itemImage);
            itemDescription.setText(selectedItem.item.getName());
        }
        else{
            itemImg.setImage(new Image("res/images/blank.png"));
            itemDescription.setText("");
        }
    }

    private StackPane createBackGround(double width, double height){
        Rectangle bg = new Rectangle(width, height);
            bg.setId("shop_bg");
            bg.setArcWidth(20);
            bg.setArcHeight(20);
            bg.setStroke(Color.BLACK);
        StackPane menu_bg = new StackPane();
            menu_bg.getChildren().add(bg);
        return menu_bg;
    }

    private StackPane createBtn(String btnName){
        Label btnText = new Label(btnName);
            btnText.setId("button_text");
        Rectangle bg = new Rectangle(WIDTH/4, HEIGHT/10.5);
            bg.setArcWidth(20);
            bg.setArcHeight(20);
            bg.setId("button_rectangle");
        StackPane btn = new StackPane();
            btn.setMaxSize(WIDTH/6, HEIGHT/10.5);
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

    private class ShopItem{
        TakeableItem item;
        Image itemImage;
        private ShopItem(TakeableItem item){
            this.item = item;
            SpriteMap spriteMap = SpriteMap.getInstance();
            itemImage = spriteMap.getImageForKey(item.getItemId());
        }
        private ShopItem(){
            item = null;
            itemImage = new Image("res/images/blank.png");
        }
        private void delete(){
            item = null;
            itemImage = new Image("res/images/blank.png");
        }
    }
}