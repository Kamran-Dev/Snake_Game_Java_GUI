import com.sun.tools.javac.Main;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {


    static final int SCREEN_WIDTH = 700;    // screen width
    static final int SCREEN_HEIGHT = 650;   // screen height
    static final int UNIT_SIZE = 25;  // the size of objects (matrix) in our game
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE; // calculate how many object we can fit in game
    int DELAY = 200; // delay in the game for the timer. how fast the game is running

    // arrays for coordinates of game and to hold parts of snake etc.
    final int x[] = new int[GAME_UNITS]; // added game_units case snake should not be bigger than the game itself
    final int y[] = new int[GAME_UNITS]; // holds y coordinates
    int bodyPartsOfSnake = 4; // amount of body parts of snake
    int applesEaten; // number of eaten apples
    int appleX; // coordinates of apple, will appear randomly created
    int appleY;
    // direction of snake
    // R - Right, L - Left, D - Down, U - up
    char direction = 'R';
    boolean running = false;  // game is running?
    Timer timer;
    Random random;
    JButton resetButton; // reset the game
    JButton mainMenu;

    // Constructor of GamePanel Class
    public GamePanel()
    {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.orange);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

        // reset button
        resetButton = new JButton();
        resetButton.setText("NEW GAME");
        resetButton.setSize(120,40);
        resetButton.setLocation(10, 10);
        resetButton.addActionListener(this);

        // main menu button
        mainMenu = new JButton();
        mainMenu.setText("MAIN MENU");
        mainMenu.setSize(140,40);
        mainMenu.setLocation(200, 10);
        mainMenu.addActionListener(this);

    }


    // Stat game method
    public void startGame()
    {
        newApple();     // first we should create new apple
        running = true; // game is running
        timer = new Timer(DELAY, this);
        timer.start();
    }

    // Paint component method
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

    // draw method
    public void draw(Graphics g)
    {
        if(running) {
            // for grid line
            /*
            for (int i = 0; i < SCREEN_HEIGHT; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT); // x axis
                //g.drawLine(0, i*UNIT_SIZE, i*UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE); // y axis
            } */

            // draw apple
            // make here random number generator.
            // to create additional apple/Star for the snake
            Image image;
            ImageIcon imj = new ImageIcon("mice002.png");
            image = imj.getImage();
            g.drawImage(image, appleX, appleY, UNIT_SIZE, UNIT_SIZE, Color.white,null);
            //g.setColor(Color.red);
            //g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // draw the body parts of snake
            for (int i = 0; i < bodyPartsOfSnake; i++) {
                if (i == 0) // head of our snake
                {
                    g.setColor(Color.RED); // head of the snake
                    // changing colors
                    //g.setColor(new Color( random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else // body part of snake
                {
                    g.setColor(Color.BLACK);
                    g.fillOval(x[i], y[i],UNIT_SIZE, UNIT_SIZE);
                }

            }
            g.setColor(Color.red);
            Font ft = new Font("Ink free", Font.BOLD, 20);
            g.setFont(ft);
            g.drawString("" + applesEaten , 670, 20);
        }
        else{
            gameOver(g);
        }
    }

    // make new apple for snake method
    public void newApple()
    {
        int rangeOfRandomX = (int)(SCREEN_WIDTH/UNIT_SIZE);
        int rangeOfRandomY = (int)(SCREEN_HEIGHT/UNIT_SIZE);
        appleX = random.nextInt(rangeOfRandomX)*UNIT_SIZE;
        appleY = random.nextInt(rangeOfRandomY)*UNIT_SIZE;
    }

    // move method
    public void move()
    {
        // moving body parts of snake
        for(int i = bodyPartsOfSnake; i > 0; i-- ){
            x[i] = x[i-1]; // shifting all parts of body
            y[i] = y[i-1];
        }

        switch (direction){
            case 'U':   // up
                y[0] = y[0]-UNIT_SIZE;
                break;
            case 'D':  // down
                y[0] = y[0]+UNIT_SIZE;
                break;
            case 'L':   // Left
                x[0] = x[0]-UNIT_SIZE;
                break;
            case 'R':  // Right
                x[0] = x[0]+UNIT_SIZE;
                break;
        }

    }

    // check Apple, whenever the apple has been eaten.
    public void checkApple()
    {
        if(((x[0]) == appleX) && ((y[0]) == appleY)) {

            SoundEffect soundEffect02 = new SoundEffect();
            try {
                soundEffect02.setFile("Score001.wav");
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            bodyPartsOfSnake++;
            applesEaten++;
            newApple();
            DELAY = DELAY - 50;

        }
    }

    public void gameOverSound(){
        SoundEffect soundEffect01 = new SoundEffect();
        try {
            soundEffect01.setFile("Gameover001.wav");
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // check collisions
    public void checkCollisions()
    {
        // if head collisions with the body
        for(int i = bodyPartsOfSnake; i > 0; i--){

            if((x[0] == x[i]) && (y[0] == y[i])) {
                gameOverSound();
                running = false;
            }
        }

        // if head collides with the left border
        if(x[0] < 0) {
            gameOverSound();
            running = false;
        }

        // if head collides with the right border
        if(x[0] > SCREEN_WIDTH-UNIT_SIZE) {
            gameOverSound();
            running = false;
        }

        // if head collides with the top border
        if(y[0] < 0) {
            gameOverSound();
            running = false;
        }

        // if head collides with the down border
        if(y[0] > SCREEN_HEIGHT-UNIT_SIZE) {
            gameOverSound();
            running = false;
        }

        if(!running){
            timer.stop();
        }
    }

    // game over method
    public void gameOver(Graphics c)
    {
        // game over text
        c.setColor(Color.red);
        Font ft = new Font("Ink free", Font.BOLD, 75);
        c.setFont(ft);
        c.drawString("GAME OVER ", 150, 350);

        // score text
        c.setColor(Color.red);
        Font fnt = new Font("Ink free", Font.BOLD, 45);
        c.setFont(fnt);
        c.drawString("OVERALL SCORE: " + applesEaten, 170, 450);

        this.add(resetButton);
        this.add(mainMenu);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        else{
            if(e.getSource() == resetButton){

                timer.stop();
                running = false;
                //System.exit(0); -- Terminate your program completely
                GameFrame gh = MainMenu.gf;
                gh.dispose();
                GameFrame gf2 = new GameFrame();
            }
            else if(e.getSource() == mainMenu){
                timer.stop();
                running = false;
                GameFrame gh = MainMenu.gf;
                gh.dispose();
                MainMenu mm = new MainMenu();
                mm.runMainMenu();
            }
        }
        repaint(); // if not running
    }

    public int getApplesEaten(){
        return applesEaten;
    }





    // inner class
    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e)
        {

            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                if(direction != 'R')
                {
                    direction = 'L';
                }
                break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L')
                    {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D')
                    {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U')
                    {
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:  // pause and resume the game
                    if(running){
                        timer.stop();
                        running = false;
                    }
                    else if(!running){
                        running = true;
                        timer.restart();
                    }
                    break;
            }
        }
    }
}
