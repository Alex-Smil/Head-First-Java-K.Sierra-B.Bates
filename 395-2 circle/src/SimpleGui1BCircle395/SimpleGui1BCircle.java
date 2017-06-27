package SimpleGui1BCircle395;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 08.06.2017.
 */
public class SimpleGui1BCircle {
    JButton button;
    public static void main(String[] args) {
        SimpleGui1BCircle gui = new SimpleGui1BCircle();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        class MyDrawlPanel extends JPanel {
            public void paintComponent (Graphics g) {
                g.fillRect(0,0,this.getWidth(),this.getHeight());

                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);

                Color randomColor = new Color(red,green,blue);
                g.setColor(randomColor);
                g.fillOval(70,70,450,450);
            }
        }
        MyDrawlPanel rect = new MyDrawlPanel();

        frame.getContentPane().add(rect);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setVisible(true);
    }
}
