package com.github.superkiria.chess.svg;

public enum SvgFilesForPieces {

    WHITE_KING (0, "K", "Chess_klt45.svg"),
    WHITE_QUEEN (0, "Q", "Chess_qlt45.svg"),
    WHITE_ROOK (0, "R", "Chess_rlt45.svg"),
    WHITE_BISHOP (0, "B", "Chess_blt45.svg"),
    WHITE_KNIGHT (0, "K", "Chess_klt45.svg"),
    WHITE_PAWN (0, "P", "Chess_plt45.svg"),
    BLACK_KING (1, "K", "Chess_kdt45.svg"),
    BLACK_QUEEN (1, "Q", "Chess_qdt45.svg"),
    BLACK_ROOK (1, "R", "Chess_rdt45.svg"),
    BLACK_BISHOP (1, "B", "Chess_bdt45.svg"),
    BLACK_KNIGHT (1, "K", "Chess_kdt45.svg"),
    BLACK_PAWN (1, "P", "Chess_pdt45.svg");

    private int color;
    private String pgnLetter;
    private String fileName;

    SvgFilesForPieces(int color, String pgnLetter, String fileName) {
        this.color = color;
        this.pgnLetter = pgnLetter;
        this.fileName = fileName;
    }

    public int getColor() {
        return color;
    }

    public String getPgnLetter() {
        return pgnLetter;
    }

    public String getFileName() {
        return fileName;
    }

}
