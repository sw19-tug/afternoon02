package com.example.ultimategames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeScreenActivity extends AppCompatActivity {

    public int global_score = 0;

    Button buttonTicTacToe;
    Button buttonHangman;
    Button buttonTouchBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        buttonTicTacToe = (Button) findViewById(R.id.btn_tictactoe);
        buttonHangman = (Button) findViewById(R.id.btn_hangman);
        buttonTouchBlock = (Button) findViewById(R.id.btn_block);

        buttonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tic Tac Toe selected.", Toast.LENGTH_LONG).show();
            }
        });

        buttonHangman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hangman selected.", Toast.LENGTH_LONG).show();
            }
        });

        buttonTouchBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Touch the Block selected.", Toast.LENGTH_LONG).show();
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
