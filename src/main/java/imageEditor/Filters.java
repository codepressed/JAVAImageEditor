package imageEditor;

public class Filters {
    public final int filterFocus[] =
            {0,0,0,0,0,
            0,0,-1,0,0,
            0,-1,5,-1,0,
            0,0,-1,0,0,
            0,0,0,0,0};
    public final int filterBorderDetect[] =
            {0, 1, 0,
            1, -4, 1,
            0, 1, 0};
}
