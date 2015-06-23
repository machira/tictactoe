package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayer extends Player {
    int BOARD_SIZE = 9;
    public ComputerPlayer(String mark) {
        super("Computer Player", null, null, mark);
    }

    public void makeMove(Board board){
        int move = selectWinningMove(board);
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
        int winningMove = -1;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board.isEmpty(i)){
                board.move(i,mark);
                if(board.isWon()){
                    winningMove = i;
                    // undo move on board
                    board.move(i,"");
                    break;
                }
                board.move(i,"");
            }
        }

        return winningMove;
    }
}
