package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by machira on Jun/18/15.
 */
public class Main {

    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        Player [] players = {
                                new Player("Player1", bufferedReader, System.out,"X"),
                                new ComputerPlayer("O")
//                Player("Player2", bufferedReader, System.out,"O")
                            };
        Game game = new Game(board,players,System.out);
        game.start();
    }


}
