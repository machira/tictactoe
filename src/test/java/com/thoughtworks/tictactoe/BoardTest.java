package com.thoughtworks.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by machira on Jun/18/15.
 */
public class BoardTest {
    Board board;
    int boardSize = 3;
    @Before
    public void setUp(){
        board = new Board(Arrays.asList("","","",
                                        "","","",
                                        "","",""));
    }

    @Test
    public void boardShouldPrintAsASquare(){
        String boardString = board.toString();
        Assert.assertEquals("  |  |  \n" +
                            "-----------\n" +
                            "  |  |  \n" +
                            "-----------\n" +
                            "  |  |  \n", boardString);
    }

    @Test
    public void shouldUpdateBoardAppearanceOnMove(){
        board.move(0,"X");
        Assert.assertEquals(" X |  |  \n" +
                            "-----------\n" +
                            "  |  |  \n" +
                            "-----------\n" +
                            "  |  |  \n", board.toString());

        board.move(7,"O");
        Assert.assertEquals(" X |  |  \n" +
                            "-----------\n" +
                            "  |  |  \n" +
                            "-----------\n" +
                            "  | O |  \n", board.toString());

        board.move(4,"X");
        Assert.assertEquals(" X |  |  \n" +
                            "-----------\n" +
                            "  | X |  \n" +
                            "-----------\n" +
                            "  | O |  \n", board.toString());

    }

    @Test
    public void shouldRejectMoreMovesWhenFull(){
        board.move(0, "X");

        for (int i = 1; i < (boardSize * boardSize); i++) {
            board.move(i,"X");
        }

        assertFalse(board.isEmpty(1));
        assertTrue(board.isFull());
    }



    @Test
    public void shouldBeWonIfAllDiagonalPositionsAreSimilar(){
        String [] strings = {"X", "", "","", "X", "","", "", "X"};
        assertThat(new Board(Arrays.asList(strings)).isWon(), is(true));

        String [] strings2 = {"O", "", "","", "O", "","", "", "O"};
        assertThat(new Board(Arrays.asList(strings2)).isWon(), is(true));

        String [] strings3 = {"", "", "X","", "X", "","X", "", ""};

        assertThat(new Board(Arrays.asList(strings3)).isWon(), is(true));
    }


    @Test
    public void shouldBeWonIfAllHorizontalPositionsAreSimilar(){
        assertThat(new Board(Arrays.asList("X", "X", "X",
                                            "", "", "",
                                            "", "", "")).isWon(), is(true));

        assertThat(new Board(Arrays.asList("", "", "",
                                           "O", "O", "O",
                                            "", "", "")).isWon(), is(true));
        assertThat(new Board(Arrays.asList("", "", "",
                                           "", "", "",
                                           "X", "X", "X")).isWon(), is(true));
    }

    @Test
    public void shouldBeWonIfAllVerticalCellsAreSimilar(){
        assertThat(new Board(Arrays.asList("", "", "X","", "", "X","", "", "X")).isWon(),is(true));

        assertThat(new Board(Arrays.asList("", "X", "","", "X", "","", "X", "")).isWon(), is(true));

        assertThat(new Board(Arrays.asList("O", "", "",
                "O", "", "",
                "O", "", "")).isWon(), is(true));
    }

    @Test
    public void shouldNotWinIfOneCellIsDissimilar(){
        assertThat(new Board(
                Arrays.asList("", "", "X",
                        "", "", "O",
                        "", "", "X")).isWon(), is(false));

        assertThat(new Board(
                Arrays.asList("", "", "X",
                        "", "0", "",
                        "X", "", "")).isWon(), is(false));

        assertThat(new Board(
                Arrays.asList("X", "", "",
                        "0", "", "",
                        "X", "", "")).isWon(), is(false));
    }

    @Test
    public void shouldNotBeWonIfBoardIsEmpty(){

        assertThat(new Board(
                Arrays.asList("", "", "",
                        "", "", "",
                        "", "", "")).isWon(), is(false));
    }

    @Test
    public void shouldIndicateEmptyBoardWhenBoardIsEmpty(){
        assertThat(board.isFull(), is(false));
    }


    @Test
    public void shouldCorrectlyTellIfASuggestedMoveWins(){
        boolean notAWinningMove = board.isWinningMove(0, "X");
        assertThat(notAWinningMove, is(false));

        Board boardDiagonalWin = new Board(Arrays.asList(   "X", "", "",
                                                            "", "X", "",
                                                            "", "", ""));
        assertThat(boardDiagonalWin.isWinningMove(8, "X"), is(true));

        Board boardHorizontalWin = new Board(Arrays.asList( "X", "", "X",
                                                            "", "", "",
                                                            "", "", ""));
        assertThat(boardHorizontalWin.isWinningMove(1, "X"), is(true));

        Board boardVerticalWin = new Board(Arrays.asList(   "X", "", "",
                                                            "", "", "",
                                                            "X", "", ""));
        assertThat(boardVerticalWin.isWinningMove(3, "X"), is(true));

    }

    @Test
    public void shouldNotChangeBoardWhenAWinningTestIsPerformed(){
        Board board1 = new Board(Arrays.asList( "", "", "",
                                                "", "", "",
                                                "", "", ""));

        Board board2 = new Board(Arrays.asList( "", "", "",
                                                "", "", "",
                                                "", "", ""));

        assertThat(board1.equals(board2), is(true));

        board2.isWinningMove(2, "X");

        assertThat(board1.equals(board2), is(true));
    }

    @Test
    public void shouldIdentifyOwnershipOfPositions(){
        assertThat(board.isMyCell(2, "X"), is(false));

        Board board2 = new Board(Arrays.asList( "O", "", "",
                                                "", "", "",
                                                "", "", ""));

        assertThat(board2.isMyCell(0, "O"), is(true));

    }

}
