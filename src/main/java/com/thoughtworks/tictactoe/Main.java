package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by machira on Jun/18/15.
 */
public class Main {

    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(new int[][]{{0,0,0},
                                            {0,0,0},
                                            {0,0,0}});
        Player [] players = {
                                new Player("Player1", bufferedReader, System.out,1),
                                new Player("Player2", bufferedReader, System.out,-1)
                            };
        Game game = new Game(board,players,System.out);
        game.start();
    }


}
