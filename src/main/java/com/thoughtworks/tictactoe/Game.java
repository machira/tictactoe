package com.thoughtworks.tictactoe;
import com.thoughtworks.tictactoe.player.HumanPlayer;
import com.thoughtworks.tictactoe.player.Player;

import java.io.PrintStream;

/**
 * Created by machira on Jun/21/15.
 */
public class Game {


    private PrintStream printStream;
    private Board board;
    private Player[] players;


    public Game(Board board, Player[] players, PrintStream printStream){
        this.board = board;
        this.players = players;
        this.printStream = printStream;
    }
    public void alternatePlayers(){
        while(true){
            for(Player player: players){
                player.makeMove(board);
                if(board.isWon()){
                    printStream.println(player.getPlayerName() + " has won.");
                    return;
                }else if(board.isFull()){
                    return;
                }
                printStream.println(board.toString());
            }

        }
    }

    public void start() {
       alternatePlayers();
    }

}
