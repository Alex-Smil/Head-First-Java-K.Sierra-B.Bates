import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Created by Smile on 11.06.2017.
 */
public class Animate {
    int x = 1;
    int y = 1;

    public static void main(String[] args) {
        Animate gui = new Animate();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawP draw = new MyDrawP();
        frame.getContentPane().add(draw);
        frame.setSize(720,640);
        frame.setVisible(true);

        for (int i = 0; i < 299; i++) {
            x++;
            y++;
            draw.repaint();

            try {
                Thread.sleep(10);
            } catch (Exception ex) {}
        }

    }
    class MyDrawP extends JPanel {
        public void paintComponent(Graphics g) {
            g.fillRect(0, 0, this.getWidth(), this.getHeight());// Размер Фона
            g.setColor(blue);
            g.fillRect(x,y,this.getWidth()-x*2,this.getHeight()-y*2);
            //g.fillRect(x,y,720-x*2,640-y*2);

        }

    }
}
