package SimpleGui1BGraphics2D_396;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 08.06.2017.
 */
public class SimpleGui1BGraphics2D {
    JButton button;
    public static void main(String[] args) {
        SimpleGui1BGraphics2D gui = new SimpleGui1BGraphics2D();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        class MyDrawlPanel extends JPanel {
            public void paintComponent (Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.red);
                g2d.draw3DRect(20,50,100,100,true);

            }
        }
        MyDrawlPanel rect = new MyDrawlPanel();

        //frame.getContentPane().add(button);
        frame.getContentPane().add(rect);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
