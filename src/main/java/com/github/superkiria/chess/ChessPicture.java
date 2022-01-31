package com.github.superkiria.chess;

import com.github.superkiria.chess.color.BoardColor;
import com.github.superkiria.chess.svg.SvgFileNames;
import com.github.superkiria.chess.svg.SvgPiece;
import com.github.superkiria.chess.tools.PgnTools;
import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayOutputStream;
import java.util.EnumMap;

public class ChessPicture {

    private final SVGDocument empty;
    private final EnumMap<SvgFileNames, SvgPiece> filesForPieces;
    private final BoardColor color;

    private String fen;
    private String lastMove;

    protected ChessPicture(SVGDocument empty, EnumMap<SvgFileNames, SvgPiece> filesForPieces, BoardColor color) {
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
        return null;
    }

    public String getXmlDocument() {
        return null;
    }

    public ByteArrayOutputStream generatePng() {
        return null;
    }

}
