package com.github.superkiria.chess.svg;

public enum SvgFilesForPieces {

    K ("K", "Chess_klt45.svg"),
    Q ("Q", "Chess_qlt45.svg"),
    R ("R", "Chess_rlt45.svg"),
    B ("B", "Chess_blt45.svg"),
    N ("N", "Chess_nlt45.svg"),
    P ("P", "Chess_plt45.svg"),
    k ("k", "Chess_kdt45.svg"),
    q ("q", "Chess_qdt45.svg"),
    r ("r", "Chess_rdt45.svg"),
    b ("b", "Chess_bdt45.svg"),
    n ("n", "Chess_ndt45.svg"),
    p ("p", "Chess_pdt45.svg");

    private String pgnLetter;
    private String fileName;

    SvgFilesForPieces(String pgnLetter, String fileName) {
        this.pgnLetter = pgnLetter;
        this.fileName = fileName;
    }

    public String getPgnLetter() {
        return pgnLetter;
    }

    public String getFileName() {
        return fileName;
    }

}
