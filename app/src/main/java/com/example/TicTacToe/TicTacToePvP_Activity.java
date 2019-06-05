package com.example.TicTacToe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ultimategames.R;

import org.w3c.dom.Text;

public class TicTacToePvP_Activity extends AppCompatActivity {
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
    TextView resultTextView;
    Button restartGame;
    String[] strings,colors;
    int[] color_ints = {0,0};
    static int score_player_one;
    static int score_player_two;
    int switchPlayer = 1;
    boolean invokedFromActivity=false;
    TicTacToe ticTacToe = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe_pvp);
        strings = getIntent().getStringArrayExtra("characters");
        colors = getIntent().getStringArrayExtra("colors");
        invokedFromActivity=getIntent().getBooleanExtra("invokedFromActivity", false);
        color_ints[0] = getResources().getColor(getResources().getIdentifier(colors[0],"color",getPackageName()));
        color_ints[1] = getResources().getColor(getResources().getIdentifier(colors[1],"color",getPackageName()));
        restartGame = findViewById(R.id.restartGame);
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
        resultTextView = findViewById(R.id.score);
        resultTextView.setText(score_player_one+":"+score_player_two);
        if(invokedFromActivity && (score_player_two!=0 || score_player_one!=0)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setMessage("Would you like to restart the game?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score_player_two = 0;
                            score_player_one = 0;
                            getIntent().putExtra("invokedFromActivity",false);
                            startActivity(getIntent());
                            finish();
                            overridePendingTransition(0,0);
                        }
                    });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        textView00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView00.setClickable(false);
                int resultOfGame = ticTacToe.changeField(0,0,switchPlayer);
                textView00.setText(strings[switchPlayer-1]);
                textView00.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView01.setClickable(false);
                int resultOfGame = ticTacToe.changeField(0,1,switchPlayer);
                textView01.setText(strings[switchPlayer-1]);
                textView01.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView02.setClickable(false);
                int resultOfGame = ticTacToe.changeField(0,2,switchPlayer);
                textView02.setText(strings[switchPlayer-1]);
                textView02.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView10.setClickable(false   );
                int resultOfGame = ticTacToe.changeField(1,0,switchPlayer);
                textView10.setText(strings[switchPlayer-1]);
                textView10.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView11.setClickable(false);
                int resultOfGame = ticTacToe.changeField(1,1,switchPlayer);
                textView11.setText(strings[switchPlayer-1]);
                textView11.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView12.setClickable(false);
                int resultOfGame = ticTacToe.changeField(1,2,switchPlayer);
                textView12.setText(strings[switchPlayer-1]);
                textView12.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView20.setClickable(false);
                int resultOfGame = ticTacToe.changeField(2,0,switchPlayer);
                textView20.setText(strings[switchPlayer-1]);
                textView20.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView21.setClickable(false);
                int resultOfGame = ticTacToe.changeField(2,1,switchPlayer);
                textView21.setText(strings[switchPlayer-1]);
                textView21.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        textView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView22.setClickable(false);
                int resultOfGame = ticTacToe.changeField(2,2,switchPlayer);
                textView22.setText(strings[switchPlayer-1]);
                textView22.setTextColor(color_ints[switchPlayer-1]);
                switchPlayer = 3 - switchPlayer;
                processEndOfTheGame(resultOfGame);
            }
        });

        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getIntent().putExtra("invokedFromActivity",false);
                startActivity(getIntent());
                finish();
                overridePendingTransition(0,0);
            }
        });


    }

    private void processEndOfTheGame(int result_of_game){
        if(result_of_game == 1){
            score_player_one++;
            restartGame.setVisibility(View.VISIBLE);
            result.setText(R.string.playerOneWon);
            removeListeners();
        }
        else if(result_of_game == 2){
            score_player_two++;
            restartGame.setVisibility(View.VISIBLE);
            result.setText(R.string.playerTwoWon);
            removeListeners();
        }
        else if(result_of_game == 0){
            restartGame.setVisibility(View.VISIBLE);
            result.setText(R.string.draw);
            removeListeners();
        }
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
