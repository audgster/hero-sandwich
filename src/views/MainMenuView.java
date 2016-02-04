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
        imagePanel = new JLabel(new ImageIcon("sandwich.png"));
        gameTitle = new JLabel("Hero Sandwich");
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        newGame = new JLabel("New Game", SwingConstants.CENTER);
                newGame.setHorizontalAlignment(SwingConstants.CENTER);
        loadGame = new JLabel("Load Game", SwingConstants.CENTER);
                loadGame.setHorizontalAlignment(SwingConstants.CENTER);
        exitGame = new JLabel("Exit Game", SwingConstants.CENTER);
                exitGame.setHorizontalAlignment(SwingConstants.CENTER);
        render();
    }

    public void render(){
        setBackground(Color.BLACK);
            bottomPanel.setBackground(Color.BLACK);

        newGame.setBackground(Color.WHITE);
        loadGame.setBackground(Color.WHITE);
        exitGame.setBackground(Color.WHITE);

        gameTitle.setFont(new Font("Georgia",Font.ITALIC, 40));
        newGame.setFont(new Font("Georgia",Font.ITALIC, 40));
        loadGame.setFont(new Font("Georgia",Font.ITALIC, 40));
        exitGame.setFont(new Font("Georgia",Font.ITALIC, 40));

        gameTitle.setForeground(Color.RED);
        newGame.setForeground(Color.RED);
        loadGame.setForeground(Color.RED);
        exitGame.setForeground(Color.RED);

        add(gameTitle, BorderLayout.PAGE_START);
        gameTitle.setPreferredSize(new Dimension(1300, 100));
        add(imagePanel, BorderLayout.CENTER);
            bottomPanel.add(newGame);
            bottomPanel.add(loadGame);
            bottomPanel.add(exitGame);
        add(bottomPanel, BorderLayout.PAGE_END);

        newGame.setOpaque(true);
        setVisible(true);
    }

    public void update(){
            newGame.setOpaque(false);
            exitGame.setOpaque(false);
            loadGame.setOpaque(false);
        if(menuModel.getCurrentlySelected().toString() == "NewGameOption"){
            newGame.setOpaque(true);
            revalidate();
            repaint();
        }
        else if(menuModel.getCurrentlySelected().toString() == "LoadGameOption"){
            loadGame.setOpaque(true);
            revalidate();
            repaint();
        }
        else{
            exitGame.setOpaque(true);
            revalidate();
            repaint();
        }

    }

}
