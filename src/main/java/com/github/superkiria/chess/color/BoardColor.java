package com.github.superkiria.chess.color;

import lombok.Getter;

@Getter
public enum BoardColor {
    RED (new Color(224, 144, 139, 1f),
            new Color(251, 240, 239, 1f),
            new Color(253, 254, 0, .4f)),
    ORANGE (new Color(242, 163, 113, 1f),
            new Color(253, 239, 229, 1f),
            new Color(253, 254, 0, .4f)),
    YELLOW (new Color(232, 193, 101, 1f),
            new Color(250, 241, 220, 1f),
            new Color(0, 254, 253, .4f)),
    GREEN (new Color(75, 210, 156, 1f),
            new Color(235, 250, 244, 1f),
            new Color(253, 254, 0, .4f)),
    LIGHT_BLUE (new Color(18, 217, 231, 1f),
            new Color(229, 251, 253, 1f),
            new Color(253, 254, 0, .4f)),
    BLUE (new Color(153, 181, 246, 1f),
            new Color(246, 249, 254, 1f),
            new Color(253, 254, 0, .4f)),
    VIOLET (new Color(229, 142, 229, 1f),
            new Color(250, 232, 250, 1f),
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
