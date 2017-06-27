package DeSerializeable;


import java.io.Serializable;

/**
 * Created by Smile on 15.06.2017.
 */
public class GameCharacter implements Serializable{
    int power;
    String type;
    String[] weapons;

    public GameCharacter (int p, String t, String[] w) {
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower() {
        return power;
    }
    public String getType() {
        return type;
    }
    public String getWeapons() {
        String weaponList = "";
        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons[i] + " ";

        }
        return weaponList;
    }
}
