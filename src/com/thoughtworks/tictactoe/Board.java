package com.thoughtworks.tictactoe;

/**
 * Created by machira on Jun/18/15.
 */
public class Board {
    int size;
    public Board(int size) {
        this.size = size;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        // for every line
        for (int i = 0; i < size; i++) {
            // for every cell
            for (int j = 0; j < size; j++) {
                stringBuilder.append("    ");
                if(j != size-1){
                    stringBuilder.append("|");
                }
            }
            if( i != size-1){
                stringBuilder.append("\n--------------");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
