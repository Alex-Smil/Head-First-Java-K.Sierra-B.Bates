import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Smile on 14.06.2017.
 */
public class JCheckBox1 implements ItemListener { // ItemListener - Интерфейс для СheckBoxa с методом itemStateChanged

    JCheckBox check;

    public static void main(String[] args) {
        JCheckBox1 gui = new JCheckBox1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);


        check = new JCheckBox("Goes to 11");
        check.addItemListener(this);

        panel.add(check);
        frame.add(BorderLayout.NORTH, panel);
        frame.setSize(250,200);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ev) {
        String onOrrOff = "off";
        if (check.isSelected()) onOrrOff = "on";
        System.out.println("Check box is " + onOrrOff);
    }
}
