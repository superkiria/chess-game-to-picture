package com.github.superkiria.chess;

import com.github.superkiria.chess.color.BoardColor;
import com.github.superkiria.chess.model.HighlightedField;
import com.github.superkiria.chess.model.PieceOnBoard;
import com.github.superkiria.chess.svg.SvgBoard;
import com.github.superkiria.chess.svg.SvgFileNames;
import com.github.superkiria.chess.svg.SvgPiece;
import com.github.superkiria.chess.tools.FenTools;
import com.github.superkiria.chess.tools.PgnTools;
import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class ChessPic {

    private static final BoardColor DEFAULT_COLOR = BoardColor.BLUE_JEANS;

    private final SVGDocument empty;
    private final EnumMap<SvgFileNames, SvgPiece> filesForPieces;

    private String lastMove;
    private SvgBoard svgBoard;
    private List<PieceOnBoard> pieces;
    private List<HighlightedField> highlightedFields;

    protected ChessPic(SVGDocument empty, EnumMap<SvgFileNames, SvgPiece> filesForPieces) {
        this.empty = empty;
        this.filesForPieces = filesForPieces;
    }

    /* SETTING POSITIONS */
    public void startWithBlank(String pgn) {
        pieces = new ArrayList<>();
    }

    public void setPositionFromPgn(String pgn) {
        setPositionFromPgn(pgn, false);
    }

    public void setPositionFromPgn(String pgn, boolean highlightLastMove) {
        setPositionFromFen(PgnTools.convertPgnToFen(pgn));
        if (highlightLastMove) {
            this.lastMove = PgnTools.getLastMove(pgn);
        }
    }

    public void setPositionFromFen(String fen) {
        pieces = FenTools.fenToPiecesOnBoard(fen);
    }

    /* ADDING A PIECE */
    public void addPiece(String notation) {

    }

    public void addPiece(String x, int y, String piece) {

    }

    public void addPiece(int x, int y, String piece) {
        placePiece(new PieceOnBoard(x, y, piece));
    }

    public void placePiece(PieceOnBoard piece) {
        pieces.add(piece);
    }

    /* HIGHLIGHTS */
    public void setMoveToHighLight(String fen, String moveToHighlight) {
        this.lastMove = moveToHighlight;
    }

    public void highlightField(String move) {

    }

    public void setLastMoveInNotation(String lastMoveInNotation) {
        this.lastMove = lastMoveInNotation;
        highlightLastMove();
    }

    /* RESULST */

    public SVGDocument getDocument() {
        this.setLastMoveInNotation(lastMove);
        this.init(0);
        return svgBoard.getDocument();
    }

    public String getXmlDocument() {
        return "";
    }

    public ByteArrayOutputStream generatePng() {
        return null;
    }

    public void init(Integer color) {
        initSvgBoard(color);
        readFilesForPieces();
        highlightLastMove();
        placePiecesOnBoard();
    }

    /* PRIVATE */

    private void initSvgBoard(int aCase) {
        svgBoard = new SvgBoard(Integer.toHexString(BoardColor.getBlack(aCase)),
                Integer.toHexString(BoardColor.getWhite(aCase)));
    }

    private void readFilesForPieces() {
        for (SvgFileNames entry : SvgFileNames.values()) {
            filesForPieces.put(entry, new SvgPiece(Objects.requireNonNull(getClass().getClassLoader().getResource(entry.getFileName())).toString()));
        }
    }

    private void placePiecesOnBoard() {
        if (pieces == null) {
            throw new IllegalStateException("No pieces to put on board.");
        }
        for (PieceOnBoard piece : pieces) {
            svgBoard.importPiece(filesForPieces.get(SvgFileNames.valueOf(piece.getPiece())).getDocumentNode(), piece.getX(), piece.getY());
        }
    }

    private void highlightLastMove() {
        if (lastMove != null && lastMove.length() == 4) {
            svgBoard.highlightSquare(Integer.parseInt(letterToCoordinates(lastMove.substring(0, 1))),
                    8 - Integer.parseInt(lastMove.substring(1, 2)));
            svgBoard.highlightSquare(Integer.parseInt(letterToCoordinates(lastMove.substring(2, 3))),
                    8 - Integer.parseInt(lastMove.substring(3, 4)));
        }
    }

    private String letterToCoordinates(String letter) {
        switch (letter) {
            case "a": return "0";
            case "b": return "1";
            case "c": return "2";
            case "d": return "3";
            case "e": return "4";
            case "f": return "5";
            case "g": return "6";
            case "h": return "7";
            default: return null;
        }
    }

}
