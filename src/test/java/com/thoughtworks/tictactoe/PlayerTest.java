package com.thoughtworks.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by machira on Jun/18/15.
 */
public class PlayerTest {

    BufferedReader bufferedReader;
    Player player;
    PrintStream printStream;
    Board board;

    @Before
    public void setUp(){
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new Player("Player1",bufferedReader,printStream,1);
        board = mock(Board.class);
    }


    @Test
    public void shouldRejectInvalidInput() throws IOException{
        when(bufferedReader.readLine()).thenReturn("11").thenReturn("-1").thenReturn("1");
        int input = player.getInput(9);
        Assert.assertEquals(1,input);
    }

    @Test
    public void shouldWarnPlayerOfOccupiedCells() throws IOException{
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        when(board.getSize()).thenReturn(3);
        when(board.isEmpty(1)).thenReturn(false);
        when(board.isEmpty(2)).thenReturn(true);
        player.makeMove(board);
        verify(printStream).println("Location Already Taken. Please try again");
    }

    @Test
    public void shouldMarkCorrectLocationOnBoard(){
        player.makeMoveOnBoard(board, 2);
        verify(board).move(1,1);
    }
}
