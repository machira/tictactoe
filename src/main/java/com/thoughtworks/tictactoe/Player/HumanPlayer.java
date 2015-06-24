package com.thoughtworks.tictactoe.player;

import com.thoughtworks.tictactoe.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by machira on Jun/18/15.
 */
public class HumanPlayer  implements  Player{
    private String playerName;
    BufferedReader bufferedReader;
    private PrintStream printStream;
    String mark;
    private int BOARDSIZE = 9;


    public HumanPlayer(String name, BufferedReader bufferedReader, PrintStream printStream, String mark){
        this.playerName = name;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.mark = mark;
    }

    public String getPlayerName(){
        return playerName;
    }
    public void makeMove(Board board){
        if(board.isFull()){
            return;
        }
        int move = getInput();
        move -= 1;
        while(!board.isEmpty(move)){
            printStream.println("Location Already Taken. Please try again");
            move = getInput();
        }
        board.move(move,mark);
    }


    public int getInput(){
        // repeat until valid input
        int choice = 0;
        do {
            try {
                printStream.print(playerName +", Enter (1-9) for where you want to move: ");
                choice = Integer.valueOf(bufferedReader.readLine());
            }catch (NumberFormatException nfe){
                printStream.println("You must enter a number");
            }catch (IOException ie){
                printStream.println("You must enter input");
            }
        }while (choice < 1 || choice > BOARDSIZE);

        return choice;
    }
}
