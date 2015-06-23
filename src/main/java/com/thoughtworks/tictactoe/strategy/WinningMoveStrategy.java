package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

/**
 * Created by machira on Jun/23/15.
 */
public class WinningMoveStrategy implements Strategy {
    private String mark;

    public WinningMoveStrategy(String mark){
        this.mark = mark;
    }

    public int move(Board board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board.isWinningMove(i, this.mark)) {
                return i;
            }
        }
        return -1;
    }
}
