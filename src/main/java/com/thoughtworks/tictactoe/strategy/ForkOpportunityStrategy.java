package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

import java.util.List;
import java.util.Map;

/**
 * Created by machira on Jun/23/15.
 */
public class ForkOpportunityStrategy implements Strategy {
    private String mark;
    private Map<Integer, List<Integer>> forkMap;

    public ForkOpportunityStrategy(String mark, Map<Integer, List<Integer>> forkMap){
        this.mark = mark;
        this.forkMap = forkMap;

    }

    public int move(Board board){
        for(Map.Entry<Integer, List<Integer>> key : forkMap.entrySet()){
            if(board.isMyCell(key.getKey(), mark)){
                for(Integer cell : key.getValue()){
                    if(board.isEmpty(cell)){
                        return cell;
                    }
                }
            }
        }
        return -1;    }
}
