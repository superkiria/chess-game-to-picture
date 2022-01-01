package com.github.superkiria.chess.color;

public class ColorHelper {

    private static final int MIN = 140;
    private static final int MID = 180;
    private static final int MAX = 220;

    private static final int W_MIN = 230;
    private static final int W_MID = 240;
    private static final int W_MAX = 250;

    private static int[][] blackColors = {
            {MIN, MIN, MAX},
            {MIN, MAX, MIN},
            {MAX, MIN, MIN},
            {MID, MIN, MAX},
            {MIN, MAX, MID},
            {MAX, MID, MIN},
            {MIN, MID, MAX},
            {MID, MAX, MIN},
            {MAX, MIN, MID},
            {MIN, MAX, MAX},
            {MAX, MAX, MIN},
            {MAX, MIN, MAX},
    };

    private static int[][] whiteColors = {
            {W_MIN, W_MIN, W_MAX},
            {W_MIN, W_MAX, W_MIN},
            {W_MAX, W_MIN, W_MIN},
            {W_MID, W_MIN, W_MAX},
            {W_MIN, W_MAX, W_MID},
            {W_MAX, W_MID, W_MIN},
            {W_MIN, W_MID, W_MAX},
            {W_MID, W_MAX, W_MIN},
            {W_MAX, W_MIN, W_MID},
            {W_MIN, W_MAX, W_MAX},
            {W_MAX, W_MAX, W_MIN},
            {W_MAX, W_MIN, W_MAX},
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
