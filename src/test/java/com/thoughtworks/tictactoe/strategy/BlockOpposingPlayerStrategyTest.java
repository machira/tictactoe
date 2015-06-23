package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by machira on Jun/23/15.
 */
public class BlockOpposingPlayerStrategyTest {
    private String opponentMark;
    private BlockOpposingPlayerStrategy strategy;


    @Before
    public void setUp(){
        opponentMark = "X";
        strategy = new BlockOpposingPlayerStrategy(opponentMark);
    }

    @Test
    public void shouldBlockOpponentFromWinningMove(){
        Board board = new Board(Arrays.asList(  "X", "", "X",
                                                "", "", "",
                                                "", "", ""));

        int blockingMove = strategy.move(board);
        Assert.assertThat(blockingMove, is(1));

    }

    @Test
    public void shouldIdentifyBlockingMoves(){
        Board boardWithNoBlockingMove = new Board(Arrays.asList("", "", "",
                "", "", "",
                "", "", ""));
        int noBlockingMove = strategy.move(boardWithNoBlockingMove);
        Assert.assertThat(noBlockingMove, is(-1));

        Board boardWithBlockingMoves = new Board(Arrays.asList(  "X","","X",
                "", "O", "",
                "", "", ""));
        int blockingMove = strategy.move(boardWithBlockingMoves);
        Assert.assertThat(blockingMove, is(1));


    }

}