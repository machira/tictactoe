package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by machira on Jun/23/15.
 */
public class WinningMoveStrategyTest {

    private WinningMoveStrategy winningMoveStrategy;

    @Before
    public void setUp(){
        winningMoveStrategy = new WinningMoveStrategy("O");
    }

    @Test
    public void shouldCorrectlyDetectWinningMovesWhenAvailable(){
        Board oneHorizontalMoveToWin=new Board(Arrays.asList(   "O", "O", "",
                                                                "", "", "",
                                                                "", "", ""));

        int move = winningMoveStrategy.move(oneHorizontalMoveToWin);
        Assert.assertThat(move, is(2));


        Board noSingleMoveWin = new Board(Arrays.asList("O","X","",
                                                        "", "", "",
                                                        "", "", ""));

        int noMoveFound = winningMoveStrategy.move(noSingleMoveWin);
        Assert.assertThat(noMoveFound, is(-1));

        Board singleVerticalMoveToWin = new Board(Arrays.asList("O","X","",
                                                                "O", "", "",
                                                                "", "", ""));
        int winningVerticalMove = winningMoveStrategy.move(singleVerticalMoveToWin);
        Assert.assertThat(winningVerticalMove,is(6));


        Board singleDiagonalMoveToWin = new Board(Arrays.asList("O","X","",
                                                                "", "O", "",
                                                                "", "", ""));
        int winningDiagonalMove = winningMoveStrategy.move(singleDiagonalMoveToWin);
        Assert.assertThat(winningDiagonalMove,is(8));
    }
}