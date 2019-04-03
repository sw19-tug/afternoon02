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
    public int changeField(int x, int y, int value){
        if(matrix.get(x).get(y) == 0) {
            matrix.get(x).set(y, value);
            numberOfFields++;
            return checkIfGameIsDone();
        }
        return -1;
    }
    private int checkIfGameIsDone(){
        boolean same = true;
        for(int i = 0; i < matrix.size(); i++){
            same = true;
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(0) != matrix.get(i).get(j)){
                    same = false;
                    break;
                }
            }
            if(same){
                return matrix.get(i).get(0) != 0 ? matrix.get(i).get(0) : -1;
            }
        }
        for(int i = 0; i < matrix.size(); i++){
            same = true;
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(0).get(i) != matrix.get(j).get(i)){
                    same = false;
                    break;
                }
            }
            if(same){
                return matrix.get(0).get(i) != 0 ? matrix.get(0).get(i) : -1;
            }
        }
        same = true;
        for(int i = 0; i < matrix.size(); i++){
            if(matrix.get(i).get(i) != matrix.get(0).get(0)){
                same=false;
                break;
            }
        }
        if(same){
            return matrix.get(0).get(0) != 0 ? matrix.get(0).get(0) : -1;
        }
        for(int i = 0; i < matrix.size(); i++){
            if(matrix.get(i).get(matrix.size()-1-i) != matrix.get(0).get(matrix.size()-1)){
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
