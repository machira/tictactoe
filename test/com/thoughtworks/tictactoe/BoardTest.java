package com.thoughtworks.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by machira on Jun/18/15.
 */
public class BoardTest {
    Board board;
    @Before
    public void setUp(){
        board = new Board(3);
    }

    @Test
    public void boardShouldPrintAsASquare(){
        String boardString = board.toString();
        Assert.assertEquals("    |    |    \n" +
                            "--------------\n" +
                            "    |    |    \n" +
                            "--------------\n" +
                            "    |    |    \n",boardString);
    }
}
