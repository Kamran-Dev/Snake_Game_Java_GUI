import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About {

    private JFrame frame1;
    private JLabel textLabel;
    private JButton button1;
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
        button1 = new JButton();

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
        button1.setText("BACK");
        button1.setFocusable(false);
        button1.setSize(75,30);
        button1.setLocation(300, 550);
        frame1.add(button1);

        // action listener for back button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                MainMenu mm1 = new MainMenu();
                mm1.runMainMenu();
            }
        });


        // TEXT LABEL
        textLabel.setText("This game developed by Kamran Rashidov. Date: 01.09.2021");
        textLabel.setSize(400,50);
        textLabel.setOpaque(true);
        textLabel.setBackground(Color.white);
        textLabel.setLocation(200,100);
        textLabel.add(c);
        frame1.add(textLabel);




    }
}
