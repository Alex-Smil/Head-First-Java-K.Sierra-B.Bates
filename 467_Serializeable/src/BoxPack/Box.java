package BoxPack;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Smile on 15.06.2017.
 */
public class Box implements Serializable {
    private int width;
    private int height;

    public void setWidth(int w) {
        width = w;
    }

    public void setHeght(int h) {
        height = h;
    }

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeght(20);

        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
        } catch (Exception ex) {ex.printStackTrace();}
    }
}
