package DeSerializeable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Smile on 15.06.2017.
 */
public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50,"Эльф",new String[]{"лук","меч","кастет"});
        GameCharacter two = new GameCharacter(200,"Троль",new String[]{"голые руки","большой топор"});
        GameCharacter three = new GameCharacter(120,"Маг",new String[]{"заклинания","невидимость"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch(Exception ex) {ex.printStackTrace();}

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();
        } catch(Exception ex) {ex.printStackTrace();}

    }
}
