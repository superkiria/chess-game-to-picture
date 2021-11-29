package com.github.superkiria.chess.pgn;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.pgn.GameLoader;

import java.util.Arrays;

public class PgnTools {

    public static String convertPgnToFen(String pgn) {
        Game game = GameLoader.loadNextGame(Arrays.asList(pgn.split("\n")).listIterator());
        Board board = new Board();
        for (Move move:
             game.getHalfMoves()) {
            board.doMove(move);
        }
        return board.getFen();
    }

    public static String getLastMove(String pgn) {
        Game game = GameLoader.loadNextGame(Arrays.asList(pgn.split("\n")).listIterator());
        return String.valueOf(game.getHalfMoves().getLast());
    }

}
