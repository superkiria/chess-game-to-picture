package com.github.superkiria;

import com.github.superkiria.chess.svg.SvgBoardBuilder;

import static com.github.superkiria.chess.svg.SvgUtils.documentToXmlString;
import static com.github.superkiria.chess.svg.SvgUtils.saveDocumentToPng;

public class Main {

    public static void main(String[] args) throws Exception {

        SvgBoardBuilder builder = new SvgBoardBuilder();
        builder.setLastMoveInNotation("b8d7");
        builder.setFen("r1bqkb1r/pp1npppp/3p1n2/8/3P4/5N1P/PPP2PP1/RNBQKB1R w KQkq - 1 7");
        builder.init(7);
        System.out.println(documentToXmlString(builder.getDocument()));
        saveDocumentToPng(builder.getDocument());
    }

}
