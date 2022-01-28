package com.github.superkiria.chess.svg;

public enum SvgFileNames {

    K ("K", "svg/klt45.svg"),
    Q ("Q", "svg/qlt45.svg"),
    R ("R", "svg/rlt45.svg"),
    B ("B", "svg/blt45.svg"),
    N ("N", "svg/nlt45.svg"),
    P ("P", "svg/plt45.svg"),
    k ("k", "svg/kdt45.svg"),
    q ("q", "svg/qdt45.svg"),
    r ("r", "svg/rdt45.svg"),
    b ("b", "svg/bdt45.svg"),
    n ("n", "svg/ndt45.svg"),
    p ("p", "svg/pdt45.svg");

    private final String pgnLetter;
    private final String fileName;

    SvgFileNames(String pgnLetter, String fileName) {
        this.pgnLetter = pgnLetter;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
