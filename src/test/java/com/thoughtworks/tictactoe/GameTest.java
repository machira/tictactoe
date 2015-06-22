package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
//        when(player1.makeMove(board)).thenReturn(board);
//        when(player2.makeMove(board)).thenReturn(board);
        game.start();
        verify(player1).makeMove(board);
        verify(player2).makeMove(board);
    }
}