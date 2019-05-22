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

import com.example.ultimategames.R;

import java.util.ArrayList;
import java.util.Random;

//import petrov.kristiyan.colorpicker.ColorPicker;

public class TTB_Activity extends AppCompatActivity {

    RelativeLayout rel_Backround;

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

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencolorpicker();
            }
        });




    }

    private void opencolorpicker() {





        //final ColorPicker colorPicker = new ColorPicker(this);
        ArrayList<String> colors = new ArrayList<>();
        colors.add("#1A8B81");
        colors.add("#FFFFFF");
        colors.add("#000000");
        colors.add("#3F51B5");
        colors.add("#F44336");
        colors.add("#4CAF50");
        colors.add("#FFC107");
        colors.add("#FF5722");





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