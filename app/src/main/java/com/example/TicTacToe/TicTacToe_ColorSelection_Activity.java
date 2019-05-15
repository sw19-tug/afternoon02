package com.example.TicTacToe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.ultimategames.R;

public class TicTacToe_ColorSelection_Activity extends AppCompatActivity implements OnItemSelectedListener{

    private String character_one, character_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe__color_selection_); // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button buttonContinue = (Button) findViewById(R.id.buttonContinue);


        spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("X");
        categories.add("O");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicTacToe_ColorSelection_Activity.this, PvC.class);
                if(intent.resolveActivity(getPackageManager())!=null){
                    String[] strings = {character_one, character_two};
                    intent.putExtra("characters",strings);
                    TicTacToe_ColorSelection_Activity.this.startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        character_one = parent.getItemAtPosition(position).toString();
        character_two = parent.getItemAtPosition((position + 1)%parent.getCount()).toString();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        character_one = arg0.getItemAtPosition(0).toString();
        character_two = arg0.getItemAtPosition(1).toString();
    }


}

