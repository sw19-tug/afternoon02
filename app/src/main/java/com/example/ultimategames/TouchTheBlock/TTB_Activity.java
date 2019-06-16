package com.example.ultimategames.TouchTheBlock;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultimategames.R;
import com.example.ultimategames.WelcomeScreenActivity;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

import java.util.Random;
import java.text.DecimalFormat;

public class TTB_Activity extends AppCompatActivity {

    final double time_to_react = 3.0;

    RelativeLayout rel_Backround;

    int btn_Color,bg_color;

    int btnX,btnY;

    public int testcounter = 0;
    private TextView countDown;
    private TextView score;

    public double time = time_to_react;

    boolean gameover = false;
    boolean running = false;

    CountDownTimer Timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.touchtheblock);
        countDown = findViewById(R.id.countdown_text);

        btn_Color = 0;
        bg_color = 0;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        final Button btn_block = (Button) findViewById(R.id.bt_block);
        Intent intent2 = getIntent();
        int extras = intent2.getIntExtra("continueGame",0);
        if(getIntent().hasExtra("continueGame")){
            ViewGroup.LayoutParams params = btn_block.getLayoutParams();
            params.width = getIntent().getIntExtra("btnWidth",0);
            params.height = getIntent().getIntExtra("btnHeight",0);
            btn_block.setLayoutParams(params);
            btn_block.setX(getIntent().getFloatExtra("btnX",0));
            btn_block.setY(getIntent().getFloatExtra("btnY",0));
        }
        else{
            ViewGroup.LayoutParams params = btn_block.getLayoutParams();
            params.height = height / 2;
            params.width = width / 2;
            btn_block.setLayoutParams(params);
        }
        final FloatingActionButton btn_restart = (FloatingActionButton) findViewById(R.id.bt_Restart);
        final FloatingActionButton btn_continue = (FloatingActionButton) findViewById(R.id.bt_Continue);
        rel_Backround = (RelativeLayout) findViewById(R.id.Rel_Backround);

        score = findViewById(R.id.TTB_score);
        score.setText( getResources().getString(R.string.score) + " " + Integer.toString(WelcomeScreenActivity.global_score));


        btn_block.setBackgroundColor(Color.BLACK);



        btn_restart.setVisibility(View.INVISIBLE);
        btn_block.setVisibility(View.INVISIBLE);
        btn_continue.setVisibility(View.INVISIBLE);
        final FloatingActionButton btnColor = findViewById(R.id.bt_changeColor);
        final FloatingActionButton btnStart = findViewById(R.id.bt_Start);


        btn_block.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (!gameover) {
                    time = time_to_react;
                    resizeBtn(v);
                    realignBtn(v);
                    addPoints();
                    WelcomeScreenActivity.global_score += 1;
                    TextView tvScore = (TextView) findViewById(R.id.TTB_score);
                    String textScore =  getResources().getString(R.string.score) + " " + Integer.toString(WelcomeScreenActivity.global_score);

                    tvScore.setText(textScore);
                    Timer.start();

                }
            }
        });

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameover) {
                    reStart();
                }
            }
        });

        btn_continue.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int global_score = WelcomeScreenActivity.global_score;
                if (global_score <= 10) {
                    Toast.makeText(getApplicationContext(),R.string.restartTTB ,Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    WelcomeScreenActivity.global_score = global_score - 10;
                }
                Intent intent = getIntent();

                ViewGroup.LayoutParams params = btn_block.getLayoutParams();
                intent.putExtra("continueGame",1);
                intent.putExtra("btnWidth",params.width);
                intent.putExtra("btnHeight",params.height);
                intent.putExtra("btnX",btnX);
                intent.putExtra("btnY",btnY);
                if(intent.resolveActivity(getPackageManager())!=null){
                    TTB_Activity.this.startActivity(intent);
                }
            }
        });


        rel_Backround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    Timer.cancel();
                    gameOver();
                    btn_restart.setVisibility(View.VISIBLE);
                }
            }
        });


        btnColor.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencolorpicker();
            }
        });

        btnStart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.INVISIBLE);
                btn_block.setVisibility(View.VISIBLE);
                btnColor.setVisibility(View.INVISIBLE);
                btnColor.setVisibility(View.INVISIBLE);
                InitTimer();
                running = true;

            }
        });
    }


    private void opencolorpicker() {

        final ColorPicker cp = new ColorPicker(this);

        cp.show();


        Button okColorBlock = new Button(this);
        okColorBlock.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        okColorBlock.setY(600);
        okColorBlock.setX(460);
        okColorBlock.setText(R.string.change_block_color);

        RelativeLayout cpLayout = (RelativeLayout) cp.findViewById(R.id.okColorButton).getParent();

        Button okColorBg = new Button(this);
        okColorBg.setText(R.string.change_bg_color);
        okColorBg.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        okColorBg.setY(600);
        okColorBg.setX(-5);

        cp.findViewById(R.id.textView).setVisibility(View.INVISIBLE);
        cp.findViewById(R.id.okColorButton).setVisibility(View.INVISIBLE);
        cp.findViewById(R.id.codHex).setVisibility(View.INVISIBLE);
        cpLayout.setMinimumHeight(900);
        cpLayout.addView(okColorBg);
        cpLayout.addView(okColorBlock);

        okColorBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_Color == cp.getColor() || cp.getColor() == -1 && btn_Color == 0){
                    Toast.makeText(getApplicationContext(),getString(R.string.same_color),Toast.LENGTH_SHORT).show();
                    return;
                }
                btn_Color = cp.getColor();
                final Button btn = (Button)findViewById(R.id.bt_block);
                btn.setBackgroundColor(btn_Color);
                cp.dismiss();
            }
        });


        okColorBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bg_color == cp.getColor() || cp.getColor() == -16777216 && bg_color == 0){
                    Toast.makeText(getApplicationContext(),getString(R.string.same_color),Toast.LENGTH_SHORT).show();
                    return;
                }
                bg_color = cp.getColor();
                rel_Backround.setBackgroundColor(bg_color);

                cp.dismiss();
            }
        });
    }

    public void realignBtn(View v){
        RelativeLayout gameLayout =  findViewById(R.id.Rel_Backround);
        int Layoutwidth  = gameLayout.getWidth();
        int Layoutheight = gameLayout.getHeight();

        Button btn = (Button) v;
        Random buttonPlace = new Random();
        int buttonX = buttonPlace.nextInt(Layoutwidth - btn.getWidth());
        int buttonY = buttonPlace.nextInt(Layoutheight - btn.getHeight());
        btnX = buttonX;
        btnY = buttonY;
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
        getIntent().removeExtra("continueGame");
        this.recreate();
    }

    public void InitTimer() {

        countDown = findViewById(R.id.countdown_text);

        Timer = new CountDownTimer(3000, 10) {
            public void onTick(long millisUntilFinished) {
                DecimalFormat df = new DecimalFormat("#.##");
                countDown.setText(""+millisUntilFinished / 1000+ "." + millisUntilFinished%10);
                time = millisUntilFinished;
                if (millisUntilFinished <= 0.01) {
                    MediaPlayer ring = MediaPlayer.create(TTB_Activity.this, R.raw.bing_sound);
                    ring.start();
                    TextView txtView = (TextView) findViewById(R.id.textView);
                }
            }

            public void onFinish() {
                gameOver();
            }
        }.start();
    }

    public void gameOver() {
        final Button btn = (Button) findViewById(R.id.bt_block);
        final FloatingActionButton btn_restart = (FloatingActionButton) findViewById(R.id.bt_Restart);
        final FloatingActionButton btn_continue = (FloatingActionButton) findViewById(R.id.bt_Continue);
        btn_restart.setVisibility(View.VISIBLE);
        btn_continue.setVisibility(View.VISIBLE);
        countDown.setText(R.string.youLost);

        btn.setBackgroundColor(Color.RED);
        deductPoints();
        TextView txtView = (TextView) findViewById(R.id.textView);
        txtView.setText(R.string.lostTTB);
        time = 0.0;
        gameover = true;
    }
}