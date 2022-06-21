package com.github.superkiria.chess.color;

import lombok.Getter;

@Getter
public enum BoardColor {
    RED (new Color(247, 173, 186, 1f),
            new Color(253, 238, 241, 1f),
            new Color(253, 254, 0, .4f)),
    ORANGE (new Color(235, 197, 160, 1f),
            new Color(251, 243, 236, 1f),
            new Color(253, 254, 0, .4f)),
    YELLOW (new Color(227, 222, 152, 1f),
            new Color(249, 248, 234, 1f),
            new Color(0, 254, 253, .4f)),
    GREEN (new Color(126, 237, 209, 1f),
            new Color(229, 251, 246, 1f),
            new Color(253, 254, 0, .4f)),
    LIGHT_BLUE (new Color(137, 224, 224, 1f),
        new Color(232, 249, 249, 1f),
        new Color(253, 254, 0, .4f)),
    BLUE (new Color(156, 201, 230, 1f),
            new Color(235, 244, 250, 1f),
            new Color(253, 254, 0, .4f)),
    VIOLET (new Color(214, 158, 230, 1f),
            new Color(247, 236, 250, 1f),
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
