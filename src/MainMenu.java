import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenu {

    JFrame frame1;
    JButton buttonStart;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    Border border1;  // red
    Border border2;  // black
    Border border3; // black, green
    JLabel label1;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    static GameFrame gf;




    public void runMainMenu()  {

        // get size of screen: width and height
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //double widthOfScreen = screenSize.getWidth();
        //double heightOfScreen = screenSize.getHeight();

        // coordinates of frame in the center of screen
        //int xLoc = (((int)widthOfScreen / 2) - (700/2));
        //int yLoc = (((int)heightOfScreen / 2) - (650/2));

        // create a frame1
        frame1 = new JFrame();
       // frame1.setLocation(xLoc,yLoc);
        frame1.setSize(700, 650);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cnt = frame1.getContentPane();
        cnt.setBackground(Color.ORANGE);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);

        // create a label
        label1 = new JLabel();
        label1.setVisible(true);

        label1.setLocation(275, 50);
        label1.setBackground(Color.cyan);
        label1.setOpaque(true);
        label1.setSize(150, 50);
        label1.setText("   MAIN MENU");
        Font myFont = new Font("Serif",Font.BOLD,21);
        label1.setFont(myFont);
        label1.setBorder(border2);
        frame1.add(label1);

        // create a border
        border1 = BorderFactory.createLineBorder(Color.RED, 2, true);
        border2 = BorderFactory.createLineBorder(Color.BLACK, 3);
        border3 = BorderFactory.createEtchedBorder(Color.black,Color.green);

        // ------------ BORDER OF FRAME ------------------
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        panel1.setBackground(Color.black);
        panel2.setBackground(Color.black);
        panel3.setBackground(Color.black);
        panel4.setBackground(Color.black);

        panel1.setBounds(0,0,700,5);
        panel2.setBounds(0,0,5,700);
        panel3.setBounds(0,608,700,5);
        panel4.setBounds(681,0,6,700);

        frame1.add(panel1);
        frame1.add(panel2);
        frame1.add(panel3);
        frame1.add(panel4);
        // -----------------------------------------------------


        /*
         *  Button1 - button Start
         *
         */
        buttonStart = new JButton();
        buttonStart.setText("START");
        buttonStart.setLocation(275,150);
        buttonStart.setSize(150, 50);
        buttonStart.setFocusable(false);
        buttonStart.setBorder(border1);
        buttonStart.setForeground(Color.blue);
        Font myFont1 = new Font("Serif",Font.BOLD,21);
        buttonStart.setFont(myFont1);

        // actionListener of buttonStart
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == buttonStart){
                    buttonClickSound();
                    frame1.dispose();
                    gf = new GameFrame();
                }
            }
        });

        frame1.add(buttonStart);




        /*
         *  create a button2 - STATISTICS
         *  start, music on/off, new game, options, credits/about, exit/quit
         *
         */
        button2 = new JButton();
        button2.setText("STATISTICS");
        button2.setLocation(275,210);
        button2.setSize(150, 50);
        button2.setFocusable(false);
        button2.setBorder(border3);
        button2.setFont(myFont1);
        button2.setForeground(Color.black);
        frame1.add(button2);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonClickSound();
                Statistics st = new Statistics();
                st.showStatistics();
                frame1.dispose();
            }
        });









        /*
         *  create a button3 - OPTIONS
         *  start, music on/off, new game, options, credits/about, exit/quit
         *
         */
        button3 = new JButton();
        button3.setText("OPTIONS");
        button3.setLocation(275,270);
        button3.setSize(150, 50);
        button3.setFocusable(false);
        button3.setBorder(border3);
        button3.setFont(myFont1);
        button3.setForeground(Color.black);
        frame1.add(button3);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button3){
                    buttonClickSound();
                    Options opt = new Options();
                    opt.showOptions();
                    frame1.dispose();
                }
            }
        });







        /*
         *  create a button4 - ABOUT
         *  start, music on/off, new game, options, credits/about, exit/quit
         *
         */
        button4 = new JButton();
        button4.setText("ABOUT");
        button4.setLocation(275,330);
        button4.setSize(150, 50);
        button4.setFocusable(false);
        button4.setBorder(border3);
        button4.setFont(myFont1);
        button4.setForeground(Color.black);
        //button4.setEnabled(false);
        frame1.add(button4);

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == button4)
                {
                    buttonClickSound();
                    frame1.dispose();
                    About about1 = new About();
                    about1.showAbout();
                }
            }
        });

    }


    public void buttonClickSound(){
        SoundEffect soundEffect01 = new SoundEffect();
        try {
            soundEffect01.setFile("Button001.wav");
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
