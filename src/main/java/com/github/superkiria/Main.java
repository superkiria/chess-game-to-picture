package com.github.superkiria;

import com.github.superkiria.chess.svg.SvgBoard;
import com.github.superkiria.chess.svg.SvgPiece;

import java.io.File;

import static com.github.superkiria.svg.SvgUtils.documentToXmlString;
import static com.github.superkiria.svg.SvgUtils.saveDocumentToPng;

public class Main {

    public static void main(String[] args) throws Exception {
        SvgBoard board = new SvgBoard();
        SvgPiece piece = new SvgPiece(new File("src/main/resources/kdt45.svg"));
        board.importPiece(piece.getDocumentNode(), 0, 0);
        board.importPiece(piece.getDocumentNode(), 2, 4);
        board.importPiece(piece.getDocumentNode(), 7, 3);
        System.out.println(documentToXmlString(board.getDocument()));
        saveDocumentToPng(board.getDocument());
    }

}
