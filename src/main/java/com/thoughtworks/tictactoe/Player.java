package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by machira on Jun/18/15.
 */
public class Player {
    private String playerName;
    BufferedReader bufferedReader;
    private PrintStream printStream;
    int mark = 0;


    public Player(String name, BufferedReader bufferedReader, PrintStream printStream, int mark){
        this.playerName = name;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.mark = mark;
    }

    public Board makeMove(Board board){
        if(board.isFull()){
            return board;
        }
        int move = getInput(board.getSize() * board.getSize());
        move -= 1;
        while(!board.isEmpty(move)){
            printStream.println("Location Already Taken. Please try again");
            move = getInput(board.getSize() * board.getSize());
        }
        makeMoveOnBoard(board,move);
//        board.move(move,mark);
        return board;
    }

    public void makeMoveOnBoard(Board board, int move){
        board.move(move,mark);
    }

    public int getInput(int maxIndex){
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
        }while (choice < 1 || choice > maxIndex);

        return choice;
    }
}
