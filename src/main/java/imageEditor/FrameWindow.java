package imageEditor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * @author Dani Apesteguia - Codepressed
 * @since   2020-11-30
 * @version 1.0
 **/

public class FrameWindow extends JPanel{

    GridBagConstraints gCons = new GridBagConstraints();

    public FrameWindow(String title){
        setLayout(new GridBagLayout());
        gCons.weightx = 5;
        gCons.weighty = 11;
        gCons.fill = GridBagConstraints.HORIZONTAL;

        //Text conf
        Font fontBold = new Font("Courier",Font.BOLD,15);


        JLabel fileText = new JLabel("ARCHIVO");
        fileText.setFont(fontBold);
        fileText.setHorizontalAlignment(JLabel.CENTER);
        fileText.setPreferredSize(new Dimension(50,20));
        gCons.gridx = 0;
        gCons.gridy = 0;
        gCons.gridwidth = 1;

        add(fileText, gCons);

        JLabel imgText = new JLabel("IMAGEN");
        imgText.setFont(fontBold);
        imgText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        add(imgText, gCons);

        JLabel zoneText = new JLabel("ZONA");
        zoneText.setFont(fontBold);
        zoneText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 4;
        gCons.gridwidth = 1;
        add(zoneText, gCons);

        JLabel sizeText = new JLabel("Tamaño");
        sizeText.setHorizontalAlignment(JLabel.CENTER);
        sizeText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 5;
        gCons.gridwidth = 1;
        add(sizeText, gCons);

        JLabel brightText = new JLabel("BRILLO");
        brightText.setFont(fontBold);
        brightText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 6;
        gCons.gridwidth = 1;
        add(brightText, gCons);

        JLabel totalText = new JLabel("Total");
        totalText.setHorizontalAlignment(JLabel.CENTER);
        totalText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 7;
        gCons.gridwidth = 1;
        add(totalText, gCons);

        JLabel redSliderText = new JLabel("Canal Rojo");
        redSliderText.setHorizontalAlignment(JLabel.CENTER);
        redSliderText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 8;
        gCons.gridwidth = 1;
        add(redSliderText, gCons);

        JLabel greenSliderText = new JLabel("Canal Verde");
        greenSliderText.setHorizontalAlignment(JLabel.CENTER);
        greenSliderText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 9;
        gCons.gridwidth = 1;
        add(greenSliderText, gCons);

        JLabel blueSliderText = new JLabel("Canal Azul");
        blueSliderText.setHorizontalAlignment(JLabel.CENTER);
        blueSliderText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 10;
        gCons.gridwidth = 1;
        add(blueSliderText, gCons);

        JLabel colorText = new JLabel("COLOR");
        colorText.setFont(fontBold);
        colorText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 11;
        gCons.gridwidth = 1;
        add(colorText, gCons);

        JLabel fireText = new JLabel("EFECTOS");
        fireText.setFont(fontBold);
        fireText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 12;
        gCons.gridwidth = 1;
        add(fireText, gCons);


        //Button conf
        JButton imageCharge = new JButton("Cargar imagen");
        imageCharge.setSize(new Dimension(170,30));
        gCons.gridx = 1;
        gCons.gridy = 0;
        gCons.gridwidth = 3;
        add(imageCharge, gCons);

        JButton imgOpt1 = new JButton("1");
        gCons.gridx = 1;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        add(imgOpt1, gCons);

        JButton imgOpt2 = new JButton("2");
        gCons.gridx = 2;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        add(imgOpt2, gCons);

        JButton imgOpt3 = new JButton("3");
        gCons.gridx = 3;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        add(imgOpt3, gCons);

        JButton sizeAll = new JButton("Todo");
        gCons.gridx = 1;
        gCons.gridy = 4;
        gCons.gridwidth = 1;
        add(sizeAll, gCons);

        JButton sizeCustom = new JButton("Recuadro");
        gCons.gridx = 2;
        gCons.gridy = 4;
        gCons.gridwidth = 2;
        add(sizeCustom, gCons);

        JButton clearBright = new JButton("Reset Brillo");
        gCons.gridx = 1;
        gCons.gridy = 6;
        gCons.gridwidth = 3;
        add(clearBright, gCons);

        JButton grayScale = new JButton("Convertir a gris");
        gCons.gridx = 1;
        gCons.gridy = 11;
        gCons.gridwidth = 3;
        add(grayScale, gCons);

        JButton fire = new JButton("Generar fuego");
        gCons.gridx = 1;
        gCons.gridy = 13;
        gCons.gridwidth = 3;
        add(fire, gCons);

        //Slider conf
        JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        gCons.gridx = 1;
        gCons.gridy = 5;
        gCons.gridwidth = 3;
        add(sizeSlider, gCons);

        JSlider totalSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        totalSlider.setMinorTickSpacing(25);
        totalSlider.setPaintLabels(true);
        totalSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 7;
        gCons.gridwidth = 3;
        add(totalSlider, gCons);

        JSlider redColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        redColorSlider.setBackground(Color.red);
        redColorSlider.setMinorTickSpacing(25);
        redColorSlider.setPaintLabels(true);
        redColorSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 8;
        gCons.gridwidth = 3;
        add(redColorSlider, gCons);

        JSlider greenColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenColorSlider.setBackground(Color.green);
        greenColorSlider.setMinorTickSpacing(25);
        greenColorSlider.setPaintLabels(true);
        greenColorSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 9;
        gCons.gridwidth = 3;
        add(greenColorSlider, gCons);

        JSlider blueColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueColorSlider.setBackground(Color.blue);
        blueColorSlider.setMinorTickSpacing(25);
        blueColorSlider.setPaintLabels(true);
        blueColorSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 10;
        gCons.gridwidth = 3;
        add(blueColorSlider, gCons);

        JSlider focusSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        focusSlider.setMinorTickSpacing(25);
        focusSlider.setPaintLabels(true);
        focusSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 12;
        gCons.gridwidth = 2;
        add(focusSlider, gCons);






    }

    public static void main(String[] args) {
        //Frame conf
        FrameWindow framewindow = new FrameWindow("hi");
        JFrame editorFrame = new JFrame();
        editorFrame.setTitle("Image editor");
        editorFrame.setSize(1500,1000);
        editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorFrame.setVisible(true);
        editorFrame.add(framewindow);
    }
}
