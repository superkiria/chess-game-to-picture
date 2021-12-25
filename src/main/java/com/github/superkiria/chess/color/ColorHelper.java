package com.github.superkiria.chess.color;

public class ColorHelper {

    private static final int MIN = 140;
    private static final int MID = 180;
    private static final int MAX = 220;

    private static final int W_MIN = 230;
    private static final int W_MID = 240;
    private static final int W_MAX = 250;

    private static final int[][] blackColors = {
            {MIN, 120, MAX},
            {103, 170, 103},
            {MAX, MIN, MIN},

            {103, 192, 192},
            {192, 192, 103},
            {MAX, MIN, MAX},

            {MAX - 5, MID - 5, MIN - 5},
            {100, 180, 140},
            {165, 128, 210},

            {MAX, MIN, MID},
            {140, 180, 100},
            {103, 162, 215},

    };

    private static final int[][] whiteColors = {

            {224, W_MIN, 242},
            {W_MIN, 240, 224},
            {240, W_MIN, 224},

            {W_MIN, W_MAX, 242},
            {242, 242, W_MIN},
            {242, 224, 242},

            {W_MAX, W_MID, W_MIN},
            {W_MIN, W_MAX - 10, W_MID},
            {W_MID, W_MIN, W_MAX - 10},

            {W_MAX - 10, W_MIN, W_MID},
            {W_MID, W_MAX - 10, W_MIN},
            {224, 239, 242},

    };

    public static int getBlack(int dominant) {
        int[] a = blackColors[dominant % blackColors.length];
        return a[0] * 256 * 256 + a[1] * 256 + a[2];
    }

    public static int getWhite(int dominant) {
        int[] a = whiteColors[dominant % whiteColors.length];
        return a[0] * 256 * 256 + a[1] * 256 + a[2];
    }

}
