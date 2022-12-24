package com.github.superkiria.chess.tools;

import com.github.superkiria.chess.model.PieceOnBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FenTools {

    private static final Set<String> NUMBERS = Set.of("1", "2", "3", "4", "5", "6", "7", "8");
    private static final Set<String> PIECES = Set.of("K", "Q", "R", "B", "N", "P");

    public static List<PieceOnBoard> fenToPiecesOnBoard(String fen) {
        int x = 0;
        int y = 0;
        int position = 0;
        List<PieceOnBoard> list = new ArrayList<>();
        while (fen.charAt(position) != ' ') {
            String c = fen.substring(position, position + 1);
            if (NUMBERS.contains(c)) {
                x += Integer.parseInt(c);
            }
            if (c.equals("/")) {
                x = 0;
                y++;
            }
            if (PIECES.contains(c.toUpperCase())) {
                list.add(new PieceOnBoard(c, x, y));
                x++;
            }
            position++;
        }
        return list;
    }

}
