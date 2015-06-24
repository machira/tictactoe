package com.thoughtworks.tictactoe.player;

import com.thoughtworks.tictactoe.Board;

/**
 * Created by machira on Jun/23/15.
 */
public interface Player {
    void makeMove(Board board);
    String getPlayerName();
}
