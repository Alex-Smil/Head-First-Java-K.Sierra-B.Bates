import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 12.06.2017.
 */
public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }
//    стр 437
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton east = new JButton("East");
        JButton west = new JButton("West");
        JButton north = new JButton("North");
        JButton south = new JButton("South");
        JButton center = new JButton("Center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    //    стр 436
//    public void go() {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JButton button = new JButton("There is no spoon...");
//
//        Font bigFont = new Font("serif", Font.BOLD, 28);
//        button.setFont(bigFont);
//
//        frame.getContentPane().add(BorderLayout.NORTH, button);
//        frame.setSize(200, 200);
//        frame.setVisible(true);
//    }
//    стр 434 ............
}

