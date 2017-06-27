import java.io.FileWriter;

/**
 * Created by Smile on 16.06.2017.
 */
public class WriteAFile {
    public static void main(String[] args) {
       String[] ar = {"массив массив массив массив массив массив массив массив"};
        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Hello world! This is my first string ");
            writer.write(ar[0]);
            writer.close();
        } catch(Exception ex) {ex.printStackTrace();}
    }
}
