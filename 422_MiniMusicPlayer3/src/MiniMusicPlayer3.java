import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 10.06.2017.
 */
public class MiniMusicPlayer3 {
    static JFrame f = new JFrame("Мой первый музыкальный клип");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30, 30, 800, 800);
        f.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            //Создаём и открываем синт
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequencer.addControllerEventListener(ml, new int[] {127});//??????????????


            Sequence seq = new Sequence(Sequence.PPQ, 4);//Создаём последовательность(секвенцию)
            Track track = seq.createTrack();//Запрашиваем (Создаём) Track у последовательности (seq) в который будем добавлять midi события

            //Цикл для заполнения Tracka миди собитиями посредством ShortMessage ... (инстр,нота,длит и т.д.)
            // Цикл для создания набора-группы событий, чтобы проиграть пассаж нот вверх, заполняем трек seq (секвенциями, событиями)
            int r = 0;
            for (int i = 25; i < 145; i += 2) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));//добавляем в трек seq (секвенцию, композицию)

                track.add(makeEvent(176, 1, 127, 0, i));//Ловим ритм

                track.add(makeEvent(128, 1, r, 100, i + 2));
            }
            //Запускаем синт
            sequencer.setSequence(seq);//передаём последовательность в синт для воспроизведения последовательности набора нот
            sequencer.setTempoInBPM(220);//темп
            sequencer.start();//запускаем синт

        } catch (Exception ex) {ex.printStackTrace();}
    }
    //makeEvent - Метод для создания объекта миди-события и его описания
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();//Создаём объект 'a' для хранения миди события
            a.setMessage(comd, chan, one, two);//Помещаем в объект 'a' (миди событие) информацию с его описанием (инстр,нота,длит и т.д.)
            event = new MidiEvent(a, tick);//в объект event передаём инструкцию 'a' в виде объекта; new MidiEvent(a - объект ShortMessage , tick - момент когда воспроизводить a)
        } catch(Exception e) {}
        return event;
    }
    //?????????????????????????????????
    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }
        public void paintComponent(Graphics g) {
            if(msg) {
                Graphics2D g2d = (Graphics2D) g;
                /// Цвет верх круга
                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                Color startColor = new Color(red,green,blue);

                // Цвет низ круга
                red = (int) (Math.random() * 255);
                green = (int) (Math.random() * 255);
                blue = (int) (Math.random() * 255);
                Color endColor = new Color(red,green,blue);

                //Определяем высоту и ширину прямоугольника
                int ht = (int) ((Math.random() * 500) + 10);
                int width = (int) ((Math.random() * 500) + 10);

                //Определяем координаты откуда начать рисовать прямоугольник
                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                GradientPaint gradient = new GradientPaint(x,y,startColor, x * 10, y * 10, endColor);
                g2d.setPaint(gradient);

                //Рисуем прямоугольник по заданнным выше координатам и цвету
                g.fillRect(x, y, ht, width);
                //Флаг вниз после прорисовки прямоугольника
                msg = false;
            }//Закр if(msg)
        }//закр метод paintComponent(Graphics g)
    }//закр внутр класс MyDrawPanel extends JPanel implements ControllerEventListener
}//закр внеш класс MiniMusicPlayer3
