package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by machira on Jun/18/15.
 */
public class Player {
    BufferedReader bufferedReader;
    private PrintStream printStream;
    int mark = 0;


    public Player(BufferedReader bufferedReader, PrintStream printStream, int mark){
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.mark = mark;
    }

    public Board makeMove(Board board){
        if(board.isFull()){
            return board;
        }
        int move = getInput(board.getSize() * board.getSize());
        
        while(!board.isEmpty(move)){
            printStream.println("Location Already Taken. Please try again");
            move = getInput(board.getSize() * board.getSize());
        }
        board.move(move,mark);
        return board;
    }


    public int getInput(int maxIndex){
        // repeat until valid input
        int choice = 0;
        do {
            try {

                printStream.print("Enter (1-9) for where you want to move: ");
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
