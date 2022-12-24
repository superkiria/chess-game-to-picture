package com.github.superkiria.chess.tools;

public class ParsingTools {

    public static int letterToCoordinates(String letter) {
        switch (letter) {
            case "a": return 0;
            case "b": return 1;
            case "c": return 2;
            case "d": return 3;
            case "e": return 4;
            case "f": return 5;
            case "g": return 6;
            case "h": return 7;
            default: throw new RuntimeException("Unknown letter " + letter + " in coordinates.");
        }
    }

}
