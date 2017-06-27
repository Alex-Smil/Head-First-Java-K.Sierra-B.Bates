package Graphics2DGradient_397;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 08.06.2017.
 */
public class Graphics2DGradient {
    JButton button;
    public static void main(String[] args) {
        Graphics2DGradient gui = new Graphics2DGradient();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();

        class MyDrawlPanel extends JPanel {
            public void paintComponent (Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gradient = new GradientPaint(70,70,Color.blue,450,450,Color.orange);

                g2d.setPaint(gradient);
                g2d.fillOval(70,70,450,450);
            }
        }
        MyDrawlPanel oval = new MyDrawlPanel();

        frame.getContentPane().add(oval);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setVisible(true);
    }
}
