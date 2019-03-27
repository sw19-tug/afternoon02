package com.example.ultimategames.TouchTheBlock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.ultimategames.R;

public class TTB_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the game activity content view!
        setContentView(R.layout.touchtheblock);
        // Todo: Make Layout Ready and set on Click Listener to Block and to the game canvas
        Button butn = (Button)findViewById(R.id.bt_block);
        butn.setHeight(300);
        butn.setWidth(300);
    }
}
