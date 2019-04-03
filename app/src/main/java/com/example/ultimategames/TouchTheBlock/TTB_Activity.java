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

import com.example.ultimategames.R;

import java.util.Random;

public class TTB_Activity extends AppCompatActivity {

    RelativeLayout rel_Backround;

    int testcounter = 0;

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
        // Todo: Make Layout Ready and set on Click Listener to Block and to the game canvas

        final Button btn = (Button)findViewById(R.id.bt_block);

        btn.setBackgroundColor(Color.GREEN);

        ViewGroup.LayoutParams params = btn.getLayoutParams();
        params.height = height/2;
        params.width = width/2;
        btn.setLayoutParams(params);


        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                resizeBtn(v);
                realignBtn(v);

            }
        });

        rel_Backround = (RelativeLayout) findViewById (R.id.Rel_Backround);

        rel_Backround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setBackgroundColor(Color.RED);
                final Button btn = (Button)findViewById(R.id.bt_block);
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
}