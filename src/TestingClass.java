import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class TestingClass{

    int x = 220;
    int y = 250;
    private JFrame frame1;
    private Component c;

    // Constructor for this class
    public void runTestClass() {

        frame1 = new JFrame();
        frame1.setSize(500,500);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        // frame1.setLayout(null); do not set layout NULL!!!
        frame1.setVisible(true);
        c = new Component() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g2D = (Graphics2D) g;
                super.paint(g);
                int xPoints[]={17,27,0,34,7};
                int yPoints[]={0,30,13,13,30};

                GeneralPath star = new GeneralPath();

                star.moveTo(xPoints[0]+x,yPoints[0]+y);
                for (int i=1;i<xPoints.length;i++)
                {
                    star.lineTo(xPoints[i]+x,yPoints[i]+y);
                }
                star.closePath();
                g2D.setColor(Color.RED);
                g2D.fill(star);
            }
        };
        frame1.add(c);
    }
}
