package com.github.superkiria.chess;

import com.github.superkiria.chess.color.BoardColor;
import com.github.superkiria.chess.model.HighlightOnBoard;
import com.github.superkiria.chess.model.PieceOnBoard;
import com.github.superkiria.chess.svg.SvgChessBoard;
import com.github.superkiria.chess.svg.SvgFileNames;
import com.github.superkiria.chess.svg.SvgPiece;
import com.github.superkiria.chess.svg.SvgUtils;
import com.github.superkiria.chess.tools.PgnTools;
import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

import static com.github.superkiria.chess.tools.FenTools.fenToPiecesOnBoard;
import static com.github.superkiria.chess.tools.ParsingTools.letterToCoordinates;

public class ChessPic {

    private final EnumMap<SvgFileNames, SvgPiece> filesForPieces;
    private final List<PieceOnBoard> pieces;
    private final List<HighlightOnBoard> highlights;
    private final SvgChessBoard svgChessBoard;
    private final BoardColor color;

    protected ChessPic(EnumMap<SvgFileNames, SvgPiece> filesForPieces, BoardColor color) {
        this.filesForPieces = filesForPieces;
        this.color = color;
        this.pieces = new ArrayList<>();
        this.highlights = new ArrayList<>();
        this.svgChessBoard = new SvgChessBoard(Integer.toHexString(color.getBlack().getColor()),
                Integer.toHexString(BoardColor.getWhite(color.getWhite().getColor())));
    }

    public void setPositionFromPgn(String pgn) {
        setPositionFromPgn(pgn, false);
    }

    public void setPositionFromPgn(String pgn, boolean highlightLastMove) {
        pieces.addAll(fenToPiecesOnBoard(PgnTools.convertPgnToFen(pgn)));
        if (highlightLastMove) {
            String lastMove = PgnTools.getLastMove(pgn);
            if (lastMove != null) {
                highlightMove(lastMove);
            }
        }
    }

    public void setPositionFromFen(String fen) {
        pieces.addAll(fenToPiecesOnBoard(fen));
    }

    public void addPiece(String notation) {
        String piece = notation.substring(0, 1);
        int x = letterToCoordinates(notation.substring(1, 2));
        int y = 8 - Integer.parseInt(notation.substring(3, 4));
        pieces.add(new PieceOnBoard(piece, x, y));
    }

    public void highlightField(String notation) {
        int x = letterToCoordinates(notation.substring(0, 1));
        int y = 8 - Integer.parseInt(notation.substring(1, 2));
        highlights.add(new HighlightOnBoard(x, y, color.getHighlight()));
    }

    public void highlightMove(String notation) {
        highlightField(notation.substring(0, 2));
        highlightField(notation.substring(2, 4));
    }

    public void prepareTheBoard() {
        readPicturesForPieces();
        drawHighlights();
        drawPieces();
    }

    public SVGDocument getDocument() {
        return svgChessBoard.getDocument();
    }

    public String generateXmlDocument() {
        return SvgUtils.documentToXmlString(svgChessBoard.getDocument());
    }

    public ByteArrayOutputStream generatePng() {
        return SvgUtils.saveDocumentToPngByteBuffer(svgChessBoard.getDocument());
    }

    private void readPicturesForPieces() {
        for (SvgFileNames entry : SvgFileNames.values()) {
            filesForPieces.put(entry, new SvgPiece(Objects.requireNonNull(getClass().getClassLoader().getResource(entry.getFileName())).toString()));
        }
    }

    private void drawHighlights() {
        for (HighlightOnBoard highlight : highlights) {
            svgChessBoard.highlightSquare(highlight.getX(), highlight.getY());
        }
    }

    private void drawPieces() {
        for (PieceOnBoard piece : pieces) {
            svgChessBoard.importPiece(filesForPieces.get(SvgFileNames.valueOf(piece.getPiece())).getDocumentNode(), piece.getX(), piece.getY());
        }
    }

}
