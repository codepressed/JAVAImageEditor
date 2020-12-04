package imageEditor;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GrayScale {
    public BufferedImage GrayScaleConverter(File f){
        //Empty vars
        BufferedImage image = null;
        //Read image file
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e); //print error
        }

        //Getting width and height
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //Average of every pixel
                int avg = (r + g + b) / 3;

                //Changing RGB to Average
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                image.setRGB(x, y, p);
            }
        }
        return image;
    }
}
