import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 12.06.2017.
 */
public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("shock me");//Создаём кнопку 1
        JButton button2 = new JButton("bliss");//Создаём кнопку 2
        JButton button3 = new JButton("huh ?");//Создаём кнопку 3
        panel.add(button1);//Добавляем кнопку 1
        panel.add(button2);//Добавляем кнопку 2
        panel.add(button3);//Добавляем кнопку 3

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250,200);
        frame.setVisible(true);
    }

    //стр 440
//    public void go() {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.darkGray);
//
//        JButton button1 = new JButton("shock me");//Создаём кнопку 1
//        JButton button2 = new JButton("bliss");//Создаём кнопку 2
//        JButton button3 = new JButton("huh ?");//Создаём кнопку 3
//        panel.add(button1);//Добавляем кнопку 1
//        panel.add(button2);//Добавляем кнопку 2
//        panel.add(button3);//Добавляем кнопку 3
//
//        frame.getContentPane().add(BorderLayout.EAST, panel);
//        frame.setSize(250,200);
//        frame.setVisible(true);
//    }

    //стр 439
//    public void go() {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.darkGray);
//
//        JButton button = new JButton("shock me");
//        panel.add(button);
//
//        frame.getContentPane().add(BorderLayout.EAST, panel);
//        frame.setSize(200,200);
//        frame.setVisible(true);
//    }

    //стр 438
//    public void go() {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.darkGray);
//        frame.getContentPane().add(BorderLayout.EAST, panel);
//        frame.setSize(200,200);
//        frame.setVisible(true);
//    }
}
