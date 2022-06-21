package com.github.superkiria.chess.color;

import lombok.Getter;

@Getter
public enum BoardColor {
    BLUE_PURPLE (new Color(180, 164, 237, 1f),
            new Color(238, 234, 251, 1f),
            new Color(253, 254, 0, .4f)),
    PALE_CERULEAN (new Color(140, 192, 230, 1f),
            new Color(236, 240, 250, 1f),
            new Color(253, 254, 0, .4f)),
    BLUE_GREEN (new Color(141, 217, 215, 1f),
            new Color(232, 243, 250, 1f),
            new Color(253, 254, 0, .4f)),
    TURQUOISE_GREEN (new Color(159, 214, 183, 1f),
            new Color(234, 247, 247, 1f),
            new Color(253, 254, 0, .4f)),
    LAUREL_GREEN (new Color(184, 199, 177, 1f),
            new Color(241, 244, 240, 1f),
            new Color(253, 254, 0, .4f)),
    DESERT_SAND (new Color(232, 187, 153, 1f),
            new Color(250, 241, 234, 1f),
            new Color(253, 254, 0, .4f)),
    PASTEL_PINK (new Color(230, 163, 163, 1f),
            new Color(250, 237, 237, 1f),
            new Color(253, 254, 0, .4f));

    private final Color black;
    private final Color white;
    private final Color highlight;

    BoardColor(Color black, Color white, Color highlight) {
        this.black = black;
        this.white = white;
        this.highlight = highlight;
    }

    public static int getBlack(int number) {
        return BoardColor.values()[(number % BoardColor.values().length)].getBlack().getColor();
    }

    public static int getWhite(int number) {
        return BoardColor.values()[(number % BoardColor.values().length)].getWhite().getColor();
    }

}
