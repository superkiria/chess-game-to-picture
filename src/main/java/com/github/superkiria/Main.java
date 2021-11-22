package com.github.superkiria;

import com.github.superkiria.chess.svg.SvgBoard;
import com.github.superkiria.chess.svg.SvgFilesForPieces;
import com.github.superkiria.chess.svg.SvgPiece;

import java.io.File;
import java.util.EnumMap;

import static com.github.superkiria.svg.SvgUtils.documentToXmlString;
import static com.github.superkiria.svg.SvgUtils.saveDocumentToPng;

public class Main {

    public static void main(String[] args) throws Exception {
        SvgBoard board = new SvgBoard();
        SvgPiece piece = new SvgPiece(new File("src/main/resources/Chess_klt45.svg"));
        EnumMap<SvgFilesForPieces, SvgPiece> pieces = new EnumMap<>(SvgFilesForPieces.class);
        for (SvgFilesForPieces entry : SvgFilesForPieces.values()) {
            pieces.put(entry, new SvgPiece(new File("src/main/resources/" + entry.getFileName())));
        }
        board.importPiece(pieces.get(SvgFilesForPieces.BLACK_BISHOP).getDocumentNode(), 0, 0);
        board.importPiece(pieces.get(SvgFilesForPieces.WHITE_KING).getDocumentNode(), 2, 4);
        board.importPiece(pieces.get(SvgFilesForPieces.BLACK_PAWN).getDocumentNode(), 7, 3);
        System.out.println(documentToXmlString(board.getDocument()));
        saveDocumentToPng(board.getDocument());
    }

}
