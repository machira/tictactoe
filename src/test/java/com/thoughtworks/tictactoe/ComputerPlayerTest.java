package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.player.ComputerPlayer;
import com.thoughtworks.tictactoe.strategy.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayerTest {
    ComputerPlayer computerPlayer;
    private BlockOpposingPlayerStrategy blockOpposingPlayerStrategy;
    private FirstAvailableCellStrategy firstAvailableCellStrategy;
    private ForkOpportunityStrategy forkOpportunityStrategy;
    private WinningMoveStrategy winningMoveStrategy;

    @Before
    public void setUp() throws Exception {
        List<Strategy> strategyList = new ArrayList<Strategy>();

        blockOpposingPlayerStrategy = mock(BlockOpposingPlayerStrategy.class);
        firstAvailableCellStrategy = mock(FirstAvailableCellStrategy.class);
        forkOpportunityStrategy = mock(ForkOpportunityStrategy.class);
        winningMoveStrategy = mock(WinningMoveStrategy.class);

        strategyList.addAll(Arrays.asList(winningMoveStrategy, blockOpposingPlayerStrategy, firstAvailableCellStrategy, forkOpportunityStrategy));
        computerPlayer = new ComputerPlayer("O", strategyList);
    }


    @Test
    public void shouldPrioritizeWinningOverBlocking(){

//        this mocks a board that can be won or blocked such as:
//        "X","","X",
//        "O", "O", "",
//        "", "", ""

        Board boardWinningOrBlocking = mock(Board.class);
        // We describe the two winning conditions of the board.
        when(blockOpposingPlayerStrategy.move(boardWinningOrBlocking)).thenReturn(1);
        when(winningMoveStrategy.move(boardWinningOrBlocking)).thenReturn(5);

        computerPlayer.makeMove(boardWinningOrBlocking);
        verify(boardWinningOrBlocking).move(5,"O");
    }



}