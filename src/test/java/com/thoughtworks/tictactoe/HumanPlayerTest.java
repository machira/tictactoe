package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.player.HumanPlayer;
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
public class HumanPlayerTest {

    BufferedReader bufferedReader;
    HumanPlayer player;
    PrintStream printStream;
    Board board;

    @Before
    public void setUp(){
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new HumanPlayer("Player1",bufferedReader,printStream,"X");
        board = mock(Board.class);
    }


    @Test
    public void shouldRejectInvalidInput() throws IOException{
        when(bufferedReader.readLine()).thenReturn("11").thenReturn("-1").thenReturn("1");
        int input = player.getInput();
        Assert.assertEquals(1,input);
    }

    @Test
    public void shouldWarnPlayerOfOccupiedCells() throws IOException{
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        when(board.isEmpty(1)).thenReturn(false);
        when(board.isEmpty(2)).thenReturn(true);
        player.makeMove(board);
        verify(printStream).println("Location Already Taken. Please try again");
    }

    @Test
    public void shouldMarkCorrectLocationOnBoard() throws IOException {
        // To keep it natural, we let human players reference cells as 1-9, and then -1 to reference the corresponding
        // array position. This tests that that works.

        when(bufferedReader.readLine()).thenReturn("5");
        when(board.isEmpty(anyInt())).thenReturn(true);
        player.makeMove(board);
        verify(board).move(4,"X");
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(board.isFull()).thenReturn(false);
        when(bufferedReader.readLine()).thenReturn("5");
        when(board.isEmpty(anyInt())).thenReturn(true);
        player.makeMove(board);
        verify(printStream).print(contains("Enter (1-9)"));
        verify(bufferedReader).readLine();
    }


//    @Test
//    public void should


}
