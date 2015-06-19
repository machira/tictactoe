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

    @Before
    public void setUp(){
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new Player(bufferedReader,printStream,1);
    }


    @Test
    public void shouldRejectInvalidInput(){
        try{
            when(bufferedReader.readLine()).thenReturn("11").thenReturn("-1").thenReturn("1");
            int input = player.getInput(9);
            Assert.assertEquals(1,input);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    public void shouldWarnPlayerOfOccupiedCells(){
        try {
            when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
            Board board = mock(Board.class);
            when(board.getSize()).thenReturn(3);
            when(board.isEmpty(1)).thenReturn(false);
            when(board.isEmpty(2)).thenReturn(true);
            player.makeMove(board);
            verify(printStream).println("Location Already Taken. Please try again");
        }catch (IOException ioe){
            ;
        }

//        when(player.getInput(anyInt())).thenReturn(1);
    }
}
