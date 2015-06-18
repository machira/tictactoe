package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

/**
 * Created by machira on Jun/18/15.
 */
public class MainTest {
    Main main;
    PrintStream printStream;
    BufferedReader bufferedReader;
    Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        main = new Main(board,printStream,bufferedReader);
    }

    @Test
    public void shouldChangeBoardBasedOnInput(){
        try{
            when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");
            main.start();
            verify(board).move(anyInt(),anyInt());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    public void shouldRejectInvalidInput(){
        try{
            when(bufferedReader.readLine()).thenReturn("11").thenReturn("-1").thenReturn("0");
            main.start();
            verify(printStream, times(2)).println("Invalid choice: 0-9");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    public void shouldWarnPlayerAboutOccupiedLocations(){
        try{
            when(bufferedReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("0");
            when(board.move(anyInt(),anyInt())).thenReturn(true).thenReturn(false);
            main.start();
            verify(printStream).println("Location Already Taken");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }





}
