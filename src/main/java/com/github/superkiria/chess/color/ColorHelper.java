package com.github.superkiria.chess.color;

public class ColorHelper {

    private static final int MIN = 140;
    private static final int MID = 180;
    private static final int MAX = 220;

    private static final int W_MAX = 255;
    private static final int W_FIX = 10;

    private static final int[][] blackColors = {
            {MIN + 20, 137, 255},
            {118, 200, 118},
            {MAX, MIN, MIN},

            {103, 192, 192},
            {192, 192, 103},
            {MAX, MIN, MAX},

            {MAX - 5, MID - 5, MIN - 5},
            {110, 200, 155},
            {200, 137, 245},

            {MAX, MIN, MID},
            {150, 200, 105},
            {110, 172, MAX},

    };

    private static final int[][] whiteColors = {

            {W_MAX - W_FIX, W_MAX - W_FIX * 2, W_MAX},
            {W_MAX - W_FIX * 2, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX, W_MAX - W_FIX * 2, W_MAX - W_FIX * 2},

            {W_MAX - W_FIX * 2, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX, W_MAX - W_FIX * 2, W_MAX - W_FIX * 2},

            {W_MAX, W_MAX - W_FIX, W_MAX - W_FIX * 2},
            {W_MAX - W_FIX * 2, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX - W_FIX, W_MAX - W_FIX * 2, W_MAX},

            {W_MAX, W_MAX - W_FIX * 2, W_MAX - W_FIX * 2},
            {W_MAX - W_FIX, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX - W_FIX * 2, W_MAX - W_FIX, W_MAX - W_FIX * 2},

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
