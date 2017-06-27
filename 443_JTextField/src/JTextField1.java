import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Smile on 14.06.2017.
 */
public class JTextField1 implements ActionListener {

    JTextField field, field1;

    public static void main(String[] args) {
        JTextField1 gui = new JTextField1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        //panel.setBackground(Color.darkGray);

        JLabel label = new JLabel("Enter your name");
        JLabel label1 = new JLabel("Your name is :");

        field = new JTextField(20);
        field.addActionListener(this);

        field1 = new JTextField(20);


        panel.add(label);
        panel.add(field);
        panel.add(label1);
        panel.add(field1);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ev) {
        System.out.println(field.getText());

        field.selectAll();
        field.requestFocus();

        field1.setText(field.getText());

        //field.setText("");
    }

}
