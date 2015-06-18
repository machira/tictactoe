package com.thoughtworks.tictactoe;

import java.io.BufferedReader;

/**
 * Created by machira on Jun/18/15.
 */
public class Player {
    BufferedReader bufferedReader;
    int maxIndex = 0;

    public String getMark() {
        return mark;
    }

    private String mark;

    public Player(BufferedReader bufferedReader, int maxIndex, String mark){
        this.bufferedReader = bufferedReader;
        this.maxIndex = maxIndex;
        this.mark = mark;
    }



}
