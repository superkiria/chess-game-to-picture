package com.github.superkiria.chess.pgn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PgnToFenConverterTest {

    @Test
    public void test() throws Exception {
        System.out.println(PgnToFenConverter.convertPgnToFen("[Event \"IBM Kasparov vs. Deep Blue Rematch\"]\n" +
                "[Site \"New York, NY USA\"]\n" +
                "[Date \"1997.05.11\"]\n" +
                "[Round \"6\"]\n" +
                "[White \"Deep Blue\"]\n" +
                "[Black \"Kasparov, Garry\"]\n" +
                "[Opening \"Caro-Kann: 4...Nd7\"]\n" +
                "[ECO \"B17\"]\n" +
                "[Result \"1-0\"]\n" +
                " \n" +
                "1.e4 c6 2.d4 d5 3.Nc3 dxe4 4.Nxe4 Nd7 5.Ng5 Ngf6 6.Bd3 e6 7.N1f3 h6\n" +
                "8.Nxe6 Qe7 9.O-O fxe6 10.Bg6+ Kd8 {Каспаров встряхнул головой} \n" +
                "11.Bf4 b5 12.a4 Bb7 13.Re1 Nd5 14.Bg3 Kc8 15.axb5 cxb5 16.Qd3 Bc6 \n" +
                "17.Bf5 exf5 18.Rxe7 Bxe7 19.c4 1-0"));
    }

    @Test
    public void test_001() throws Exception {
        assertEquals("6k1/ppp3b1/4P2p/2P2Pp1/2nrp3/2N4P/PPK2P2/5BR1 w - - 1 24",
                PgnToFenConverter.convertPgnToFen("[Event \"Chessboard Editor at Apronus.com\"]\n" +
                "[Site \"site\"]\n" +
                "[Date \"2021.11.20\"]\n" +
                "[Round \"-\"]\n" +
                "[White \"?\"]\n" +
                "[Black \"?\"]\n" +
                "[Result \"*\"]\n" +
                "\n" +
                "1. e4 d5 2. exd5 Nf6 3. d4 Nxd5 4. c4 Nb6 5. Nc3 g6 6. Be3 Bg7 7. h3 O-O 8. Qd2 \n" +
                "Nc6 9. Nf3 e5 10. d5 Ne7 11. g4 f5 12. O-O-O e4 13. Ng5 h6 14. Ne6 Bxe6 15. dxe6 \n" +
                "Qxd2+ 16. Rxd2 Rad8 17. Bc5 Rxd2 18. Kxd2 Rd8+ 19. Kc2 Nc6 20. gxf5 Nd4+ 21. \n" +
                "Bxd4 Rxd4 22. Rg1 g5 23. c5 Nc4 *\n" +
                "\n")
        );
    }

}
