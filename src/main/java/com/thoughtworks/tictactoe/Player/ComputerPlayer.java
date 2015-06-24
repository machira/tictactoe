package com.thoughtworks.tictactoe.player;

import com.thoughtworks.tictactoe.Board;
import com.thoughtworks.tictactoe.strategy.Strategy;
import java.util.List;

/**
 * Created by machira on Jun/21/15.
 */
public class ComputerPlayer implements Player {
    String mark = "";
    private List<Strategy> strategyList;

    public ComputerPlayer(String mark, List<Strategy> strategyList) {
        this.mark = mark;
        this.strategyList = strategyList;
    }

    public void makeMove(Board board){
        for(Strategy strategy: strategyList){
            int move = strategy.move(board);
            if(move != -1){
                board.move(move, mark);
                return;
            }
        }
    }

    public String getPlayerName(){
        return "Computer Player";
    }

}
