import javax.swing.*;
import java.awt.*;


public class MainMenuView extends JPanel {
    private Image sandwich;
    private JLabel gameTitle, newGame, loadGame, exitGame, imagePanel;
    private JPanel bottomPanel;
    private String title = "Hero Sandwich";
    private String newG = "New Game";
    private String loadG = "Load Game";
    private String exitG = "Exit Game";

    public MainMenuView(){
        setLayout(new BorderLayout());
        bottomPanel = new JPanel();
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
        imagePanel = new JLabel(new ImageIcon("sandwich.png"));
        gameTitle = new JLabel(title);
        newGame = new JLabel(newG);
        loadGame = new JLabel(loadG);
        exitGame = new JLabel(exitG);
        drawYoSelf();
    }

    public void drawYoSelf(){
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

        setVisible(true);
    }

    public void update(){
        newGame.setOpaque(true);
        exitGame.setOpaque(true);
        loadGame.setOpaque(true);
    }

}
