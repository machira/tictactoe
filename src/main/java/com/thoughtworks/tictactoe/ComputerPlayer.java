package com.thoughtworks.tictactoe;

import com.sun.org.apache.xml.internal.utils.ListingErrorHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayer extends Player {
    int BOARD_SIZE = 9;
    private String opponentMark;
    private Map<Integer, List<Integer>> forkMap;

    public ComputerPlayer(String mark, String opponentMark) {
        super("Computer Player", null, null, mark);
        this.opponentMark = opponentMark;
        this.forkMap = new HashMap<Integer, List<Integer>>();
        forkMap.put(0, Arrays.asList(2,6,8));
        forkMap.put(1, Arrays.asList(7));
        forkMap.put(2, Arrays.asList(6,8));
        forkMap.put(3, Arrays.asList(5));
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

    public int forkOpportunities(Board board) {
        //TODO: can I generalize 3?
        for(Map.Entry<Integer, List<Integer>> key : forkMap.entrySet()){
            if(board.isMyCell(key.getKey(), mark)){
                for(Integer cell : key.getValue()){
                    if(board.isEmpty(cell)){
                        return cell;
                    }
                }
            }
        }
        return -1;
    }
}
