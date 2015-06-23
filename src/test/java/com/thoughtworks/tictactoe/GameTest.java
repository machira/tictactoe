package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by machira on Jun/21/15.
 */
public class GameTest {
    Game game;
    Board board;
    Player player1, player2;
    PrintStream printStream;


    @Before
    public void setUp(){
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);

        game = new Game(board,new Player[]{player1,player2},printStream);

    }

    @Test
    public void shouldAlternatePlayersOnStart(){
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.start();
        verify(player1).makeMove(board);
        verify(player2).makeMove(board);
    }

    @Test
    public void shouldQuitWhenGameIsWon(){
        when(board.isWon()).thenReturn(false).thenReturn(true);
        game.start();
        verify(printStream).println(contains("has won"));
    }
}