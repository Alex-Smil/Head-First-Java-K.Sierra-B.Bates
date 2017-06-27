package Graphics2DGradientRandom_397;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Smile on 08.06.2017.
 */

public class Graphics2DGradientRan {
    public static void main(String[] args) {
        Graphics2DGradientRan gui = new Graphics2DGradientRan();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        MyDrawlPanel oval = new MyDrawlPanel();

        frame.getContentPane().add(oval);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setVisible(true);
    }
}
