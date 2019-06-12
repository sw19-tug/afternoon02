package com.example.ultimategames;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.TicTacToe.TicTacToe_WelcomeScreen;
import com.example.ultimategames.TouchTheBlock.TTB_Activity;

public class WelcomeScreenActivity extends AppCompatActivity {

    public static int global_score = 0;


    Button buttonTicTacToe;
    Button buttonHangman;
    Button buttonTouchBlock;
    TextView buttonlanguage;

    Button buttonEnglish;
    Button buttonGerman;
    Button buttoncancel;

    LinearLayout languagemenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        buttonTicTacToe = findViewById(R.id.btn_tictactoe);
        buttonHangman = findViewById(R.id.btn_hangman);
        buttonTouchBlock = findViewById(R.id.btn_block);
        buttonlanguage = findViewById(R.id.btn_languagesetter);

        languagemenu = findViewById(R.id.languagemenu);
        buttonEnglish = findViewById(R.id.btn_englishlanguage);
        buttonGerman = findViewById(R.id.btn_germanlanguage);
        buttoncancel = findViewById(R.id.btn_languagecancel);

        final Context context = this;



        buttonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreenActivity.this, TicTacToe_WelcomeScreen.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    WelcomeScreenActivity.this.startActivity(intent);
                }
            }
        });

        buttonHangman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreenActivity.this, HangmanSelScreen.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    WelcomeScreenActivity.this.startActivity(intent);
                }
            }
        });

        buttonTouchBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreenActivity.this, TTB_Activity.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    WelcomeScreenActivity.this.startActivity(intent);
                }
            }
        });

        buttonlanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languagemenu.setVisibility(View.VISIBLE);
                languagemenu.setClickable(true);
            }
        });

        buttonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale myLocale = new Locale("en");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(context, WelcomeScreenActivity.class);
                startActivity(refresh);
                finish();
            }
        });

        buttonGerman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale myLocale = new Locale("de");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(context, WelcomeScreenActivity.class);
                startActivity(refresh);
                finish();
            }
        });

        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languagemenu.setVisibility(View.GONE);
            }
        });



        UpdateScore();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        UpdateScore();
    }

    private void UpdateScore()
    {
        TextView tvScore = (TextView) findViewById(R.id.text_score);
        String textScore = Integer.toString(global_score);

        tvScore.setText(textScore);
    }
}
