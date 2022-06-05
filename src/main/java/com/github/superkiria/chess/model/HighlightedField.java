package com.github.superkiria.chess.model;

import com.github.superkiria.chess.color.Color;

public class HighlightedField {

    private final int x;
    private final int y;
    private final Color piece;

    public HighlightedField(int x, int y, Color piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getPiece() {
        return piece;
    }

}
