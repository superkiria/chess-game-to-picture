package com.github.superkiria.chess;

import com.github.superkiria.chess.color.BoardColor;
import com.github.superkiria.chess.model.PieceOnBoard;
import com.github.superkiria.chess.svg.SvgBoard;
import com.github.superkiria.chess.svg.SvgFileNames;
import com.github.superkiria.chess.svg.SvgPiece;
import com.github.superkiria.chess.tools.FenTools;
import com.github.superkiria.chess.tools.PgnTools;
import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayOutputStream;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class ChessPic {

    private String pgn;
    private String lastMoveInNotation;
    private SvgBoard svgBoard;
    private List<PieceOnBoard> pieces;

    private final SVGDocument empty;
    private final EnumMap<SvgFileNames, SvgPiece> filesForPieces;
    private final BoardColor color;

    private String fen;
    private String lastMove;

    protected ChessPic(SVGDocument empty, EnumMap<SvgFileNames, SvgPiece> filesForPieces, BoardColor color) {
        this.empty = empty;
        this.filesForPieces = filesForPieces;
        this.color = color;
    }

    public void setPositionFromPgn(String pgn) {
        setPositionFromPgn(pgn, false);
    }

    public void setPositionFromPgn(String pgn, boolean highlightLastMove) {
        this.fen = PgnTools.convertPgnToFen(pgn);
        if (highlightLastMove) {
            this.lastMove = PgnTools.getLastMove(pgn);
        }
    }

    public void setPositionFromFen(String fen) {
        this.fen = fen;
    }

    public void setPositionFromFen(String fen, String moveToHighlight) {
        this.fen = fen;
        this.lastMove = moveToHighlight;
    }

    public void addPiece(String piece) {

    }

    public void highlightField(String move) {

    }

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

    public void placePiece(PieceOnBoard piece) {
        pieces.add(piece);
    }

    private void initSvgBoard(int aCase) {
        svgBoard = new SvgBoard(Integer.toHexString(BoardColor.getBlack(aCase)),
                Integer.toHexString(BoardColor.getWhite(aCase)));
    }

    private void readFilesForPieces() {
        for (SvgFileNames entry : SvgFileNames.values()) {
            filesForPieces.put(entry, new SvgPiece(Objects.requireNonNull(getClass().getClassLoader().getResource(entry.getFileName())).toString()));
        }
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
            svgBoard.importPiece(filesForPieces.get(SvgFileNames.valueOf(piece.getPiece())).getDocumentNode(), piece.getX(), piece.getY());
        }
    }

    public void init(Integer color) {
        initPiecesFromFen();
        initSvgBoard(color);
        readFilesForPieces();
        highlightLastMove();
        placePiecesOnBoard();
    }

    public void highlightLastMove() {
        if (lastMoveInNotation != null && lastMoveInNotation.length() == 4) {
            svgBoard.highlightSquare(Integer.parseInt(letterToCoordinates(lastMoveInNotation.substring(0, 1))),
                    8 - Integer.parseInt(lastMoveInNotation.substring(1, 2)));
            svgBoard.highlightSquare(Integer.parseInt(letterToCoordinates(lastMoveInNotation.substring(2, 3))),
                    8 - Integer.parseInt(lastMoveInNotation.substring(3, 4)));
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

    public void setPgn(String pgn) {
        this.pgn = pgn;
        this.setFen(PgnTools.convertPgnToFen(pgn));
        this.setLastMoveInNotation(PgnTools.getLastMove(pgn));
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public void setLastMoveInNotation(String notation) {
        this.lastMoveInNotation = notation;
    }

}
