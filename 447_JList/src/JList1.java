import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by Smile on 14.06.2017.
 */
public class JList1 implements ListSelectionListener {

    JList list;

    public static void main(String[] args) {
        JList1 gui = new JList1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Создаём лист заранее заполненный
        String[] listEntries = {"alpha","beta","gamma","delta","epsilon","zeta","eta","theta"};
        list = new JList(listEntries);
        list.setVisibleRowCount(4);// Устанавливаем кол-во строк, изображаемых до прокрутки
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Создаём и настраиваем scroller
        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Заполняем панель
        panel.add(scroller);



        // добавляем во frame panel и настраиваем его (настраиваем frame)
        frame.add(panel);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent lse) {
        if (!lse.getValueIsAdjusting()) {
            String selection = (String) list.getSelectedValue();
            System.out.println(selection);
        }
    }

}
