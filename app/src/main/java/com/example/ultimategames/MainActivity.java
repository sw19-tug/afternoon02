package com.example.ultimategames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ultimategames.TouchTheBlock.TTB_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /// Just for Testing feature 11
        /// Move diretly to the TTB Activity!
        Intent inent = new Intent(this, TTB_Activity.class);
        startActivity(inent);
    }
}