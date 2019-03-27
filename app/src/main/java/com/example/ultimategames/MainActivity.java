package com.example.ultimategames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.TicTacToe.PvC;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, PvC.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
