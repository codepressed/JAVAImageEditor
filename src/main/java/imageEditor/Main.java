package imageEditor;

/**
 * @author Dani Apesteguia - Codepressed
 * @since   2020-11-30
 * @version 1.0
 **/
public class Main{
    public static void main(String[] args) {

        Runnable imageEditorViewer = new PanelInterface();
        Thread thread = new Thread(imageEditorViewer);
        thread.start();



    }
}
