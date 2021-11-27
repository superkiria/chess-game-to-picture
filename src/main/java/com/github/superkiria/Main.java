package com.github.superkiria;

import com.github.superkiria.chess.svg.SvgBoardBuilder;

import static com.github.superkiria.chess.svg.SvgUtils.saveDocumentToPng;

public class Main {

    public static void main(String[] args) throws Exception {

        SvgBoardBuilder builder = new SvgBoardBuilder();
        builder.setFen("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2");
        builder.init();
        saveDocumentToPng(builder.getDocument());
    }

}
