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

        Button btn = (Button)findViewById(R.id.bt_block);

        ViewGroup.LayoutParams params = btn.getLayoutParams();
        params.height = height/2;
        params.width = width/2;
        btn.setLayoutParams(params);



        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                RelativeLayout gameLayout =  findViewById(R.id.Rel_Backround);
                int Layoutwidth  = gameLayout.getWidth();
                int Layoutheight = gameLayout.getHeight();

                Button btn = (Button)v ;
                Random buttonPlace = new Random();
                // Random Number in Bound
                int buttonY = buttonPlace.nextInt(Layoutwidth-btn.getWidth());
                int buttonX = buttonPlace.nextInt(Layoutheight-btn.getHeight());
                btn.setX(buttonX);
                btn.setY(buttonY);
            }
        });



    }
}
