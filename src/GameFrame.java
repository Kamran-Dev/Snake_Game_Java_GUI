import javax.swing.*;

public class GameFrame extends JFrame {


    // Constructor for GameFrame class
    GameFrame()
    {
        GamePanel panel = new GamePanel();

        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(panel);
        this.setVisible(true);
        this.setSize(700,650);
        this.pack();
        this.setLocationRelativeTo(null);  // middle of screen. at the end of screen

    }
}
