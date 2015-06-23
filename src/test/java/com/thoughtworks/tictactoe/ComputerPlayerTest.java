package com.thoughtworks.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

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
        int move = computerPlayer.selectFirstAvailableCell(board);
        Assert.assertThat(move, is(0));

        when(board.isEmpty(anyInt())).thenReturn(false).thenReturn(false).thenReturn(true);
        Assert.assertThat(computerPlayer.selectFirstAvailableCell(board), is(2));
    }

    @Test
    public void shouldCorrectlyDetectWinningMovesWhenAvailable(){
        Board oneHorizontalMoveToWin=new Board(Arrays.asList("O","O","",
                                                             "", "", "",
                                                             "", "", ""));
        int move = computerPlayer.selectWinningMove(oneHorizontalMoveToWin);
        Assert.assertThat(move,is(2));


        Board noSingleMoveWin = new Board(Arrays.asList("O","X","",
                                                        "", "", "",
                                                        "", "", ""));
        int noMoveFound = computerPlayer.selectWinningMove(noSingleMoveWin);
        Assert.assertThat(noMoveFound, is(-1));

        Board singleVerticalMoveToWin = new Board(Arrays.asList("O","X","",
                                                                "O", "", "",
                                                                "", "", ""));

        int winningVerticalMove = computerPlayer.selectWinningMove(singleVerticalMoveToWin);
        Assert.assertThat(winningVerticalMove,is(6));

        Board singleDiagonalMoveToWin = new Board(Arrays.asList("O","X","",
                                                                "", "O", "",
                                                                "", "", ""));
        int winningDiagonalMove = computerPlayer.selectWinningMove(singleDiagonalMoveToWin);
        Assert.assertThat(winningDiagonalMove,is(8));
    }

    @Test
    public void shouldBlockOpponentFromWinningMove(){
        Board board = new Board(Arrays.asList(  "X","","X",
                                                "", "O", "",
                                                "", "", ""));

    }

    @Test
    public void shouldPrioritizeWinningOverBlocking(){
        Board boardWinningOrBlocking = new Board(Arrays.asList( "X","","X",
                                                                "", "O", "",
                                                                "", "", ""));

    }
}