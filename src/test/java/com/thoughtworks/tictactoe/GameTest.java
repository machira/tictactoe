package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.player.HumanPlayer;
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
    HumanPlayer player1, player2;
    PrintStream printStream;


    @Before
    public void setUp(){
        player1 = mock(HumanPlayer.class);
        player2 = mock(HumanPlayer.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);

        game = new Game(board,new HumanPlayer[]{player1,player2},printStream);

    }

    @Test
    public void shouldAlternatePlayersOnStart(){
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.start();
        verify(player1).makeMove(board);
        verify(player2).makeMove(board);

        Board board1 = mock(Board.class);
        // With this set up, we expect player1 to get two turns, and player2 to get 1
        when(board1.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);

        Game game1 = new Game(board1,new HumanPlayer[]{player1,player2},printStream);
        game1.start();
        verify(player1, times(2)).makeMove(board1);
        verify(player2).makeMove(board1);
    }

    @Test
    public void shouldInformPlayerWhenGameIsWon(){
        when(board.isWon()).thenReturn(false).thenReturn(true);
        game.start();
        verify(printStream).println(contains("has won"));
    }
}