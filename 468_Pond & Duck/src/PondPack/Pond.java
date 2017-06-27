package PondPack;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Саша on 20.06.2017.
 */
public class Pond implements Serializable{

    transient private Duck duck = new Duck();

    public static void main(String[] args) {
        Pond myPond = new Pond();


        try {
            FileOutputStream fs = new FileOutputStream("File.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myPond);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


