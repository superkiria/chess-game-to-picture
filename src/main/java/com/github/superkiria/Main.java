package com.github.superkiria;

import com.github.superkiria.chess.svg.SvgBoardBuilder;

import static com.github.superkiria.chess.svg.SvgUtils.documentToXmlString;
import static com.github.superkiria.chess.svg.SvgUtils.saveDocumentToPng;

public class Main {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 12; i++) {
            SvgBoardBuilder builder = new SvgBoardBuilder();
            builder.setLastMoveInNotation("b8d7");
            builder.setFen("r1bqkb1r/pp1npppp/3p1n2/8/3P4/5N1P/PPP2PP1/RNBQKB1R w KQkq - 1 7");
            builder.init(i);
            System.out.println(documentToXmlString(builder.getDocument()));
            saveDocumentToPng(builder.getDocument(), "out_" + i + ".png");
        }
    }

}
