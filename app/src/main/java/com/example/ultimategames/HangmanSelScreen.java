package com.example.ultimategames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HangmanSelScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman_sel_screen);

        Button playHMBtn = findViewById(R.id.playHMBtn);
        final Intent playHangman = new Intent(this, GameHangman.class);

        playHMBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(playHangman);
            }
        });
        //New comment
    }



}
