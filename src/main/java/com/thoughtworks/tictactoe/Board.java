package com.thoughtworks.tictactoe;
import java.util.Arrays;
import java.util.List;

/**
 * Created by machira on Jun/18/15.
 */
public class Board {
    private int size;
    List<String> boardArray;
    public Board(List<String> boardArray) {
        this.size = boardArray.size();
        this.boardArray = boardArray;
    }

    public Board(){
        String [] strings =new String[]{"","","",
                                        "","","",
                                        "","",""};
        this.boardArray = Arrays.asList(strings);
    }

    public int getSize(){
        return size;
    }


    public void move(int move, String marker){
        boardArray.set(move, marker);
    }

    /**
     *
     * @return String representation of the Board
     */
    public String toString(){

        String boardString =" %s | %s | %s \n" +
                            "-----------\n" +
                            " %s | %s | %s \n" +
                            "-----------\n" +
                            " %s | %s | %s \n";

        return String.format(boardString,boardArray.toArray());
    }


    public boolean isFull(){
        for (int i = 0; i < size; i++) {
            if(boardArray.get(i).equals("")){
                return false;
            }
        }
        return true;
    }


    public boolean isEmpty(int index){
        return boardArray.get(index).equals("");
    }

    public boolean isWon(){
        return horizontalWin() || verticalWin() || diagonalWin();
    }


    private boolean horizontalWin(){
        return (!boardArray.get(0).equals("") && boardArray.get(0).equals(boardArray.get(1)) && boardArray.get(1).equals(boardArray.get(2))) ||
               (!boardArray.get(3).equals("") && boardArray.get(3).equals(boardArray.get(4)) && boardArray.get(4).equals(boardArray.get(5))) ||
               (!boardArray.get(6).equals("") && boardArray.get(6).equals(boardArray.get(7)) && boardArray.get(7).equals(boardArray.get(8)));
    }

    private boolean diagonalWin(){
        return (!boardArray.get(0).equals("") && boardArray.get(0).equals(boardArray.get(4)) && boardArray.get(4).equals(boardArray.get(8))) ||
               (!boardArray.get(2).equals("") && boardArray.get(2).equals(boardArray.get(4)) && boardArray.get(4).equals(boardArray.get(6)));
    }

    private boolean verticalWin(){
        return (!boardArray.get(0).equals("") && boardArray.get(0).equals(boardArray.get(3)) && boardArray.get(3).equals(boardArray.get(6))) ||
               (!boardArray.get(1).equals("") && boardArray.get(1).equals(boardArray.get(4)) && boardArray.get(4).equals(boardArray.get(7))) ||
               (!boardArray.get(2).equals("") && boardArray.get(2).equals(boardArray.get(5)) && boardArray.get(5).equals(boardArray.get(8)));
    }
}
