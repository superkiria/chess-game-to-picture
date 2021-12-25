package com.github.superkiria.chess.color;

import java.util.Random;

public class RandomColorHelper {

    private static final Random RANDOM = new Random();
    private static final int LOW_IN_BLACK = 102;
    private static final int HIGH_IN_BLACK = 214;
    private static final int MIDDLE_HIGH_IN_BLACK = 214;
    private static final int MIDDLE_LOW_IN_BLACK = 102;
    private static final int LOW_IN_WHITE = 210;
    private static final int HIGH_IN_WHITE = 240;
    private static final int MIDDLE_HIGH_IN_WHITE = 220;

    private static final int[][] cases = {

            {16 * 16, 16 * 16 * 16 * 16, 1},

            {16 * 16 * 16 * 16, 1, 16 * 16},

            {1, 16 * 16 * 16 * 16, 16 * 16},

            {16 * 16, 1, 16 * 16 * 16 * 16},

            {16 * 16 * 16 * 16, 16 * 16, 1},

            {1, 16 * 16, 16 * 16 * 16 * 16},
    };

    public static int getCase() {
        return RANDOM.nextInt(cases.length);
    }

    public static int getRandomBlack(int dominant) {
        int middle = RANDOM.nextInt(MIDDLE_HIGH_IN_BLACK - MIDDLE_LOW_IN_BLACK) + MIDDLE_LOW_IN_BLACK;
        int[] aCase = cases[dominant % cases.length];
        return aCase[0] * LOW_IN_BLACK + aCase[1] * HIGH_IN_BLACK + aCase[2] * middle;
    }

    public static int getRandomWhite(int dominant) {
        int middle = RANDOM.nextInt(HIGH_IN_WHITE - MIDDLE_HIGH_IN_WHITE) + MIDDLE_HIGH_IN_WHITE;
        int[] aCase = cases[dominant % cases.length];
        return aCase[0] * LOW_IN_WHITE + aCase[1] * HIGH_IN_WHITE + aCase[2] * middle;
    }

}
