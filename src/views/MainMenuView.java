package views;

import javax.swing.*;
import java.awt.*;
import models.menus.*;


public class MainMenuView extends View{
    private Image sandwich;
    private JLabel gameTitle, newGame, loadGame, exitGame, imagePanel;
    private JPanel bottomPanel;
    private MainMenu menuModel;

    public MainMenuView(Menus model){
        menuModel = (MainMenu) model;
        menuModel.addListener(this);
        setLayout(new BorderLayout());
        bottomPanel = new JPanel();
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
        imagePanel = new JLabel(new ImageIcon("../images/big-sandwich.gif"));
        gameTitle = new JLabel("Hero Sandwich");
        newGame = new JLabel("New Game");
        loadGame = new JLabel("Load Game");
        exitGame = new JLabel("Exit Game");
        render();
    }

    public void render(){
        setBackground(Color.WHITE);
            bottomPanel.setBackground(Color.WHITE);

        newGame.setBackground(Color.GRAY);
        loadGame.setBackground(Color.GRAY);
        exitGame.setBackground(Color.GRAY);

        gameTitle.setFont(new Font("Georgia",Font.ITALIC, 60));
        newGame.setFont(new Font("Georgia",Font.ITALIC, 40));
        loadGame.setFont(new Font("Georgia",Font.ITALIC, 40));
        exitGame.setFont(new Font("Georgia",Font.ITALIC, 40));

        gameTitle.setForeground(Color.BLACK);
        newGame.setForeground(Color.BLACK);
        loadGame.setForeground(Color.BLACK);
        exitGame.setForeground(Color.BLACK);

        add(gameTitle, BorderLayout.PAGE_START);
        gameTitle.setPreferredSize(new Dimension(1300, 100));
        add(imagePanel, BorderLayout.CENTER);
            bottomPanel.add(newGame);
            bottomPanel.add(loadGame);
            bottomPanel.add(exitGame);
        add(bottomPanel, BorderLayout.CENTER_LEFT);

        newGame.setOpaque(true);
        setVisible(true);
    }

    public void update(){
            newGame.setOpaque(false);
            exitGame.setOpaque(false);
            loadGame.setOpaque(false);
        if(menuModel.getCurrentlySelected().toString() == "NewGameOption"){
            newGame.setOpaque(true);
        }
        else if(menuModel.getCurrentlySelected().toString() == "LoadGameOption"){
            loadGame.setOpaque(true);
        }
        else{
            exitGame.setOpaque(true);
        }
        revalidate();
        repaint();
    }
}
