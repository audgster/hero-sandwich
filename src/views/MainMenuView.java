package views;

import javax.swing.*;
import java.awt.*;
import models.menus.*;

public class MainMenuView extends View{
    private JLabel gameTitle, newGame, loadGame, exitGame, imageLabel;
    private JPanel textPanel, centerPanel;
    private MainMenu menuModel;

    public MainMenuView(Menus model){
        menuModel = (MainMenu) model;
        menuModel.addListener(this);
        setLayout(new BorderLayout());
        centerPanel = new JPanel();
        textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        initializeText();
        render();
    }

    public void initializeText(){
        imageLabel = new JLabel(new ImageIcon("../images/big-sandwich.gif"));
        gameTitle = new JLabel("Hero Sandwich");
                gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        newGame = new JLabel("New Game");
        loadGame = new JLabel("Load Game");
        exitGame = new JLabel("Exit Game");
    }

    public void render(){
        setBackground(Color.WHITE);
        textPanel.setBackground(Color.WHITE);
        centerPanel.setBackground(Color.WHITE);

        newGame.setBackground(Color.GRAY);
                newGame.setOpaque(true);
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
            textPanel.add(newGame);
            textPanel.add(loadGame);
            textPanel.add(exitGame);
        add(textPanel, BorderLayout.LINE_START);
        add(imageLabel, BorderLayout.LINE_END);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void update(){
            newGame.setOpaque(false);
            exitGame.setOpaque(false);
            loadGame.setOpaque(false);
        if(menuModel.getCurrentlySelected().toString() == "New Game"){
            newGame.setOpaque(true);
        }
        else if(menuModel.getCurrentlySelected().toString() == "Load Game"){
            loadGame.setOpaque(true);
        }
        else{
            exitGame.setOpaque(true);
        }
        revalidate();
        repaint();
    }
}
