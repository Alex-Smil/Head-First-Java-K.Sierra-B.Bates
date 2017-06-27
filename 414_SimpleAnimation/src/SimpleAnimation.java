import javax.swing.*;
import java.awt.*;

import static java.awt.Color.orange;

/**
 * Created by Smile on 10.06.2017.
 */
public class SimpleAnimation {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();//Создаём frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// После закрытия окна программа прекращается

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(785, 720);
        frame.setVisible(true);

        //Цикл для создания анимации
        for (int i = 0; i < 510; i++) {
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(80);
            } catch (Exception ex) {}
        }
    }

    //MyDrawPanel - Класс где прорисованны фон и объект
    class MyDrawPanel extends JPanel {
        public void paintComponent (Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

//            g.setColor(Color.darkGray);//цвет фона
            g.fillRect(0, 0, this.getWidth(), this.getHeight());// Размер Фона

            // Цвет верх круга
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color startColor = new Color(red,green,blue);

            // Цвет низ круга
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color endColor = new Color(red,green,blue);

            GradientPaint gradient = new GradientPaint(x,y,startColor, x + 100, y + 100,endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(x,y,100,100);
        }
    }


}
