import javax.sound.midi.Soundbank;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Саша on 02.07.2017.
 */
public class SortMountais {
    LinkedList<Mountain> mtn = new LinkedList<>();

    class NameCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return one.getName().compareTo(two.getName());
        }
    }

    class Heightcompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return (two.height - one.height);
        }
    }

    public static void main(String[] args) {
        new SortMountais().go();
    }

    public void go() {
        mtn.add(new Mountain("Лонг_Рейндж", 14255));
        mtn.add(new Mountain("Эльберт", 14433));
        mtn.add(new Mountain("Марун", 14156));
        mtn.add(new Mountain("Касл", 14265));

        System.out.println("В порядке добавления: \n" + mtn);

        NameCompare nc = new NameCompare();
        Collections.sort(mtn, nc);
        System.out.println("По названию: \n" + mtn);

        Heightcompare hc = new Heightcompare();
        Collections.sort(mtn, hc);
        System.out.println("По высоте: \n" + mtn);
    }


    class Mountain {
        String name;
        int height;
         public Mountain(String n, int h) {
             name = n;
             height = h;
         }
         public String getName() {
             return name;
         }
         public String toString() {
             return (name + " " + height);
         }
    }
}
