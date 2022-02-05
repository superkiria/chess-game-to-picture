package com.github.superkiria.chess.color;

import lombok.Getter;

@Getter
public enum BoardColor {
    BLUE_BELL (new Color(166, 146, 240, 1f),
                new Color(245, 245, 255, 1f),
                new Color(253, 254, 0, .4f)),
    GREEN_MINT (new Color(130, 198, 130, 1f),
                new Color(245, 255, 240, 1f),
                new Color(253, 254, 0, .4f)),
    PINK_KHAKI (new Color(220, 156, 156, 1f),
                new Color(255, 245, 245, 1f),
                new Color(253, 254, 0, .4f)),

    BLUE_AQUAMARINE (new Color(123, 192, 192, 1f),
                new Color(245, 255, 245, 1f),
                new Color(253, 254, 0, .4f)),
    YELLOW_KHAKI (new Color(192, 192, 123, 1f),
                new Color(255, 255, 240, 1f),
                new Color(253, 254, 0, .4f)),
    PINK_LILAC (new Color(220, 152, 220, 1f),
                new Color(255, 245, 240, 1f),
                new Color(253, 254, 0, .4f)),

    YELLOW_SAND (new Color(215, 178, 140, 1f),
                new Color(255, 245, 240, 1f),
                new Color(253, 254, 0, .4f)),
    GREEN_PATINAS (new Color(120, 200, 160, 1f),
                new Color(245, 255, 240, 1f),
                new Color(253, 254, 0, .4f)),
    BLUE_LILAC (new Color(200, 153, 245, 1f),
                new Color(245, 245, 240, 1f),
                new Color(253, 254, 0, .4f)),

    PINK_CLOVER (new Color(222, 144, 177, 1f),
                new Color(255, 245, 240, 1f),
                new Color(253, 254, 0, .4f)),
    GREEN_BAMBOO (new Color(156, 200, 111, 1f),
                new Color(245, 255, 240, 1f),
                new Color(253, 254, 0, .4f)),
    BLUE_JEANS (new Color(110, 172, 220, 1f),
                new Color(240, 245, 240, 1f),
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
