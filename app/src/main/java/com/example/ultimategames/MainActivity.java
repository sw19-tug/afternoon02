package com.example.ultimategames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.TicTacToe.TicTacToe_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, TicTacToe_Activity.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            MainActivity.this.startActivity(intent);
        }
    }
}
