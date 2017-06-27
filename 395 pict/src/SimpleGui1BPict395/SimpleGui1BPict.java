package SimpleGui1BPict395;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 08.06.2017.
 */
public class SimpleGui1BPict {
    JButton button;
    public static void main(String[] args) {
        SimpleGui1BPict gui = new SimpleGui1BPict();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        class MyDrawlPanel extends JPanel {
            public void paintComponent (Graphics g) {
                Image image = new ImageIcon("pict.jpg").getImage();
                g.drawImage(image,3,4,this);
            }
        }
        MyDrawlPanel rect = new MyDrawlPanel();

        frame.getContentPane().add(rect);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setVisible(true);
    }
}
