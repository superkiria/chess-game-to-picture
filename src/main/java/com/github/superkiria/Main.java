package com.github.superkiria;

import com.github.superkiria.chess.svg.SvgBoardBuilder;

import static com.github.superkiria.chess.svg.SvgUtils.documentToXmlString;
import static com.github.superkiria.chess.svg.SvgUtils.saveDocumentToPng;

public class Main {

    public static void main(String[] args) throws Exception {

        SvgBoardBuilder builder = new SvgBoardBuilder();
        builder.setLastMoveInNotation("a1e4");
        builder.setFen("8/6kp/7R/6Pp/r4P2/8/5K2/8 w - - 9 59");
        builder.init();
        System.out.println(documentToXmlString(builder.getDocument()));
        saveDocumentToPng(builder.getDocument());
    }

}
