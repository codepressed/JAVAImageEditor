package imageTests;

import javax.swing.*;
import java.awt.*;

public class Test1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new JButton("Left"), BorderLayout.WEST);
        frame.getContentPane().add(new JButton("Center"), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
