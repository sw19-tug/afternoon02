package com.example.ultimategames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameHangman extends AppCompatActivity {

    private int move_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hangman);
    }
}
