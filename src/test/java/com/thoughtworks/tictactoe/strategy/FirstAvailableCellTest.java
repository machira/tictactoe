package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by machira on Jun/23/15.
 */
public class FirstAvailableCellTest {

    private Board board;
    private FirstAvailableCellStrategy firstAvailableCellStrategy;
    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        firstAvailableCellStrategy = new FirstAvailableCellStrategy();
    }

    @Test
    public void shouldMakeMovesBasedOnFirstAvailableSpace(){
        when(board.isEmpty(0)).thenReturn(true);
        int move = firstAvailableCellStrategy.move(board);
        Assert.assertThat(move, is(0));

        when(board.isEmpty(anyInt())).thenReturn(false).thenReturn(false).thenReturn(true);
        Assert.assertThat(firstAvailableCellStrategy.move(board), is(2));
    }

}