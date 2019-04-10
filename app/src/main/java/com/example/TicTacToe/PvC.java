package com.example.TicTacToe;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultimategames.R;

import java.util.Random;

public class PvC extends AppCompatActivity {

    TextView b00, b01, b02, b10, b11, b12, b20, b21, b22 = null;
    TextView box[] = new TextView[9];
    TicTacToe ticTacToe = new TicTacToe();
    int index_lock[] = {0,0,0,0,0,0,0,0,0};

    int player = 1;

    String[] signs = {"X","O"};

    int result;

    TextView result_text;

    Button restartGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoepvc);

        result_text = findViewById(R.id.result);

        Assign_Sign_Player();

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
                    result = ticTacToe.changeField(0,0, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[0] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b01 = findViewById(R.id.b01);
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (index_lock[1] == 0) {
                    b01.setText(signs[player-1]);
                    result = ticTacToe.changeField(1,0, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[1] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b02 = findViewById(R.id.b02);
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[2] == 0) {
                    b02.setText(signs[player-1]);
                    result = ticTacToe.changeField(2,0, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[2] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b10 = findViewById(R.id.b10);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[3] == 0) {
                    b10.setText(signs[player-1]);
                    result = ticTacToe.changeField(1,0, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[3] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b11 = findViewById(R.id.b11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[4] == 0) {
                    b11.setText(signs[player-1]);
                    result = ticTacToe.changeField(1,1, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[4] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b12 = findViewById(R.id.b12);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[5] == 0) {
                    b12.setText(signs[player-1]);
                    result = ticTacToe.changeField(1,2, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[5] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b20 = findViewById(R.id.b20);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[6] == 0) {
                    b20.setText(signs[player-1]);
                    result = ticTacToe.changeField(2,0, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[6] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b21 = findViewById(R.id.b21);
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[7] == 0) {
                    b21.setText(signs[player-1]);
                    result = ticTacToe.changeField(2,1, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[7] = 1;
                    Computer_Turn(false, 0, 0);
                }
            }
        });

        b22 = findViewById(R.id.b22);
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index_lock[8] == 0) {
                    b22.setText(signs[player-1]);
                    result = ticTacToe.changeField(2,2, player);
                    Show_Result(result);
                    player = 3 - player;
                    index_lock[8] = 1;
                    Computer_Turn(false, 0, 0);
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

        signs[0] = "X";
        signs[1] = "0";
    }

    public int Computer_Turn (boolean test, int a, int b) {

        if (test) {
            index_lock[a] = 1;
            index_lock[b] = 1;
        }

        int i = 0;
        int j = 0;
        boolean found = false;

        /*
        // Horizontal
        while (true) {
            if (j == 9) {
                break;
            }
            if (index_lock[j] == 1 && index_lock[j + 1] == 1) {
                i = j + 2;
                found = true;
                break;
            }
            j += 3;
        }

        j = 0;
        while (true) {
            if (j == 9) {
                break;
            }
            if (index_lock[j] == 1 && index_lock[j + 2] == 1) {
                i = j + 1;
                found = true;
                break;
            }
            j += 3;
        }
        j = 0;
        while (true) {
            if (j == 9) {
                break;
            }
            if (index_lock[j+1] == 1 && index_lock[j + 2] == 1) {
                i = j;
                found = true;
                break;
            }
            j += 3;
        }

        //Verticle
        j = 0;
        while (true) {
            if (j == 3) {
                break;
            }
            if (index_lock[j] == 1 && index_lock[j + 3*1] == 1) {
                i = j + 3*2;
                found = true;
                break;
            }
            j += 1;
        }
        j = 0;
        while (true) {
            if (j == 3) {
                break;
            }
            if (index_lock[j] == 1 && index_lock[j + 3*2] == 1) {
                i = j + 3*1;
                found = true;
                break;
            }
            j += 1;
        }
        j = 0;
        while (true) {
            if (j == 3) {
                break;
            }
            if (index_lock[j+3] == 1 && index_lock[j + 3*2] == 1) {
                i = j;
                found = true;
                break;
            }
            j += 1;
        }
        */
        if (found && test) {
            return i;
        }


        if (found == false) {
            Random rand = new Random();


            while (true) {
                i = rand.nextInt(8);
                if (index_lock[i] == 0) {
                    break;
                }
            }
            index_lock[i] = 1;
        }


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
        int r = ticTacToe.changeField(x, y, player);
        player = 3 - player;
        return r;
    }
    void Show_Result (int result) {

        if (result == -1) {
        }

        if (result == 0) {
            restartGame.setVisibility(View.VISIBLE);
            result_text.setText(R.string.draw);

        }

        if (result == 1) {
            restartGame.setVisibility(View.VISIBLE);
            result_text.setText(R.string.playerOneWon);
        }

        if (result == 2) {
            restartGame.setVisibility(View.VISIBLE);
            result_text.setText(R.string.playerTwoWon);
        }
    }
}
