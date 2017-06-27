import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Smile on 09.06.2017.
 */
public class SimpleGui3C implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        class MyDrawlPanel extends JPanel {
            public void paintComponent (Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                Color startColor = new Color(red,green,blue);

                red = (int) (Math.random() * 255);
                green = (int) (Math.random() * 255);
                blue = (int) (Math.random() * 255);
                Color endColor = new Color(red,green,blue);

                GradientPaint gradient = new GradientPaint(70,70,startColor,450,450,endColor);
                g2d.setPaint(gradient);
                g2d.fillOval(70,70,450,450);
            }
        }

        MyDrawlPanel oval = new MyDrawlPanel();

        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER, oval);
        frame.setSize(720, 720);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}
