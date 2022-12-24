package com.github.superkiria.chess.model;

import lombok.*;

@Data
@AllArgsConstructor
public class PieceOnBoard {

    private String piece;
    private int x;
    private int y;

}
