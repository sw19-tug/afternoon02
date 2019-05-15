package com.example.TicTacToe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ultimategames.R;

public class TicTacToe_WelcomeScreen extends AppCompatActivity {
    Button buttonTicTacToePvP;
    Button buttonTicTacToePvC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe__welcome_screen);
        buttonTicTacToePvP = findViewById(R.id.btn_tictactoePvP);
        buttonTicTacToePvC=findViewById(R.id.btn_tictactoePvC);
        buttonTicTacToePvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicTacToe_WelcomeScreen.this, TicTacToePvP_Activity.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    TicTacToe_WelcomeScreen.this.startActivity(intent);
                }
            }
        });
        buttonTicTacToePvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicTacToe_WelcomeScreen.this, TicTacToe_ColorSelection_Activity.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    TicTacToe_WelcomeScreen.this.startActivity(intent);
                }
            }
        });

    }

}
