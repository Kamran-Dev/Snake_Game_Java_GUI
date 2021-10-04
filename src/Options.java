import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options {

    private JFrame frame1;
    private JLabel textLabel;
    private JButton button1;

    public void showOptions(){

        // get size of screen: width and height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthOfScreen = screenSize.getWidth();
        double heightOfScreen = screenSize.getHeight();

        // coordinates of frame in the center of screen
        int xLoc = (((int)widthOfScreen / 2) - (700/2));
        int yLoc = (((int)heightOfScreen / 2) - (650/2));

        frame1 = new JFrame();
        textLabel = new JLabel();
        button1 = new JButton();

        frame1.setSize(700, 650);
        frame1.setLocation(xLoc,yLoc);
        frame1.getContentPane().setBackground(Color.white);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        frame1.setVisible(true);



        button1.setText("BACK");
        button1.setFocusable(false);
        button1.setSize(75,30);
        button1.setLocation(300, 550);
        frame1.add(button1);

        // action listener for button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                MainMenu mm1 = new MainMenu();
                mm1.runMainMenu();
            }
        });




    }
}
