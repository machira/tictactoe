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
        String opponentMark = "X";
        computerPlayer = new ComputerPlayer("O", opponentMark);
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

        int blockingMove = computerPlayer.blockOpposingPlayer(board);
        Assert.assertThat(blockingMove, is(1));

    }

    @Test
    public void shouldIdentifyBlockingMoves(){
        Board boardWithNoBlockingMove = new Board(Arrays.asList("", "", "",
                                                                "", "", "",
                                                                "", "", ""));
        int noBlockingMove = computerPlayer.blockOpposingPlayer(boardWithNoBlockingMove);
        Assert.assertThat(noBlockingMove, is(-1));

        Board boardWithBlockingMoves = new Board(Arrays.asList(  "X","","X",
                                                                "", "O", "",
                                                                "", "", ""));
        int blockingMove = computerPlayer.blockOpposingPlayer(boardWithBlockingMoves);
        Assert.assertThat(blockingMove, is(1));


    }

    @Test
    public void shouldPrioritizeWinningOverBlocking(){

//        this mocks a board that looks like this:
//        "X","","X",
//        "O", "O", "",
//        "", "", ""

        Board boardWinningOrBlocking = mock(Board.class);
        // We describe the two winning conditions of the board.
        when(boardWinningOrBlocking.isWinningMove(anyInt(),anyString())).thenReturn(false);
        when(boardWinningOrBlocking.isWinningMove(1,"X")).thenReturn(true);
        when(boardWinningOrBlocking.isWinningMove(5,"O")).thenReturn(true);

        // we describe the cells occupied on the board.
        when(boardWinningOrBlocking.isEmpty(anyInt())).thenReturn(true);
        when(boardWinningOrBlocking.isEmpty(0)).thenReturn(false);
        when(boardWinningOrBlocking.isEmpty(2)).thenReturn(false);
        when(boardWinningOrBlocking.isEmpty(3)).thenReturn(false);
        when(boardWinningOrBlocking.isEmpty(4)).thenReturn(false);

        computerPlayer.makeMove(boardWinningOrBlocking);
        verify(boardWinningOrBlocking).move(5,"O");
    }


}