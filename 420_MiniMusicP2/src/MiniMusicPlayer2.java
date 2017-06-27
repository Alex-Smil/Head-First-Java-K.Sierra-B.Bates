import javax.sound.midi.*;

/**
 * Created by Smile on 10.06.2017.
 */
public class MiniMusicPlayer2 implements ControllerEventListener {
    int countOfNotes;
    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try {
            //Создаём и открываем синт
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);

            //Создаём последовательность(секвенцию) и дорожку
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //Создаём группу событий, чтобы проиграть пассаж нот вверх
            for (int i = 25; i < 145; i += 2) {
                track.add(makeEvent(144, 1, i, 100, i));

                track.add(makeEvent(176, 1, 127, 0, i));//Ловим ритм

                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            //Запускаем синт
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void controlChange(ShortMessage event) {
        System.out.println(countOfNotes);
        countOfNotes++;
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch(Exception e) {}
        return event;
    }

}
