package com.example.ultimategames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.TicTacToe.TicTacToe_WelcomeScreen;
import com.example.ultimategames.TouchTheBlock.TTB_Activity;

public class WelcomeScreenActivity extends AppCompatActivity {

    public static int global_score = 0;
    Button buttonTicTacToe;
    Button buttonHangman;
    Button buttonTouchBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        buttonTicTacToe = findViewById(R.id.btn_tictactoe);
        buttonHangman = findViewById(R.id.btn_hangman);
        buttonTouchBlock = findViewById(R.id.btn_block);

        buttonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreenActivity.this, TicTacToe_WelcomeScreen.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    WelcomeScreenActivity.this.startActivity(intent);
                }
            }
        });

        buttonHangman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreenActivity.this, HangmanSelScreen.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    WelcomeScreenActivity.this.startActivity(intent);
                }
            }
        });

        buttonTouchBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreenActivity.this, TTB_Activity.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    WelcomeScreenActivity.this.startActivity(intent);
                }
            }
        });

        UpdateScore();
    }

    private void UpdateScore()
    {
        TextView tvScore = (TextView) findViewById(R.id.text_score);
        String textScore = Integer.toString(global_score);

        tvScore.setText(textScore);
    }
}
