package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by machira on Jun/18/15.
 */
public class Main {
    PrintStream printStream;
    BufferedReader bufferedReader;
    Board board;
    int boardSize = 3;

    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(3);
        Main main = new Main(board,System.out, bufferedReader);
        main.start();
    }

    Main(Board board, PrintStream printStream, BufferedReader bufferedReader){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
    }


    public void start(){
//        printStream.println(board.toString());
        while(alternatePlayers()){
            ;
        }
    }
    

    public boolean alternatePlayers(){
        int [] playerMarkers = {1,-1};
        for(int playerMarker: playerMarkers){
            printStream.println(board.toString());
            int input = getInput();
            if (input == 0){
                printStream.println("Player resigned.");
                return false;
            }
            while(!board.move(input-1,playerMarker)){
                printStream.println("Location Already Taken. Please try again");
                input = getInput();
            }

            if(board.isFull()){
                return false;
            }
        }
        return true;
    }
}
