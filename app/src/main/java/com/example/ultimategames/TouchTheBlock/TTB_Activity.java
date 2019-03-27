package com.example.ultimategames.TouchTheBlock;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.Button;
import android.graphics.Color;

import com.example.ultimategames.R;

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

        /*Button button = new Button(this);


        button.setWidth(10);
        button.setHeight(100);


        mMenuContainer.addView(button, mMenuItemLayoutParamters);*/


    }
}
