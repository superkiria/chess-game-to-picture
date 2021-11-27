package com.github.superkiria.chess.svg;

import com.github.superkiria.chess.fen.FenTools;
import com.github.superkiria.chess.internal.PieceOnBoard;
import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;

public class SvgBoardBuilder {

    private String pgn;
    private String fen;
    private SvgBoard svgBoard;
    private List<PieceOnBoard> pieces;
    private EnumMap<SvgFilesForPieces, SvgPiece> filesForPieces = new EnumMap<>(SvgFilesForPieces.class);
    private boolean isFilesForPiecesInitialized = false;

    public void placePiece(PieceOnBoard piece) {
        pieces.add(piece);
    }

    private void initSvgBoard() throws IOException {
        svgBoard = new SvgBoard();
    }

    private void readFilesForPieces() throws IOException {
        for (SvgFilesForPieces entry : SvgFilesForPieces.values()) {
            filesForPieces.put(entry, new SvgPiece(new File("src/main/resources/" + entry.getFileName())));
        }
        isFilesForPiecesInitialized = true;
    }

    private void initPiecesFromFen() {
        if (fen == null) {
            throw new IllegalStateException("You have set no fen.");
        }
        if (pieces != null) {
            throw new IllegalStateException("You already have some pieces, so fen cannot be applied.");
        }
        pieces = FenTools.fenToPiecesOnBoard(fen);
    }

    private void placePiecesOnBoard() {
        if (pieces == null) {
            throw new IllegalStateException("No pieces to put on board.");
        }
        for (PieceOnBoard piece : pieces) {
            svgBoard.importPiece(filesForPieces.get(SvgFilesForPieces.valueOf(piece.getPiece())).getDocumentNode(), piece.getX(), piece.getY());
        }
    }

    public void init() throws IOException {
        initPiecesFromFen();
        initSvgBoard();
        readFilesForPieces();
        placePiecesOnBoard();
    }

    public void setPgn(String pgn) {
        this.pgn = pgn;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public SVGDocument getDocument() {
        return svgBoard.getDocument();
    }

}
