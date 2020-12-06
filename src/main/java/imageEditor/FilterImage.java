package imageEditor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * @author Dani Apesteguia - Codepressed
 * @since   2020-11-30
 * @version 1.0
 **/

public class FilterImage {
    public BufferedImage FilteredImage (File imageToFilter, String filterName) throws IOException {
        Filters filters = new Filters();
        int[] filter = null;

        switch (filterName){
            case "BorderDetect":
                filter = filters.getFilterBorderDetect();
                break;
            case "Sharp":
                filter = filters.getFilterSharp();
                break;
            case "Unfocus":
                filter = filters.getFilterUnfocus();
                break;
        }
        int kernelWidth = (int) Math.sqrt(filter.length);
        int kernelDivisor = IntStream.of(filter).sum();
        if (kernelDivisor == 0){
            kernelDivisor = 1;
        }
        System.out.println("Kernel size: " + kernelWidth + "x" + kernelWidth +
                ", divisor=" + kernelDivisor);
        Convolution.ArrayData kernel = new Convolution.ArrayData(kernelWidth, kernelWidth);
        for (int i = 0; i < kernelWidth; i++)
        {
            System.out.print("[");
            for (int j = 0; j < kernelWidth; j++)
            {
                kernel.set(j, i, filter[kernelWidth*i+j]);
                System.out.print(" " + kernel.get(j, i) + " ");
            }
            System.out.println("]");
        }

        Convolution.ArrayData[] dataArrays = Convolution.getArrayDatasFromImage(imageToFilter);
        for (int i = 0; i < dataArrays.length; i++)
            dataArrays[i] = Convolution.convolute(dataArrays[i], kernel, kernelDivisor);
        BufferedImage filteredImage = Convolution.outputImage(dataArrays);
        return filteredImage;
    }
}
