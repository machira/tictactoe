package com.thoughtworks.tictactoe;

/**
 * Created by machira on Jun/18/15.
 */
public class Board {
    int size;
    int [][] boardArray;
    public Board(int size) {
        this.size = size;
        this.boardArray = new int [size][size];
    }


    public boolean movePlayer1(int move){
        return move (move, 1);
    }

    public boolean movePlayer2(int move){
        return move (move, -1);
    }
    public boolean move(int move, int marker){
//        move = move - 1;
        int index1 = move/size;
        int index2 = move - (size * index1);

        // empty spot
        if (boardArray[index1][index2] == 0){
            boardArray[index1][index2] = marker;
            return true;
        }
        // move was not successful
        return false;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        // for every line
        for (int i = 0; i < size; i++) {
            // for every cell
            for (int j = 0; j < size; j++) {
                String cell = "";
                if(boardArray[i][j] == 1){
                    cell = " X ";
                }else if(boardArray[i][j] == -1){
                    cell = " O ";
                }else{
                    cell = "   ";
                }

                stringBuilder.append(cell);

                if(j != size-1){
                    stringBuilder.append("|");
                }
            }
            if( i != size-1){
                stringBuilder.append("\n-----------");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public boolean isFull(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(boardArray[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
