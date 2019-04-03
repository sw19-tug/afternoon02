package com.example.TicTacToe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultimategames.R;

import java.util.ArrayList;

public class TicTacToe_Activity extends AppCompatActivity {
    TextView textView00;
    TextView textView01;
    TextView textView02;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView20;
    TextView textView21;
    TextView textView22;
    TextView result;
    String[] strings = {"X", "O"};
    int switchPlayer = 1;
    TicTacToe ticTacToe = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);
        textView00 = (TextView) findViewById(R.id.b00);
        textView01 = (TextView) findViewById(R.id.b01);
        textView02 = (TextView) findViewById(R.id.b02);
        textView10 = (TextView) findViewById(R.id.b10);
        textView11 = (TextView) findViewById(R.id.b11);
        textView12 = (TextView) findViewById(R.id.b12);
        textView20 = (TextView) findViewById(R.id.b20);
        textView21 = (TextView) findViewById(R.id.b21);
        textView22 = (TextView) findViewById(R.id.b22);
        result = findViewById(R.id.result);
        textView00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView00.setClickable(false);
                int resultOfGame = ticTacToe.changeField(0,0,switchPlayer);
                textView00.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView01.setClickable(false);
                int resultOfGame = ticTacToe.changeField(0,1,switchPlayer);
                textView01.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView02.setClickable(false);
                int resultOfGame = ticTacToe.changeField(0,2,switchPlayer);
                textView02.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView10.setClickable(false);
                int resultOfGame = ticTacToe.changeField(1,0,switchPlayer);
                textView10.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                }
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView11.setClickable(false);
                int resultOfGame = ticTacToe.changeField(1,1,switchPlayer);
                textView11.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView12.setClickable(false);
                int resultOfGame = ticTacToe.changeField(1,2,switchPlayer);
                textView12.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView20.setClickable(false);
                int resultOfGame = ticTacToe.changeField(2,0,switchPlayer);
                textView20.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView21.setClickable(false);
                int resultOfGame = ticTacToe.changeField(2,1,switchPlayer);
                textView21.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

        textView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView22.setClickable(false);
                int resultOfGame = ticTacToe.changeField(2,2,switchPlayer);
                textView22.setText(strings[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                if(resultOfGame == 1){
                    result.setText("Player one WON!");
                    removeListeners();
                }
                else if(resultOfGame == 2){
                    result.setText("Player two WON!");
                    removeListeners();
                }
                else if(resultOfGame == 0){
                    result.setText("DRAW");
                    removeListeners();
                }
            }
        });

    }

    private void removeListeners(){
        textView00.setOnClickListener(null);
        textView01.setOnClickListener(null);
        textView02.setOnClickListener(null);
        textView10.setOnClickListener(null);
        textView11.setOnClickListener(null);
        textView12.setOnClickListener(null);
        textView20.setOnClickListener(null);
        textView21.setOnClickListener(null);
        textView22.setOnClickListener(null);
    }


}
