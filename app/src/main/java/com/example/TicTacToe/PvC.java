package com.example.TicTacToe;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultimategames.R;
import com.example.ultimategames.WelcomeScreenActivity;

import java.util.Random;

public class PvC extends AppCompatActivity {

    TextView b00, b01, b02, b10, b11, b12, b20, b21, b22 = null;
    TextView box[] = new TextView[9];
    TicTacToe ticTacToe = new TicTacToe();
    int index_lock[] = {0,0,0,0,0,0,0,0,0};

    int player = 1;

    String[] signs, colors;
    int[] color_ints = {0,0};
    int result;

    TextView result_text;

    TextView textViewScore;

    Button restartGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoepvc);
        textViewScore = findViewById(R.id.textViewScore);
        String s = getString(R.string.score) + "  "  + WelcomeScreenActivity.global_score;
        textViewScore.setText(s);

        signs = getIntent().getStringArrayExtra("characters");
        colors = getIntent().getStringArrayExtra("colors");
        color_ints[0] = getResources().getColor(getResources().getIdentifier(colors[0],"color",getPackageName()));
        color_ints[1] = getResources().getColor(getResources().getIdentifier(colors[1],"color",getPackageName()));
        result_text = findViewById(R.id.result);

        restartGame = findViewById(R.id.restartGame);
        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(getIntent());
                finish();
                overridePendingTransition(0,0);
            }
        });

        b00 = findViewById(R.id.b00);
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (index_lock[0] == 0) {
                    b00.setText(signs[player-1]);
                    b00.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(0,0, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[0] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b01 = findViewById(R.id.b01);
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (index_lock[1] == 0) {
                    b01.setText(signs[player-1]);
                    b01.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(0,1, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[1] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b02 = findViewById(R.id.b02);
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[2] == 0) {
                    b02.setText(signs[player-1]);
                    b02.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(0,2, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[2] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b10 = findViewById(R.id.b10);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[3] == 0) {
                    b10.setText(signs[player-1]);
                    b10.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(1,0, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[3] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b11 = findViewById(R.id.b11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[4] == 0) {
                    b11.setText(signs[player-1]);
                    b11.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(1,1, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[4] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b12 = findViewById(R.id.b12);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[5] == 0) {
                    b12.setText(signs[player-1]);
                    b12.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(1,2, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[5] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b20 = findViewById(R.id.b20);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[6] == 0) {
                    b20.setText(signs[player-1]);
                    b20.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(2,0, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[6] = 1;
                    result = Computer_Turn(false, 0, 0);
                    Show_Result(result);
                }
            }
        });

        b21 = findViewById(R.id.b21);
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[7] == 0) {
                    b21.setText(signs[player-1]);
                    b21.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(2,1, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[7] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        b22 = findViewById(R.id.b22);
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[8] == 0) {
                    b22.setText(signs[player-1]);
                    b22.setTextColor(color_ints[0]);
                    result = ticTacToe.changeField(2,2, player);
                    Show_Result(result);
                    if(result != -1){
                        return;
                    }
                    player = 3 - player;
                    index_lock[8] = 1;
                    result = Computer_Turn(false, 0, 0);
                    if(result!=3) Show_Result(result);
                }
            }
        });

        box[0] = b00;
        box[1] = b01;
        box[2] = b02;
        box[3] = b10;
        box[4] = b11;
        box[5] = b12;
        box[6] = b20;
        box[7] = b21;
        box[8] = b22;
    }

    public void Assign_Sign_Player () {

    }

    public int Computer_Turn (boolean test, int a, int b) {

        if (test) {
            index_lock[a] = 1;
            index_lock[b] = 1;
        }

        int i = 0;
        int j = 0;
        boolean found = false;


        Random rand = new Random();


        while (true) {
            i = rand.nextInt(8);
            boolean isLast=true;
            for (int counter =0;counter<9;counter++){
                if(index_lock[counter]==0){
                    isLast=false;
                    break;
                }
            }
            if(isLast) return 3;
            if (index_lock[i] == 0) {
                break;
            }
        }
        index_lock[i] = 1;



        int x = 0, y = 0;

        if (i <= 2) {
            x = 0;
        }
        else if (i <= 5) {
            x = 1;
        }
        else if (i <= 8) {
            x = 2;
        }

        if (i % 3 == 0) {
            y = 0;
        }
        if (i % 3 == 1) {
            y = 1;
        }
        if (i % 3 == 2) {
            y = 2;
        }
        box[i].setText(signs[player-1]);
        box[i].setTextColor(color_ints[1]);
        int r = ticTacToe.changeField(x, y, player);
        player = 3 - player;
        return r;

    }
    void Show_Result (int result) {
        if (result == 0) {
            restartGame.setVisibility(View.VISIBLE);
            result_text.setText(R.string.draw);
        }
        if (result == 1) {
            restartGame.setVisibility(View.VISIBLE);
            result_text.setText(R.string.playerWon);
            WelcomeScreenActivity.global_score=WelcomeScreenActivity.global_score + 2;
        }
        if (result == 2) {
            restartGame.setVisibility(View.VISIBLE);
            result_text.setText(R.string.computerWon);
            WelcomeScreenActivity.global_score--;
        }

        String s = getString(R.string.score) + "  "  + WelcomeScreenActivity.global_score;
        textViewScore.setText(s);
    }
}
