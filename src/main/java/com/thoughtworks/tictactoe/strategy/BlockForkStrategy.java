package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

import java.util.List;
import java.util.Map;

/**
 * Created by machira on Jun/24/15.
 */
public class BlockForkStrategy implements Strategy {
    String opposingPlayerMark;
    Map<Integer, List<Integer>> forkMap;

    public BlockForkStrategy(String opposingPlayerMark, Map<Integer, List<Integer>> forkMap){
        this.opposingPlayerMark = opposingPlayerMark;
        this.forkMap = forkMap;
    }

    public int recommendMove(Board board) {
        return new ForkOpportunityStrategy(opposingPlayerMark, forkMap).recommendMove(board);
    }
}
