package com.github.superkiria.chess.model;

public class PieceOnBoard {

    private final int x;
    private final int y;
    private final String piece;

    public PieceOnBoard(int x, int y, String piece) {
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

    public String getPiece() {
        return piece;
    }

}
