package imageEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import javax.swing.SwingConstants;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.Object;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

/**
 * @author Dani Apesteguia - Codepressed
 * @since   2020-11-30
 * @version 1.0
 **/

public class SplitPane extends JFrame implements ActionListener, ChangeListener {

    private     JSplitPane  splitPaneV;
    private     JSplitPane  splitPaneH;
    private     JPanel      panel1;
    private     JPanel      panel2;
    private Image imagePreview = null;
    private Image image1 = null;
    private Image image2 = null;
    private Image image3 = null;


    public SplitPane(){
        setTitle( "Split Pane Application" );
        setBackground( Color.gray );

        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create the panels
        createPanel1();
        createPanel2();

        // Create a splitter pane
        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        topPanel.add( splitPaneV, BorderLayout.CENTER );

        splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneH.setLeftComponent( panel1 );
        splitPaneH.setRightComponent( panel2 );

        splitPaneV.setLeftComponent( splitPaneH );
    }

    public void createPanel1(){
        panel1 = new JPanel();
        panel1.setLayout( new GridBagLayout() );
        GridBagConstraints gCons = new GridBagConstraints();

        gCons.weightx = 5;
        gCons.weighty = 11;
        gCons.fill = GridBagConstraints.HORIZONTAL;

        Font fontBold = new Font("Courier", Font.BOLD, 15);

        JLabel fileText = new JLabel("ARCHIVO");
        fileText.setFont(fontBold);
        fileText.setHorizontalAlignment(JLabel.CENTER);
        fileText.setPreferredSize(new Dimension(50, 20));
        gCons.gridx = 0;
        gCons.gridy = 0;
        gCons.gridwidth = 1;

        panel1.add(fileText, gCons);

        JLabel imgText = new JLabel("IMAGEN");
        imgText.setFont(fontBold);
        imgText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        panel1.add(imgText, gCons);

        JLabel zoneText = new JLabel("ZONA");
        zoneText.setFont(fontBold);
        zoneText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 4;
        gCons.gridwidth = 1;
        panel1.add(zoneText, gCons);

        JLabel sizeText = new JLabel("Tamaño");
        sizeText.setHorizontalAlignment(JLabel.CENTER);
        sizeText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 5;
        gCons.gridwidth = 1;
        panel1.add(sizeText, gCons);

        JLabel brightText = new JLabel("BRILLO");
        brightText.setFont(fontBold);
        brightText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 6;
        gCons.gridwidth = 1;
        panel1.add(brightText, gCons);

        JLabel totalText = new JLabel("Total");
        totalText.setHorizontalAlignment(JLabel.CENTER);
        totalText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 7;
        gCons.gridwidth = 1;
        panel1.add(totalText, gCons);

        JLabel redSliderText = new JLabel("Canal Rojo");
        redSliderText.setHorizontalAlignment(JLabel.CENTER);
        redSliderText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 8;
        gCons.gridwidth = 1;
        panel1.add(redSliderText, gCons);

        JLabel greenSliderText = new JLabel("Canal Verde");
        greenSliderText.setHorizontalAlignment(JLabel.CENTER);
        greenSliderText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 9;
        gCons.gridwidth = 1;
        panel1.add(greenSliderText, gCons);

        JLabel blueSliderText = new JLabel("Canal Azul");
        blueSliderText.setHorizontalAlignment(JLabel.CENTER);
        blueSliderText.setForeground(Color.GRAY);
        gCons.gridx = 0;
        gCons.gridy = 10;
        gCons.gridwidth = 1;
        panel1.add(blueSliderText, gCons);

        JLabel colorText = new JLabel("COLOR");
        colorText.setFont(fontBold);
        colorText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 11;
        gCons.gridwidth = 1;
        panel1.add(colorText, gCons);

        JLabel fireText = new JLabel("FILTROS");
        fireText.setFont(fontBold);
        fireText.setHorizontalAlignment(JLabel.CENTER);
        gCons.gridx = 0;
        gCons.gridy = 12;
        gCons.gridwidth = 1;
        panel1.add(fireText, gCons);


        //Button conf
        final JButton imageCharge = new JButton("Cargar imagen");
        imageCharge.setSize(new Dimension(170, 30));
        imageCharge.addActionListener(this);
        gCons.gridx = 1;
        gCons.gridy = 0;
        gCons.gridwidth = 3;
        panel1.add(imageCharge, gCons);

        JButton imgOpt1 = new JButton("1");
        imgOpt1.addActionListener(this);
        gCons.gridx = 1;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        panel1.add(imgOpt1, gCons);

        JButton imgOpt2 = new JButton("2");
        imgOpt2.addActionListener(this);
        gCons.gridx = 2;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        panel1.add(imgOpt2, gCons);

        JButton imgOpt3 = new JButton("3");
        imgOpt3.addActionListener(this);
        gCons.gridx = 3;
        gCons.gridy = 3;
        gCons.gridwidth = 1;
        panel1.add(imgOpt3, gCons);

        JButton sizeAll = new JButton("Todo");
        sizeAll.addActionListener(this);
        gCons.gridx = 1;
        gCons.gridy = 4;
        gCons.gridwidth = 1;
        panel1.add(sizeAll, gCons);

        JButton sizeCustom = new JButton("Recuadro");
        sizeCustom.addActionListener(this);
        gCons.gridx = 2;
        gCons.gridy = 4;
        gCons.gridwidth = 2;
        panel1.add(sizeCustom, gCons);

        JButton clearBright = new JButton("Reset Brillo");
        clearBright.addActionListener(this);
        gCons.gridx = 1;
        gCons.gridy = 6;
        gCons.gridwidth = 3;
        panel1.add(clearBright, gCons);

        JButton grayScale = new JButton("Convertir a gris");
        grayScale.addActionListener(this);
        gCons.gridx = 1;
        gCons.gridy = 11;
        gCons.gridwidth = 3;
        panel1.add(grayScale, gCons);

        JButton fire = new JButton("Generar fuego");
        fire.addActionListener(this);
        gCons.gridx = 1;
        gCons.gridy = 13;
        gCons.gridwidth = 3;
        panel1.add(fire, gCons);

        //Slider conf
        JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        gCons.gridx = 1;
        gCons.gridy = 5;
        gCons.gridwidth = 3;
        panel1.add(sizeSlider, gCons);

        JSlider totalSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        totalSlider.setMinorTickSpacing(25);
        totalSlider.setPaintLabels(true);
        totalSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 7;
        gCons.gridwidth = 3;
        panel1.add(totalSlider, gCons);

        JSlider redColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        redColorSlider.setBackground(Color.red);
        redColorSlider.setMinorTickSpacing(25);
        redColorSlider.setPaintLabels(true);
        redColorSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 8;
        gCons.gridwidth = 3;
        panel1.add(redColorSlider, gCons);

        JSlider greenColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenColorSlider.setBackground(Color.green);
        greenColorSlider.setMinorTickSpacing(25);
        greenColorSlider.setPaintLabels(true);
        greenColorSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 9;
        gCons.gridwidth = 3;
        panel1.add(greenColorSlider, gCons);

        JSlider blueColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueColorSlider.setBackground(Color.blue);
        blueColorSlider.setMinorTickSpacing(25);
        blueColorSlider.setPaintLabels(true);
        blueColorSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 10;
        gCons.gridwidth = 3;
        panel1.add(blueColorSlider, gCons);

        JSlider focusSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        focusSlider.setMinorTickSpacing(25);
        focusSlider.setPaintLabels(true);
        focusSlider.setPaintTicks(true);
        gCons.gridx = 1;
        gCons.gridy = 12;
        gCons.gridwidth = 2;
        panel1.add(focusSlider, gCons);

    }
    private void imageChargeActionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
        }
    }

    public void createPanel2(){
        panel2 = new JPanel();
        panel2.setLayout( new FlowLayout() );
    }

    public static void main( String args[] ){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception evt) {}
        // Create an instance of the test application
        SplitPane mainFrame = new SplitPane();
        mainFrame.setSize(new Dimension(650,500));
        mainFrame.setPreferredSize(new Dimension(650,600));
        mainFrame.pack();
        mainFrame.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String ButtonName = boton.getText();

        switch (ButtonName) {
            case "Cargar imagen":
                System.out.println("Botón de Cargar imagen");
                File inputFile = new FileSelector().inputImage();
                BufferedImage myPictureOrigin = null;
                BufferedImage myPicture1 = null;
                BufferedImage myPicture2 = null;
                BufferedImage myPicture3 = null;
                try {
                    myPictureOrigin = ImageIO.read(inputFile);
                    myPicture1 = ImageIO.read(inputFile);
                    myPicture2 = ImageIO.read(inputFile);
                    myPicture3 = ImageIO.read(inputFile);

                } catch (Exception fail) {
                    fail.printStackTrace();
                }
                imagePreview = myPictureOrigin.getScaledInstance(panel2.getWidth(), panel2.getHeight(),
                        Image.SCALE_SMOOTH);
                image1 = myPicture1.getScaledInstance(panel2.getWidth(), panel2.getHeight(),
                        Image.SCALE_SMOOTH);
                image2 = myPicture2.getScaledInstance(panel2.getWidth(), panel2.getHeight(),
                        Image.SCALE_SMOOTH);
                image3 = myPicture3.getScaledInstance(panel2.getWidth(), panel2.getHeight(),
                        Image.SCALE_SMOOTH);
                JLabel picLabel = new JLabel(new ImageIcon(imagePreview));
                JLabel picLabel2 = new JLabel(new ImageIcon(image1));
                JLabel picLabel3 = new JLabel(new ImageIcon(image2));
                JLabel picLabel4 = new JLabel(new ImageIcon(image3));
                System.out.println(picLabel);
                panel2.add(picLabel, BorderLayout.CENTER);
                panel2.add(picLabel2,BorderLayout.CENTER);
                panel2.add(picLabel3,BorderLayout.CENTER);
                panel2.add(picLabel4,BorderLayout.CENTER);
                panel2.revalidate();
                panel2.repaint();
                break;
            case "1":
                System.out.println("Botón de 1");
                break;
            case "2":
                System.out.println("Boton de 2");
                break;
            case "3":
                System.out.println("Botón de 3");
                break;
            case "Todo":
                System.out.println("Botón de todo");
                break;
            case "Recuadro":
                System.out.println("Botón de recuadro");
                break;
            case "Reset brillo":
                System.out.println("Botón de Reset Brillo");
                break;
            case "Convertir a gris":
                System.out.println("Botón de convertir a gris");
                break;
            case "Generar fuego":
                System.out.println("Botón de Generar fuego");
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}