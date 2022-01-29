package com.github.superkiria.chess.color;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Color {
    private int red;
    private int green;
    private int blue;
    private float alpha;

    public int getColor() {
        return red * 256 * 256 + green * 256 + blue;
    }

}
