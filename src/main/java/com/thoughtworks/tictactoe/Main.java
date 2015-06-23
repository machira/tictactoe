package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.player.ComputerPlayer;
import com.thoughtworks.tictactoe.player.HumanPlayer;
import com.thoughtworks.tictactoe.player.Player;
import com.thoughtworks.tictactoe.strategy.BlockOpposingPlayerStrategy;
import com.thoughtworks.tictactoe.strategy.ForkOpportunityStrategy;
import com.thoughtworks.tictactoe.strategy.Strategy;
import com.thoughtworks.tictactoe.strategy.WinningMoveStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by machira on Jun/18/15.
 */
public class Main {

    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        Map<Integer, List<Integer>> forkMap = new HashMap<Integer, List<Integer>>();;
        forkMap.put(0, Arrays.asList(2,6,8));
        forkMap.put(1, Arrays.asList(7));
        forkMap.put(2, Arrays.asList(6,8));
        forkMap.put(3, Arrays.asList(5));

        List<Strategy> strategyList = Arrays.asList(new WinningMoveStrategy("O"),
                                                    new BlockOpposingPlayerStrategy("X"),
                                                    new ForkOpportunityStrategy("O", forkMap));

        Player[] players = {
                                new HumanPlayer("Player1", bufferedReader, System.out,"X"),
                                new ComputerPlayer("O",strategyList)
                            };
        Game game = new Game(board,players,System.out);
        game.start();
    }


}
