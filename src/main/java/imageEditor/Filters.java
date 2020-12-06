package imageEditor;

/**
 * @author Dani Apesteguia - Codepressed
 * @since   2020-11-30
 * @version 1.0
 **/

public class Filters {
    private final int filterBorderDetect[] =
            {0, 1, 0,
            1, -4, 1,
            0, 1, 0};

    private final int filterSharp[] =
            {0, -1, 0,
            -1, 5, -1,
            0, -1, 0};


    private final int filterUnfocus[] =
            {1, 1, 1,
             1, 1, 1,
             1, 1, 1};

    public int[] getFilterBorderDetect() {
        return filterBorderDetect;
    }

    public int[] getFilterSharp() {
        return filterSharp;
    }

    public int[] getFilterUnfocus() {
        return filterUnfocus;
    }



}
