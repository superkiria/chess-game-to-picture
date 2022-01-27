package com.github.superkiria.chess.svg;

public enum SvgFileNames {

    K ("K", "svg/Chess_klt45.svg"),
    Q ("Q", "svg/Chess_qlt45.svg"),
    R ("R", "svg/Chess_rlt45.svg"),
    B ("B", "svg/Chess_blt45.svg"),
    N ("N", "svg/Chess_nlt45.svg"),
    P ("P", "svg/Chess_plt45.svg"),
    k ("k", "svg/Chess_kdt45.svg"),
    q ("q", "svg/Chess_qdt45.svg"),
    r ("r", "svg/Chess_rdt45.svg"),
    b ("b", "svg/Chess_bdt45.svg"),
    n ("n", "svg/Chess_ndt45.svg"),
    p ("p", "svg/Chess_pdt45.svg");

    private String pgnLetter;
    private String fileName;

    SvgFileNames(String pgnLetter, String fileName) {
        this.pgnLetter = pgnLetter;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
