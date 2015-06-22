package com.thoughtworks.tictactoe;
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
    public boolean alternatePlayers(){
        for(Player player: players){
            player.makeMove(board);
            if(board.isFull()){
                return false;
            }
            printStream.println(board.toString());
        }
        return true;
    }

    public void start() {
        do {
            printStream.println(board.toString());
        }while (alternatePlayers());


        printStream.println(board.toString());

    }

}
