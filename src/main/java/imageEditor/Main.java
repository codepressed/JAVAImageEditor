package imageEditor;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dani Apesteguia - Codepressed
 * @since   2020-11-30
 * @version 1.0
 **/
public class Main{
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception evt) {}

        SplitPane mainFrame = new SplitPane();
        mainFrame.setSize(new Dimension(650,500));
        mainFrame.setPreferredSize(new Dimension(650,600));
        mainFrame.pack();
        mainFrame.setVisible( true );

        Runnable runnable = new VentanaMain();
        Thread thread = new Thread(runnable);
        thread.start();



    }
}
