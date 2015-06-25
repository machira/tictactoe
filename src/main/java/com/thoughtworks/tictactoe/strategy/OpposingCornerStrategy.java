package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

import java.util.Map;

/**
 * Created by machira on Jun/24/15.
 */
public class OpposingCornerStrategy implements Strategy{
    String opponentMark;
    Map<Integer, Integer> cornersMap;

    public OpposingCornerStrategy(String opponentMark, Map<Integer, Integer> cornersMap) {
        this.opponentMark = opponentMark;
        this.cornersMap = cornersMap;
    }

    public int recommendMove(Board board){
        for(Integer cell : cornersMap.keySet()){
            if(board.isOpponentCell(cell, opponentMark)){
                int opposingCell  = cornersMap.get(cell);
                if(board.isEmpty(opposingCell)){
                    return opposingCell;
                }
            }
        }
        return -1;
    }

}
