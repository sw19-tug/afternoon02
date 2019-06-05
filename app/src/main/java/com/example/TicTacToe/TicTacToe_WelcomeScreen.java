package com.example.TicTacToe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ultimategames.R;
import com.example.ultimategames.WelcomeScreenActivity;

public class TicTacToe_WelcomeScreen extends AppCompatActivity {
    Button buttonTicTacToePvP;
    Button buttonTicTacToePvC;
    TextView textViewScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe__welcome_screen);
        buttonTicTacToePvP = findViewById(R.id.btn_tictactoePvP);
        buttonTicTacToePvC=findViewById(R.id.btn_tictactoePvC);
        textViewScore = findViewById(R.id.textViewScore);
        buttonTicTacToePvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicTacToe_WelcomeScreen.this, TicTacToe_ColorSelection_Activity.class);
                intent.putExtra("type_of_game","PvP");
                if(intent.resolveActivity(getPackageManager())!=null){
                    TicTacToe_WelcomeScreen.this.startActivity(intent);
                }
            }
        });
        buttonTicTacToePvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicTacToe_WelcomeScreen.this, TicTacToe_ColorSelection_Activity.class);
                intent.putExtra("type_of_game","PvC");
                if(intent.resolveActivity(getPackageManager())!=null){
                    TicTacToe_WelcomeScreen.this.startActivity(intent);
                }
            }
        });
        String s = getString(R.string.score) + "  "  + WelcomeScreenActivity.global_score;
        textViewScore.setText(s);

    }

}
