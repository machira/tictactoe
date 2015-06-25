package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

/**
 * Created by machira on Jun/24/15.
 */
public class CenterStrategy implements Strategy{
    int center;

    public CenterStrategy(int center){
        this.center = center;
    }

    public int recommendMove(Board board){
        if(board.isEmpty(center)){
            return center;
        }
        return -1;
    }
}
