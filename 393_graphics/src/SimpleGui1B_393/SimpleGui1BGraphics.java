package SimpleGui1B_393;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Smile on 08.06.2017.
 */
public class SimpleGui1BGraphics{
    JButton button;
    public static void main(String[] args) {
        SimpleGui1BGraphics gui = new SimpleGui1BGraphics();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        class MyDrawlPanel extends JPanel {
            public void paintComponent (Graphics g) {
                g.setColor(Color.red);
                g.fillRect(20,50,100,100);
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
