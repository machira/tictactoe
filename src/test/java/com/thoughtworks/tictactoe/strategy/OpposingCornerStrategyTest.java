package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by machira on Jun/24/15.
 */
public class OpposingCornerStrategyTest {
    public static final int TOP_LEFT_CORNER = 0;
    OpposingCornerStrategy opposingCornerStrategy;

    @Before
    public void setUp(){
        Map<Integer, Integer> cornersMap = new HashMap<Integer, Integer>();
        String opponentMark = "X";
        cornersMap.put(0,8);
        cornersMap.put(3,6);
        cornersMap.put(8,0);
        cornersMap.put(6,3);
        opposingCornerStrategy = new OpposingCornerStrategy(opponentMark,cornersMap);
    }

    @Test
    public void shouldSelectTheOpposingCornerToOpponent(){
//        Board emptyBoard = mock(Board.class);
//        when(newBoard.isMyCell(anyInt(),anyString())).thenReturn(true)
//        when(newBoard.isEmpty(anyInt())).thenReturn(true);
        Board emptyBoard = new Board(Arrays.asList( "X","","X",
                                                    "","","",
                                                    "X","",""));


        int move = opposingCornerStrategy.recommendMove(emptyBoard);

        Assert.assertThat(move, is(8));

//        Board noAvailableCornerCells()
    }
}
