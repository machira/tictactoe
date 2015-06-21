package com.thoughtworks.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by machira on Jun/18/15.
 */
public class BoardTest {
    Board board;
    int boardSize = 3;
    @Before
    public void setUp(){
        board = new Board(new int[][]{{0,0,0},
                                      {0,0,0},
                                      {0,0,0}});
    }

    @Test
    public void boardShouldPrintAsASquare(){
        String boardString = board.toString();
        Assert.assertEquals("   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n", boardString);
    }

    @Test
    public void shouldUpdateBoardAppearanceOnMove(){
        board.move(0,1);
        Assert.assertEquals(" X |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n", board.toString());

        board.move(7,-1);
        Assert.assertEquals(" X |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   | O |   \n", board.toString());

        board.move(4,1);
        Assert.assertEquals(" X |   |   \n" +
                            "-----------\n" +
                            "   | X |   \n" +
                            "-----------\n" +
                            "   | O |   \n", board.toString());

    }

    @Test
    public void shouldRejectMoreMovesWhenFull(){
        assertTrue(board.move(0, 1));
        for (int i = 1; i < (boardSize * boardSize); i++) {
            board.move(i,1);
        }
        assertFalse(board.move(boardSize, 1));
        assertTrue(board.isFull());
    }


    @Test
    public void testBoardWinningConditions(){
        assertThat(new Board(new int[][]{{0,0,0},
                                         {0,0,0},
                                         {0,0,0}}).isWon(), is(true));

        assertThat(new Board(new int[][]{
                {0,0,0},
                {0,0,0},
                {1,1,1}}).isWon(), is(true));
    }

    @Test
    public void shouldBeWonIfAllDiagonalPositionsAreSimilar(){
        assertThat(new Board(new int[][]{
                                        {1,0,0},
                                        {0,1,0},
                                        {0,0,1}}).isWon(), is(true));

        assertThat(new Board(new int[][]{
                                        {-1,0,0},
                                        {0,-1,0},
                                        {0,0,-1}}).isWon(), is(true));
        assertThat(new Board(new int[][]{
                                        {0,0,1},
                                        {0,1,0},
                                        {1,0,0}}).isWon(), is(true));
    }


    @Test
    public void shouldBeWonIfAllHorizontalPositionsAreSimilar(){
        assertThat(new Board(new int[][]{
                {1,1,1},
                {0,0,0},
                {0,0,0}}).isWon(), is(true));

        assertThat(new Board(new int[][]{
                {0,0,0},
                {-1,-1,-1},
                {0,0,0}}).isWon(), is(true));
        assertThat(new Board(new int[][]{
                {0,0,0},
                {0,0,0},
                {1,1,1}}).isWon(), is(true));
    }

    @Test
    public void shouldBeWonIfAllVerticalCellsAreSimilar(){
        assertThat(new Board(new int[][]{
                                        {0,0,1},
                                        {0,0,1},
                                        {0,0,1}}).isWon(), is(true));

        assertThat(new Board(new int[][]{
                                        {0,1,0},
                                        {0,1,0},
                                        {0,1,0}}).isWon(), is(true));

        assertThat(new Board(new int[][]{
                                        {1,0,0},
                                        {1,0,0},
                                        {1,0,0}}).isWon(), is(true));
    }

    @Test
    public void shouldNotWinIfOneCellIsDissimilar(){
        assertThat(new Board(new int[][]{
                {0,0,1},
                {0,0,-1},
                {0,0,1}}).isWon(), is(false));

        assertThat(new Board(new int[][]{
                {0,0,1},
                {0,0,0},
                {-1,0,0}}).isWon(), is(false));

        assertThat(new Board(new int[][]{
                {1,0,0},
                {0,0,0},
                {1,0,0}}).isWon(), is(false));
    }

    @Test
    public void shouldNotBeWonIfBoardIsEmpty(){

        assertThat(new Board(new int[][]{
                                        {0,0,0},
                                        {0,0,0},
                                        {0,0,0}}).isWon(), is(false));
    }

}
