package com.github.superkiria.chess.color;

import lombok.Getter;

@Getter
public enum BoardColor {
    RED (new Color(220, 156, 156, 1f),
            new Color(255, 245, 245, 1f),
            new Color(253, 254, 0, .4f)),
    ORANGE (new Color(220, 190, 120, 1f),
            new Color(255, 250, 245, 1f),
            new Color(253, 254, 0, .4f)),
    YELLOW (new Color(190, 190, 110, 1f),
            new Color(250, 250, 240, 1f),
            new Color(253, 254, 0, .4f)),
    GREEN (new Color(130, 198, 130, 1f),
            new Color(245, 255, 240, 1f),
            new Color(253, 254, 0, .4f)),
    LIGHT_BLUE (new Color(107, 178, 240, 1f),
            new Color(240, 245, 240, 1f),
            new Color(253, 254, 0, .4f)),
    BLUE (new Color(150, 150, 250, 1f),
            new Color(243, 245, 255, 1f),
            new Color(253, 254, 0, .4f)),
    VIOLET (new Color(190, 142, 244, 1f),
            new Color(243, 245, 255, 1f),
            new Color(253, 254, 0, .4f)),
    DEFAULT (new Color(215, 178, 140, 1f),
            new Color(255, 245, 240, 1f),
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
