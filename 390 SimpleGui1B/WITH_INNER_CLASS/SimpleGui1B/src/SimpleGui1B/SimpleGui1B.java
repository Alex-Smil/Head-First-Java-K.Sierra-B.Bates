package SimpleGui1B;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Саша on 24.05.2017.
 */
public class SimpleGui1B  {
    JButton button;
    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        class DopSGui  implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                button.setText("I`ve been clicked !");
            }
        }

        DopSGui obj = new DopSGui();

        button.addActionListener(obj);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
//    public void actionPerformed(ActionEvent event) {
//        button.setText("I`ve been clicked !");
//    }
}
