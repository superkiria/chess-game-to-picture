package com.github.superkiria.chess.pgn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PgnToolsTest {

    @Test
    public void test() throws Exception {
        System.out.println(PgnTools.convertPgnToFen("[Event \"IBM Kasparov vs. Deep Blue Rematch\"]\n" +
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
                PgnTools.convertPgnToFen("[Event \"Chessboard Editor at Apronus.com\"]\n" +
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

    @Test
    public void test_002() throws Exception {
        assertEquals("8/6kp/7R/6Pp/r4P2/8/5K2/8 w - - 9 59",
                PgnTools.convertPgnToFen("[Event \"FIDE World Championship 2021\"]\n" +
                        "[Site \"Dubai, United Arab Emirates\"]\n" +
                        "[Date \"2021.11.27\"]\n" +
                        "[Round \"2\"]\n" +
                        "[White \"Carlsen, Magnus\"]\n" +
                        "[Black \"Nepomniachtchi, Ian\"]\n" +
                        "[Result \"1/2-1/2\"]\n" +
                        "[WhiteElo \"2855\"]\n" +
                        "[WhiteTitle \"GM\"]\n" +
                        "[BlackElo \"2782\"]\n" +
                        "[BlackTitle \"GM\"]\n" +
                        "[UTCDate \"2021.11.27\"]\n" +
                        "[UTCTime \"08:52:26\"]\n" +
                        "[Variant \"Standard\"]\n" +
                        "[ECO \"E06\"]\n" +
                        "[Opening \"Catalan Opening: Closed\"]\n" +
                        "[Annotator \"https://lichess.org/@/cFlour\"]\n" +
                        "\n" +
                        "1. d4 { [%eval 0.0] [%clk 1:59:57] } 1... Nf6 { [%eval 0.25] [%clk 1:59:53] } 2. c4 { [%eval 0.23] [%clk 1:59:50] } 2... e6 { [%eval 0.28] [%clk 1:59:47] } 3. Nf3 { [%eval 0.0] [%clk 1:59:42] } 3... d5 { [%eval 0.2] [%clk 1:59:41] } 4. g3 { [%eval 0.17] [%clk 1:59:35] } 4... Be7 { [%eval 0.22] [%clk 1:59:30] } 5. Bg2 { [%eval 0.15] [%clk 1:59:18] } 5... O-O { [%eval 0.31] [%clk 1:59:22] } 6. O-O { [%eval 0.22] [%clk 1:59:04] } 6... dxc4 { [%eval 0.31] [%clk 1:59:16] } 7. Qc2 { [%eval 0.13] [%clk 1:58:59] } 7... b5 { [%eval 0.28] [%clk 1:59:07] } 8. Ne5 { [%eval -0.08] [%clk 1:55:19] } 8... c6 { [%eval -0.21] [%clk 1:49:59] } 9. a4 { [%eval -0.22] [%clk 1:50:57] } 9... Nd5 { [%eval 0.0] [%clk 1:39:06] } 10. Nc3 { [%eval -0.84] [%clk 1:50:25] } 10... f6 { [%eval -0.83] [%clk 1:28:24] } 11. Nf3 { [%eval -0.69] [%clk 1:49:53] } 11... Qd7 { [%eval -0.58] [%clk 1:22:07] } 12. e4 { [%eval -0.13] [%clk 1:43:17] } 12... Nb4 { [%eval -0.3] [%clk 1:13:29] } 13. Qe2 { [%eval -0.43] [%clk 1:43:11] } 13... Nd3 { [%eval 0.16] [%clk 1:13:19] } 14. e5 { [%eval -0.4] [%clk 1:28:03] } 14... Bb7 { [%eval 0.04] [%clk 1:06:58] } 15. exf6 { [%eval 0.14] [%clk 1:17:57] } 15... Bxf6 { [%eval 0.63] [%clk 1:06:39] } 16. Ne4 { [%eval 0.25] [%clk 1:03:33] } 16... Na6 { [%eval 0.25] [%clk 1:05:30] } 17. Ne5 { [%eval -0.44] [%clk 1:01:31] } 17... Bxe5 { [%eval -0.45] [%clk 1:01:22] } 18. dxe5 { [%eval -0.18] [%clk 1:01:15] } 18... Nac5 { [%eval -0.77] [%clk 1:01:07] } 19. Nd6 { [%eval -0.78] [%clk 0:49:47] } 19... Nb3 { [%eval -0.55] [%clk 1:00:34] } 20. Rb1 { [%eval -1.28] [%clk 0:48:22] } 20... Nbxc1 { [%eval -1.26] [%clk 0:57:06] } 21. Rbxc1 { [%eval -1.22] [%clk 0:48:12] } 21... Nxc1 { [%eval -1.24] [%clk 0:57:00] } 22. Rxc1 { [%eval -1.5] [%clk 0:48:07] } 22... Rab8 { [%eval -1.33] [%clk 0:56:49] } 23. Rd1 { [%eval -1.31] [%clk 0:42:53] } 23... Ba8 { [%eval -1.07] [%clk 0:47:20] } 24. Be4 { [%eval -1.11] [%clk 0:33:57] } 24... c3 { [%eval -0.26] [%clk 0:36:24] } 25. Qc2 { [%eval -0.16] [%clk 0:25:25] } 25... g6 { [%eval -0.56] [%clk 0:34:22] } 26. bxc3 { [%eval -0.9] [%clk 0:24:23] } 26... bxa4 { [%eval -0.28] [%clk 0:32:43] } 27. Qxa4 { [%eval -0.1] [%clk 0:23:26] } 27... Rfd8 { [%eval 0.0] [%clk 0:26:54] } 28. Ra1 { [%eval 0.0] [%clk 0:19:21] } 28... c5 { [%eval -0.08] [%clk 0:25:43] } 29. Qc4 { [%eval -0.05] [%clk 0:18:10] } 29... Bxe4 { [%eval -0.07] [%clk 0:23:08] } 30. Nxe4 { [%eval 0.0] [%clk 0:17:22] } 30... Kh8 { [%eval 0.0] [%clk 0:22:53] } 31. Nd6 { [%eval 0.0] [%clk 0:15:26] } 31... Rb6 { [%eval 0.0] [%clk 0:20:36] } 32. Qxc5 { [%eval 0.0] [%clk 0:10:33] } 32... Rdb8 { [%eval 0.0] [%clk 0:20:01] } 33. Kg2 { [%eval 0.0] [%clk 0:10:17] } 33... a6 { [%eval 0.0] [%clk 0:16:41] } 34. Kh3 { [%eval 0.0] [%clk 0:10:08] } 34... Rc6 { [%eval 0.3] [%clk 0:14:54] } 35. Qd4 { [%eval 0.39] [%clk 0:09:02] } 35... Kg8 { [%eval 0.32] [%clk 0:13:40] } 36. c4 { [%eval 0.15] [%clk 0:06:40] } 36... Qc7 { [%eval 0.18] [%clk 0:12:29] } 37. Qg4 { [%eval 0.2] [%clk 0:03:57] } 37... Rxd6 { [%eval 0.15] [%clk 0:08:27] } 38. exd6 { [%eval 0.25] [%clk 0:03:55] } 38... Qxd6 { [%eval 0.14] [%clk 0:08:22] } 39. c5 { [%eval 0.2] [%clk 0:02:09] } 39... Qxc5 { [%eval 0.28] [%clk 0:04:25] } 40. Qxe6+ { [%eval 0.2] [%clk 1:02:06] } 40... Kg7 { [%eval 0.16] [%clk 1:04:13] } 41. Rxa6 { [%eval 0.14] [%clk 0:57:53] } 41... Rf8 { [%eval 0.14] [%clk 1:02:59] } 42. f4 { [%eval 0.15] [%clk 0:56:53] } 42... Qf5+ { [%eval 0.13] [%clk 1:02:33] } 43. Qxf5 { [%eval 0.1] [%clk 0:56:46] } 43... Rxf5 { [%eval 0.1] [%clk 1:02:30] } 44. Ra7+ { [%eval 0.15] [%clk 0:56:29] } 44... Kg8 { [%eval 0.12] [%clk 1:02:22] } 45. Kg4 { [%eval 0.13] [%clk 0:56:21] } 45... Rb5 { [%eval 0.12] [%clk 1:01:54] } 46. Re7 { [%eval 0.12] [%clk 0:55:52] } 46... Ra5 { [%eval 0.28] [%clk 1:01:01] } 47. Re5 { [%eval 0.27] [%clk 0:55:18] } 47... Ra7 { [%eval 0.09] [%clk 1:00:11] } 48. h4 { [%eval 0.16] [%clk 0:52:29] } 48... Kg7 { [%eval 0.19] [%clk 0:58:01] } 49. h5 { [%eval 0.13] [%clk 0:51:55] } 49... Kh6 { [%eval 0.14] [%clk 0:56:11] } 50. Kh4 { [%eval 0.2] [%clk 0:51:46] } 50... Ra1 { [%eval 0.1] [%clk 0:52:19] } 51. g4 { [%eval 0.0] [%clk 0:51:30] } 51... Rh1+ { [%eval 0.12] [%clk 0:51:48] } 52. Kg3 { [%eval 0.07] [%clk 0:51:27] } 52... gxh5 { [%eval 0.0] [%clk 0:51:22] } 53. Re6+ { [%eval 0.0] [%clk 0:50:57] } 53... Kg7 { [%eval 0.0] [%clk 0:51:19] } 54. g5 { [%eval 0.0] [%clk 0:50:48] } 54... Rg1+ { [%eval 0.04] [%clk 0:50:16] } 55. Kf2 { [%eval 0.0] [%clk 0:50:45] } 55... Ra1 { [%eval 0.0] [%clk 0:49:32] } 56. Rh6 { [%eval 0.0] [%clk 0:50:34] } 56... Ra4 { [%eval 0.0] [%clk 0:46:12] } 57. Kf3 { [%eval 0.0] [%clk 0:50:29] } 57... Ra3+ { [%eval 0.03] [%clk 0:46:02] } 58. Kf2 { [%eval 0.0] [%clk 0:50:23] } 58... Ra4 { [%eval 0.0] [%clk 0:45:59] } 1/2-1/2")
        );
    }

    @Test
    public void test_003() throws Exception {
        assertEquals("8/6kp/7R/6Pp/r4P2/8/5K2/8 w - - 9 59",
                PgnTools.convertPgnToFen("1. e4 { [%clk 1:35:10] } 1... c5 { [%clk 1:39:42] } 2. Nf3 { [%clk 1:35:25] } 2... e6 { [%clk 1:39:39] } 3. d4 { [%clk 1:35:06] } 3... cxd4 { [%clk 1:40:04] } 4. Nxd4 { [%clk 1:35:28] } 4... Nf6 { [%clk 1:40:31] } 5. Nc3 { [%clk 1:35:40] } 5... Nc6 { [%clk 1:40:56] } 6. Nxc6 { [%clk 1:29:20] } 6... bxc6 { [%clk 1:41:12] } 7. e5 { [%clk 1:29:46] } 7... Nd5 { [%clk 1:41:39] } 8. Ne4 { [%clk 1:30:12] } 8... Qc7 { [%clk 1:42:04] } 9. f4 { [%clk 1:30:35] } 9... Qb6 { [%clk 1:42:21] } 10. c4 { [%clk 1:30:30] } 10... Bb4+ { [%clk 1:40:21] } 11. Ke2 { [%clk 1:30:33] } 11... f5 { [%clk 1:40:38] } 12. Nf2 { [%clk 1:29:47] } 12... Ba6 { [%clk 1:39:41] } 13. Kf3 { [%clk 1:29:35] } 13... Ne7 { [%clk 1:40:03] } 14. Be3 { [%clk 1:28:15] } 14... Bc5 { [%clk 1:40:13] } 15. Bxc5 { [%clk 1:28:09] } 15... Qxc5 { [%clk 1:39:58] } 16. b3 { [%clk 1:18:57] } 16... g5 { [%clk 1:29:56] } 17. Qd6 { [%clk 1:12:09] } 17... Qa5 { [%clk 1:17:40] } *")
        );
    }
}
