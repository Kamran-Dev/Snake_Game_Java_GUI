import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;

public class About {

    private JFrame frame1;
    private JLabel textLabel;
    private JButton backButton;
    private JButton gitHubButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private Component c;


    public void showAbout(){

        // get size of screen: width and height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthOfScreen = screenSize.getWidth();
        double heightOfScreen = screenSize.getHeight();

        // coordinates of frame in the center of screen
        int xLoc = (((int)widthOfScreen / 2) - (700/2));
        int yLoc = (((int)heightOfScreen / 2) - (650/2));

        frame1 = new JFrame();
        textLabel = new JLabel();
        backButton = new JButton();
        gitHubButton = new JButton();

        frame1.setSize(700, 650);
        //frame1.setLocation(xLoc,yLoc);
        frame1.setLocationRelativeTo(null); // try this
        frame1.setVisible(true);
        frame1.getContentPane().setBackground(Color.ORANGE);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);


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



        c = new Component() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.black);
                g2d.drawRect(50,50,50,50);
                g2d.drawLine(0,0,500,500);
            }
        };

        frame1.add(c);




        // back button goes to main menu
        backButton.setText("BACK");
        backButton.setFocusable(false);
        backButton.setSize(75,30);
        backButton.setLocation(300, 550);
        frame1.add(backButton);

        // action listener for back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                MainMenu mm1 = new MainMenu();
                mm1.runMainMenu();
            }
        });


        // TEXT LABEL
        textLabel.setText("This game developed by Rashidov Kamran. Date: 01.09.2021");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.CENTER);
        textLabel.setSize(400,50);
        textLabel.setOpaque(true);
        textLabel.setBackground(Color.white);

        textLabel.setLocation(150,100);
        textLabel.add(c);
        frame1.add(textLabel);



        // go to my GitHub account
        gitHubButton.setText("GitHub");
        gitHubButton.setFocusable(false);
        gitHubButton.setSize(75,30);
        gitHubButton.setLocation(150, 550);
        frame1.add(gitHubButton);

        // action listener for back button
        gitHubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Desktop browser = Desktop.getDesktop();
                try{
                    browser.browse(new URI("https://github.com/Kamran-Dev"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });

        // links:
        // https://www.linkedin.com/in/kamranrashidov/
        // https://www.instagram.com/electrologia/




    }
}
