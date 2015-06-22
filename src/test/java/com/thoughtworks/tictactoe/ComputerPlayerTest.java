package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayerTest {
    ComputerPlayer computerPlayer;
    @Before
    public void setUp() throws Exception {
        computerPlayer = new ComputerPlayer("O");
    }

    @Test
    public void shouldMakeMovesBasedOnFirstAvailableSpace(){
        Board board = mock(Board.class);
        when(board.isEmpty(0)).thenReturn(true);
        computerPlayer.makeMove(board);
        verify(board).move(0,"O");

    }
}