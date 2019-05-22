package com.example.ultimategames.TouchTheBlock;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ultimategames.MainActivity;
import com.example.ultimategames.R;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

import java.util.ArrayList;
import java.util.Random;

//import petrov.kristiyan.colorpicker.ColorPicker;

public class TTB_Activity extends AppCompatActivity {

    RelativeLayout rel_Backround;

    int btnColor;

    public int testcounter = 0;

    boolean gameover = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the game activity content view!
        setContentView(R.layout.touchtheblock);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);

        final Button btn = (Button)findViewById(R.id.bt_block);

        btn.setBackgroundColor(Color.BLACK);

        ViewGroup.LayoutParams params = btn.getLayoutParams();
        params.height = height/2;
        params.width = width/2;
        btn.setLayoutParams(params);


        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                if(!gameover)
                {
                    resizeBtn(v);
                    realignBtn(v);
                    addPoints();
                }
            }
        });

        rel_Backround = (RelativeLayout) findViewById (R.id.Rel_Backround);

        rel_Backround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setBackgroundColor(Color.RED);
                final Button btn = (Button)findViewById(R.id.bt_block);
                deductPoints();
                TextView txtView = (TextView)findViewById(R.id.textView);
                String hello = "Sorry you lost!";
                txtView.setText(hello);
                gameover = true;
            }
        });


        final Button btnColor = (Button)findViewById(R.id.bt_changeColor);

        btnColor.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencolorpicker();
            }
        });




    }

    private void opencolorpicker() {
        // source: https://stackoverflow.com/questions/6980906/android-color-picker

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
    }

    public void realignBtn(View v){
        RelativeLayout gameLayout =  findViewById(R.id.Rel_Backround);
        int Layoutwidth  = gameLayout.getWidth();
        int Layoutheight = gameLayout.getHeight();

        Button btn = (Button)v;
        Random buttonPlace = new Random();
        // Random Number in Bound
        int buttonX = buttonPlace.nextInt(Layoutwidth-btn.getWidth());
        int buttonY = buttonPlace.nextInt(Layoutheight-btn.getHeight());
        btn.setX(buttonX);
        btn.setY(buttonY);
    }
    public void resizeBtn(View v)
    {
        Button btn = (Button)v;

        ViewGroup.LayoutParams params = btn.getLayoutParams();
        params.height = btn.getHeight()/2;
        params.width = btn.getWidth()/2;
        btn.setLayoutParams(params);
        testcounter++;
    }


    public void addPoints(){

        testcounter += 5;
    }

    public void deductPoints(){

        testcounter -= 5;
    }
}