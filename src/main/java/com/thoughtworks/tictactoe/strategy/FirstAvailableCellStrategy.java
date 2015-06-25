package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

/**
 * Created by machira on Jun/23/15.
 */
public class FirstAvailableCellStrategy implements Strategy {


    public int recommendMove(Board board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board.isEmpty(i)){
                return i;
            }
        }

        return -1;
    }
}
