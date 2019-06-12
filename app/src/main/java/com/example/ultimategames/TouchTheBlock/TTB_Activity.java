package com.example.ultimategames.TouchTheBlock;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.example.ultimategames.R;
import com.example.ultimategames.WelcomeScreenActivity;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

import java.util.Random;
import java.text.DecimalFormat;

public class TTB_Activity extends AppCompatActivity {

    final double time_to_react = 3.0;

    RelativeLayout rel_Backround;

    int btnColor;

    public int testcounter = 0;
    private TextView countDown;
    private TextView score;

    public double time = time_to_react;

    boolean gameover = false;
    boolean restart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the game activity content view!
        setContentView(R.layout.touchtheblock);
        countDown = findViewById(R.id.countdown_text);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);

        final Button btn_block = (Button) findViewById(R.id.bt_block);
        final FloatingActionButton btn_restart = (FloatingActionButton) findViewById(R.id.bt_Restart);
        rel_Backround = (RelativeLayout) findViewById(R.id.Rel_Backround);

        score = findViewById(R.id.TTB_score);
        score.setText(R.string.score + WelcomeScreenActivity.global_score);


        btn_block.setBackgroundColor(Color.BLACK);

        ViewGroup.LayoutParams params = btn_block.getLayoutParams();
        params.height = height / 2;
        params.width = width / 2;
        btn_block.setLayoutParams(params);

        btn_restart.setVisibility(View.INVISIBLE);


        btn_block.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (!gameover) {
                    time = time_to_react;
                    resizeBtn(v);
                    realignBtn(v);
                    addPoints();
                    WelcomeScreenActivity.global_score ++;
                    score.setText(R.string.score + WelcomeScreenActivity.global_score);
                }
            }
        });

        btn_restart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (gameover) {
                    reStart();
                }
            }
        });


        rel_Backround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameOver();
                btn_restart.setVisibility(View.VISIBLE);
            }
        });

        final FloatingActionButton btnColor = findViewById(R.id.bt_changeColor);

        btnColor.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencolorpicker();
            }
        });
    }


    private void opencolorpicker() {

        final ColorPicker cp = new ColorPicker(this);

        cp.show();

        Button okColor = (Button)cp.findViewById(R.id.okColorButton);

        okColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnColor = cp.getColor();
                final Button btn = (Button)findViewById(R.id.bt_block);
                btn.setBackgroundColor(btnColor);

                cp.dismiss();
            }
        });
        timer();
    }

    public void realignBtn(View v){
        RelativeLayout gameLayout =  findViewById(R.id.Rel_Backround);
        int Layoutwidth  = gameLayout.getWidth();
        int Layoutheight = gameLayout.getHeight();

        Button btn = (Button) v;
        Random buttonPlace = new Random();
        // Random Number in Bound
        int buttonX = buttonPlace.nextInt(Layoutwidth - btn.getWidth());
        int buttonY = buttonPlace.nextInt(Layoutheight - btn.getHeight());
        btn.setX(buttonX);
        btn.setY(buttonY);
    }

    public void resizeBtn(View v) {
        Button btn = (Button) v;

        ViewGroup.LayoutParams params = btn.getLayoutParams();
        params.height = btn.getHeight() / 2;
        params.width = btn.getWidth() / 2;
        btn.setLayoutParams(params);
        testcounter++;
    }

    public void addPoints() {

        testcounter += 5;
    }

    public void deductPoints() {

        testcounter -= 5;
    }

    public void reStart() {
        //TextView tvScore = (TextView) findViewById(R.id.text_score);
        int global_score = WelcomeScreenActivity.global_score;
        if (global_score <= 10) {
            Toast.makeText(getApplicationContext(),R.string.not_enough_points ,Toast.LENGTH_LONG).show();
            return;
        }
        else {
            WelcomeScreenActivity.global_score = global_score - 10;

            this.recreate();
        }

    }

    public void timer() {

        countDown = findViewById(R.id.countdown_text);

        new CountDownTimer(30000, 10) {
            public void onTick(long millisUntilFinished) {
                DecimalFormat df = new DecimalFormat("#.##");
                countDown.setText(String.valueOf(df.format(time)));
                time = time - 0.01;
                double timer_buffer = time;
                if (Math.abs(timer_buffer - 1.0) <= 0.01) {
                    MediaPlayer ring = MediaPlayer.create(TTB_Activity.this, R.raw.bing_sound);
                    ring.start();
                    TextView txtView = (TextView) findViewById(R.id.textView);
                }
                if (time < 0.0) {
                    gameOver();
                    return;
                }
            }

            public void onFinish() {
                countDown.setText("You lost");
            }
        }.start();
    }

    public void gameOver() {
        final Button btn = (Button) findViewById(R.id.bt_block);
        btn.setBackgroundColor(Color.RED);
        deductPoints();
        TextView txtView = (TextView) findViewById(R.id.textView);
        txtView.setText(R.string.lostTTB);
        time = 0.0;
        gameover = true;
    }
}