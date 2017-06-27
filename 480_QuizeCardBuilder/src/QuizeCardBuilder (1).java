import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by Smile on 16.06.2017.
 */
public class QuizeCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizeCard> cardList;
    private JFrame frame;

    public static void main(String[] args) {
        QuizeCardBuilder builder = new QuizeCardBuilder();
        builder.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Создаём и настриваем главную панель
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);// Узнать что Это такое Font ???????????????

        // Создаём область question(JTextArea) для вопросов
        question = new JTextArea(6,20);
        question.setLineWrap(true);// Узнать что Это такое ?????????????
        question.setWrapStyleWord(true);// Узнать что Это такое ?????????????
        question.setFont(bigFont);

        // Настриваем qScroller (JScrollPane) и вкладываем в него question (JTextArea)
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Создаём область answer(JTextArea) для ответов
        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        // Настриваем aScroller (JScrollPane) и вкладываем в него answer (JTextArea)
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Создаём конпку "Next Card"
        JButton nextButton = new JButton(" Next Card ");

        cardList = new ArrayList();

        // Создаём лейблы
        JLabel qLabel = new JLabel("Question: ");
        JLabel aLabel = new JLabel("Answer: ");

        // Добавляем виджеты на панель
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        // Создаём меню и в две функции в нём: New & Save
        // и регистрируем для них слушателей NewMenuListener & SaveMenuListener
        // которые реализуют необходимые для нас методы
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        // Создаём фрейм и добавляем на него панель
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    public class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            QuizeCard card = new QuizeCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }
     public class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            QuizeCard card = new QuizeCard(question.getText(), answer.getText());
            cardList.add(card);

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }

     }

     public class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            cardList.clear();
            clearCard();
        }
     }

     private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
     }

     private void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (QuizeCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("couldn`t write the cardList out");
            ex.printStackTrace();
        }
     }
}
