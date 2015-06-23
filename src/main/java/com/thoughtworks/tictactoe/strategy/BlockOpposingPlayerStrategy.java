package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

/**
 * Created by machira on Jun/23/15.
 */
public class BlockOpposingPlayerStrategy implements Strategy {
    private String opponentMark;

    public BlockOpposingPlayerStrategy(String opponentMark){
        this.opponentMark = opponentMark;
    }

    /**
     * Blocking an opposing player consists of finding their winning move, and playing that instead. Thus, we can take
     * advantage of our winning move strategy;
     * @param board
     * @return
     */
    public int move(Board board) {
        return new WinningMoveStrategy(opponentMark).move(board);
    }

}
