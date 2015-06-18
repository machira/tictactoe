package com.thoughtworks.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by machira on Jun/18/15.
 */
public class BoardTest {
    Board board;
    int boardSize = 3;
    @Before
    public void setUp(){
        board = new Board(boardSize);
    }

    @Test
    public void boardShouldPrintAsASquare(){
        String boardString = board.toString();
        Assert.assertEquals("   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n", boardString);
    }

    @Test
    public void shouldUpdateBoardAppearanceOnMove(){
        board.move(0,1);
        Assert.assertEquals(" X |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n", board.toString());

        board.move(7,-1);
        Assert.assertEquals(" X |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   | 0 |   \n", board.toString());

        board.move(4,1);
        Assert.assertEquals(" X |   |   \n" +
                            "-----------\n" +
                            "   | X |   \n" +
                            "-----------\n" +
                            "   | X |   \n", board.toString());

    }

    @Test
    public void shouldRejectMoreMovesWhenFull(){
        Assert.assertTrue(board.move(0,1));
        for (int i = 1; i < (boardSize * boardSize); i++) {
            board.move(i,1);
        }
        Assert.assertFalse(board.move(boardSize,1));
        Assert.assertTrue(board.isFull());
    }


}
