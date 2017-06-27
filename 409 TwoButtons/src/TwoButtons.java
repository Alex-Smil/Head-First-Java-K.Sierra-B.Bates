import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.orange;

/**
 * Created by Smile on 09.06.2017.
 */
public class TwoButtons {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorlListener());

        label = new JLabel("I`m a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(785, 720);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            label.setText("Ouch !");
        }
    }

    class ColorlListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            frame.repaint();
        }
    }

    class MyDrawPanel extends JPanel {
        public void paintComponent (Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            // Цвет и размер фона
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color fonColor = new Color(red,green,blue);
            g.setColor(fonColor);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());// Размер Фона

            // Цвет верх круга
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color startColor = new Color(red,green,blue);

            // Цвет низ круга
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color endColor = new Color(red,green,blue);

            GradientPaint gradient = new GradientPaint(70,70,startColor,450,450,endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(70,70,450,450);
        }
    }


}
