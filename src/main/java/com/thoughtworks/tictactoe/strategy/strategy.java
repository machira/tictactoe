package com.thoughtworks.tictactoe.strategy;

import com.thoughtworks.tictactoe.Board;

/**
 * Created by machira on Jun/23/15.
 */
public interface Strategy {
    int BOARD_SIZE = 9;
    int move(Board board);
}
