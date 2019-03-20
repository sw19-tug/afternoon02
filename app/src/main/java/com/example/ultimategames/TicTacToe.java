package com.example.ultimategames;

import java.util.ArrayList;

public class TicTacToe {

    private ArrayList<ArrayList<Integer>> matrix;
    int numberOfFields;

    public TicTacToe(){
        numberOfFields = 0;
        matrix = new ArrayList<ArrayList<Integer>>(3);
        for(int i = 0; i < matrix.size(); i++) {
            matrix.add(new ArrayList<Integer>(3));
            for(int j = 0; j < matrix.get(i).size(); j++){
                matrix.get(i).set(j,0);
            }
        }
    }
    public void changeField(int x, int y, int value){
        if(matrix.get(x).get(y) != 0) {
            matrix.get(x).set(y, value);
            numberOfFields++;
        }
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
                return matrix.get(i).get(0);
            }
        }
        for(int i = 0; i < matrix.size(); i++){
            same = true;
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(j).get(0) != matrix.get(j).get(i)){
                    same = false;
                    break;
                }
            }
            if(same){
                return matrix.get(i).get(0);
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
            return matrix.get(0).get(0);
        }
        for(int i = 0; i < matrix.size(); i++){
            if(matrix.get(i).get(2-i) != matrix.get(0).get(2)){
                same=false;
                break;
            }
        }
        if(same){
            return matrix.get(0).get(2);
        }
        return numberOfFields < 9 ? -1 : 0;
    }
}
