package com.github.superkiria.chess;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ChessPicFactoryTest {

    @Test
    public void test() {
        ChessPicFactory cpf = new ChessPicFactory();
        ChessPic cp = cpf.newPicture();
        cp.setPositionFromFen("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1");
        cp.prepareTheBoard();
        System.out.println(cp.generateXmlDocument());
    }

}
