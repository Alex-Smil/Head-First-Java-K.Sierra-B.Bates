import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Smile on 14.06.2017.
 */
public class TextArea1 implements ActionListener {
    JTextArea text;

    public static void main(String[] args) {
        TextArea1 gui = new TextArea1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton button = new JButton("Just click me!");
        button.addActionListener(this);
        text = new JTextArea(10,20);
        text.setLineWrap(true); //перенос слова на новую строку включён

        JScrollPane scroller = new JScrollPane(text);//Помещаем текстовую область JTextArea(10,20) в JScrollPane,
                                                    // JScrollPane будет её прокручивать
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//включили вертикальную полосу
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//отключили горизонтальную полосу

        panel.add(scroller);//Добавляем на панель scroller, который уже содержит в себе JTextArea

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(350, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        text.append("button clicked \n");
    }
}
