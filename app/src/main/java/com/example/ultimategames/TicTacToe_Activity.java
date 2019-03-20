package com.example.ultimategames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TicTacToe_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);
        TextView textView00 = (TextView) findViewById(R.id.b00);
        TextView textView01 = (TextView) findViewById(R.id.b01);
        TextView textView02 = (TextView) findViewById(R.id.b02);
        TextView textView10 = (TextView) findViewById(R.id.b10);
        TextView textView11 = (TextView) findViewById(R.id.b11);
        TextView textView12 = (TextView) findViewById(R.id.b12);
        TextView textView20 = (TextView) findViewById(R.id.b20);
        TextView textView21 = (TextView) findViewById(R.id.b21);
        TextView textView22 = (TextView) findViewById(R.id.b22);

        textView00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText("s");
            }
        });
    }

    public void changeText(String text){

    }




}
