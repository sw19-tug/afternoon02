package com.example.TicTacToe;

import java.util.ArrayList;

public class TicTacToe {

    private ArrayList<ArrayList<Integer>> matrix;
    int numberOfFields;

    public TicTacToe(){
        numberOfFields = 0;
        matrix = new ArrayList<ArrayList<Integer>>(3);
        for(int i = 0; i < 3; i++) {
            matrix.add(new ArrayList<Integer>(3));
            for(int j = 0; j < 3; j++){
                matrix.get(i).add(0);
            }
        }
    }
    public int changeField(int row, int column, int value){
        if(matrix.get(row).get(column) == 0) {
            matrix.get(row).set(column, value);
            numberOfFields++;
            return checkIfGameIsDone();
        }
        return -1;
    }
    private int checkIfGameIsDone(){
        boolean same = true;
        for(int row = 0; row < matrix.size(); row++){
            same = true;
            for(int column = 0; column < matrix.get(row).size(); column++){
                if(matrix.get(row).get(column) == 0 || matrix.get(row).get(0) != matrix.get(row).get(column)){
                    same = false;
                    break;
                }
            }
            if(same){
                return matrix.get(row).get(0) != 0 ? matrix.get(row).get(0) : -1;
            }
        }
        for(int column = 0; column < matrix.size(); column++){
            same = true;
            for(int row = 0; row < matrix.get(column).size(); row++){
                if(matrix.get(0).get(column) != matrix.get(row).get(column) || matrix.get(row).get(column) == 0){
                    same = false;
                    break;
                }
            }
            if(same){
                return matrix.get(0).get(column) != 0 ? matrix.get(0).get(column) : -1;
            }
        }
        same = true;
        for(int row = 0; row < matrix.size(); row++){
            if(matrix.get(row).get(row) != matrix.get(0).get(0)){
                same=false;
                break;
            }
        }
        if(same){
            return matrix.get(0).get(0) != 0 ? matrix.get(0).get(0) : -1;
        }
        same = true;
        for(int row = 0; row < matrix.size(); row++){
            if(matrix.get(row).get(matrix.size()-1-row) != matrix.get(0).get(matrix.size()-1)){
                same=false;
                break;
            }
        }
        if(same){
            return matrix.get(0).get(2) != 0 ? matrix.get(0).get(2) : -1;
        }
        return numberOfFields < 9 ? -1 : 0;
    }
}