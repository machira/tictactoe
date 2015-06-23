package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayer extends Player {
    int BOARD_SIZE = 9;
    private String opponentMark;
    public ComputerPlayer(String mark, String opponentMark) {
        super("Computer Player", null, null, mark);
        this.opponentMark = opponentMark;
    }

    public void makeMove(Board board){
        int move = selectWinningMove(board);
        if(move == -1){
            move = blockOpposingPlayer(board);
        }
        if(move == -1){
            move = selectFirstAvailableCell(board);
        }
        if(move != -1){
            board.move(move,mark);
        }
    }

    public int selectFirstAvailableCell(Board board){
        int move = -1;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board.isEmpty(i)){
                move = i;
                break;
            }
        }

        return move;
    }

    /**
     * Selects and returns the next available move that is a winning move.
     * @return the cell to mark, or 0 if no winning move is available.
     */
    public int selectWinningMove(Board board){
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board.isWinningMove(i, mark)) {
                return i;
            }
        }
        return -1;
    }

    public int blockOpposingPlayer(Board board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board.isWinningMove(i, opponentMark)) {
                return i;
            }
        }
        return -1;
    }
}
