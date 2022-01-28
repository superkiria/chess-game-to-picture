package com.github.superkiria.chess.color;

public class ColorHelper {

    private static final int W_MAX = 255;
    private static final int W_FIX = 10;

    private static final int[][] blackColors = {
            {166, 146, 240},
            {130, 198, 130},
            {220, 156, 156},

            {123, 192, 192},
            {192, 192, 123},
            {220, 157, 220},

            {215, 178, 140},
            {120, 200, 160},
            {208, 153, 245},

            {220, 144, 182},
            {156, 200, 111},
            {110, 172, 220},

    };

    private static final int[][] whiteColors = {

            {W_MAX - W_FIX, W_MAX - W_FIX, W_MAX},
            {W_MAX - W_FIX, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX, W_MAX - W_FIX, W_MAX - W_FIX * 2},

            {W_MAX - W_FIX, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX, W_MAX - W_FIX, W_MAX - W_FIX * 2},

            {W_MAX, W_MAX - W_FIX, W_MAX - W_FIX * 2},
            {W_MAX - W_FIX, W_MAX, W_MAX - W_FIX * 2},
            {W_MAX - W_FIX, W_MAX - W_FIX, W_MAX - W_FIX * 2},

            {W_MAX, W_MAX - W_FIX, W_MAX - W_FIX * 2},
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
