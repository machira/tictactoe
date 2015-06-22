package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer(String mark) {
        super("Computer Player", null, null, mark);
    }

    public void makeMove(Board board){
        for (int i = 0; i < 9; i++) {
            if(board.isEmpty(i)){
                board.move(i, mark);
                break;
            }
        }
    }
}
