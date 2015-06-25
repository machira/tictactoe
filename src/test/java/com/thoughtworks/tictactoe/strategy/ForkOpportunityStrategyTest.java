package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by machira on Jun/23/15.
 */
public class ForkOpportunityStrategyTest {
    private ForkOpportunityStrategy forks;


    @Before
    public void setUp() {
        Map<Integer, List<Integer>> forkMap = new HashMap<Integer, List<Integer>>();;
        forkMap.put(0, Arrays.asList(2,6,8));
        forkMap.put(1, Arrays.asList(7));
        forkMap.put(2, Arrays.asList(6,8));
        forkMap.put(3, Arrays.asList(5));

        forks = new ForkOpportunityStrategy("O", forkMap);

    }

    @Test
    public void shouldCreateForksWheneverPossible() {
        Board board = new Board(Arrays.asList(  "O", "", "",
                                                "", "", "",
                                                "", "", ""));

        int move = forks.recommendMove(board);
        Assert.assertThat(move, is(2));

        Board board1 = new Board(Arrays.asList( "O", "", "X",
                                                "", "", "",
                                                "", "", ""));

        int move1 = forks.recommendMove(board1);
        Assert.assertThat(move1, is(6));

        Board board2 = new Board(Arrays.asList( "O", "", "X",
                                                "", "", "",
                                                "X", "", ""));

        int move2 = forks.recommendMove(board2);
        Assert.assertThat(move2, is(8));

    }

}