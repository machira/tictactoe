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
 * Created by machira on Jun/24/15.
 */
public class BlockForkStrategyTest {

    private BlockForkStrategy blockForkStrategy;

    @Before
    public void setUp(){
        Map<Integer, List<Integer>> forkMap = new HashMap<Integer, List<Integer>>();;
        forkMap.put(0, Arrays.asList(2, 6, 8));
        forkMap.put(1, Arrays.asList(7));
        forkMap.put(2, Arrays.asList(6,8));
        forkMap.put(3, Arrays.asList(5));

        blockForkStrategy = new BlockForkStrategy("H", forkMap);

    }

    @Test
    public void shouldBlockOpposingPlayerGivenTheChance(){
        int move = blockForkStrategy.recommendMove(new Board(Arrays.asList("H", "", "",
                "", "", "",
                "", "", "")));
        Assert.assertThat(move, is(2));
    }

}