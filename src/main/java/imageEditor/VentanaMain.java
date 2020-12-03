package imageEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaMain implements Runnable {
    @Override
    public void run() {
        // FRAME
        JFrame Window = new JFrame("Ventana principal de Probando Swing");
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 25, 25);
        Window.setLayout(layout);

        // PANEL
        final JPanel panel = new JPanel(layout);
        panel.setSize(new Dimension(700, 850));
        panel.setBackground(Color.ORANGE);
        panel.setPreferredSize(new Dimension(700, 850));
        Window.add(panel);

        // DEFINIMOS ESCUCHADOR DE EVENTOS PARA CUANDO HAGAMOS CLICK SOBRE LOS BOTONES
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton boton = (JButton) ae.getSource();
                String ButtonName = boton.getText();

                switch (ButtonName) {
                    case "INPUT FILE":
                        File inputFile = new FileSelector().inputImage();
                        BufferedImage myPicture = null;
                        try {
                            myPicture = ImageIO.read(inputFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Image dimg = myPicture.getScaledInstance(panel.getWidth(), panel.getHeight(),
                                Image.SCALE_SMOOTH);
                        JLabel picLabel = new JLabel(new ImageIcon(dimg));
                        panel.add(picLabel, BorderLayout.CENTER);
                        panel.revalidate();
                        panel.repaint();
                        break;
                    case "Botón 2":
                        //String outputFile = new FileSelector().outputImage();
                        break;
                    case "Botón 3":
                        panel.setBackground(Color.BLACK);
                        break;
                    case "Botón 4":
                        panel.setBackground(Color.CYAN);
                        break;
                    case "Botón 5":
                        panel.setBackground(Color.GREEN);
                        break;
                    case "Botón 6":
                        panel.setBackground(Color.MAGENTA);
                        break;
                    case "Botón 7":
                        panel.setBackground(Color.PINK);
                        break;
                }
            }
        };

        // BOTONES
        String[] ButtonTitle = {"INPUT FILE", "Botón 2", "Botón 3", "Botón 4", "Botón 5", "Botón 6", "Botón 7"};

        for (String tituloBoton : ButtonTitle) {
            JButton boton = new JButton(tituloBoton);
            boton.setSize(new Dimension(150, 80));
            Window.add(boton);
            boton.addActionListener(listener);
        }

        // PANEL --> Area de Texto
        String textoCualquiera = "Joachim Löw celebró jugar la final del Mundial de Brasil frente a Argentina, "
                + "un duelo que calificó de \"magnífica constelación\". \"Europa contra Sudamérica. Una magnífica "
                + "constelación\", dijo el seleccionador alemán tras la victoria de Argentina ante Holanda en la "
                + "segunda semifinal.\n"
                + "\"Argentina es fuerte defensivamente, compacta, bien organizada\", comentó Löw. \"En ataque "
                + "tienen jugadores extraordinarios como Messi e Higuaín. Nos vamos a preparar bien y nos "
                + "alegramos del partido en Río\", prosiguió el preparador alemán.\n"
                + "Argentina y Alemania se enfrentarán el domingo en Maracaná por tercera vez en una final de un "
                + "Mundial. Argentina, liderarda por Diego Armando Maradona, se impuso por 3-2 en la final de "
                + "México'86, mientras que Alemania se tomó revancha en Italia'90 venciendo por 1-0.\n"
                + "\n"
                + "\n"
                + "Leer mï¿œs: Alemania-Argentina: Löw ve la final frente a Argentina como una \"magnífica "
                + "constelación\" - MARCA.com";
        JTextArea texto = new JTextArea("", 15, 40);
        texto.setText(textoCualquiera);
        texto.setFont(new Font("Monospace", Font.PLAIN, 14));
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setForeground(Color.WHITE);
        texto.setBackground(Color.BLACK);

        // SCROLL
        JScrollPane scroll = new JScrollPane(texto);
        panel.add(scroll);

        // ETIQUETA
        JLabel etiqueta = new JLabel("En esta etiqueta comento que la Window tiene " + ButtonTitle.length + " botones.");
        etiqueta.setForeground(Color.RED);
        etiqueta.setFont(new Font("Serif", Font.BOLD, 20));
        Window.add(etiqueta);

        // IMAGEN

        // END
        Window.setSize(800, 1200);
        Window.setVisible(true);
    }

}

