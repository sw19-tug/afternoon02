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

    private String character_one, character_two, color_one, color_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe__color_selection_);
        Spinner signSpinner = (Spinner) findViewById(R.id.sign_spinner);
        Spinner colorSpinner = (Spinner) findViewById(R.id.color_spinner);
        Button buttonContinue = (Button) findViewById(R.id.buttonContinue);



        List<String> signCategories = new ArrayList<String>();
        List<String> colorCategories = new ArrayList<String>();

        colorCategories.add ("Blue");
        colorCategories.add ("Red");

        signCategories.add("X");
        signCategories.add("O");

        ArrayAdapter<String> signAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, signCategories);
        signAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        signSpinner.setAdapter(signAdapter);

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colorCategories);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);


        signSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                character_one = parent.getItemAtPosition(position).toString();
                character_two = parent.getItemAtPosition((position + 1)%parent.getCount()).toString();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                character_one = arg0.getItemAtPosition(0).toString();
                character_two = arg0.getItemAtPosition(1).toString();
            }
        });


        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color_one = parent.getItemAtPosition(position).toString();
                color_two = parent.getItemAtPosition((position + 1)%parent.getCount()).toString();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                color_one = arg0.getItemAtPosition(0).toString();
                color_two = arg0.getItemAtPosition(1).toString();
            }
        });



        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String activity = getIntent().getStringExtra("type_of_game");
                if(activity.equals("PvP")){
                    Intent intent = new Intent(TicTacToe_ColorSelection_Activity.this, TicTacToePvP_Activity.class);
                    if(intent.resolveActivity(getPackageManager())!=null){

                        String[] strings = {character_one, character_two};
                        intent.putExtra("characters",strings);

                        String[] colors = {color_one, color_two};
                        intent.putExtra("colors",colors);
                        intent.putExtra("invokedFromActivity",true);
                        TicTacToe_ColorSelection_Activity.this.startActivity(intent);
                    }

                }
                else if(activity.equals("PvC")){
                    Intent intent = new Intent(TicTacToe_ColorSelection_Activity.this, PvC.class);
                    if(intent.resolveActivity(getPackageManager())!=null){

                        String[] strings = {character_one, character_two};
                        intent.putExtra("characters",strings);

                        String[] colors = {color_one, color_two};
                        intent.putExtra("colors",colors);

                        TicTacToe_ColorSelection_Activity.this.startActivity(intent);
                    }
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

