package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by machira on Jun/24/15.
 */
public class CenterStrategyTest {

    CenterStrategy centerStrategy;

    @Before
    public void setUp(){
        this.centerStrategy = new CenterStrategy(4);
    }

    @Test
    public void shouldSelectCenterWhenCenterIsEmpty(){
        Board centerEmpty = new Board(Arrays.asList("","","",
                                                    "","","",
                                                    "","",""));

        int move = centerStrategy.recommendMove(centerEmpty);
        Assert.assertThat(move, is(4));

        Board centerNotEmpty = new Board(Arrays.asList( "","","",
                                                        "","X","",
                                                        "","",""));
        int noMove = centerStrategy.recommendMove(centerNotEmpty);
        assertThat(noMove, is(-1));
    }

}