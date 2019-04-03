package com.example.ultimategames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import java.util.Dictionary;
import java.util.HashMap;

public class GameHangman extends AppCompatActivity implements View.OnClickListener {

    private int move_count = 0;

    private Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM,
                   btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;

    private HashMap<Integer, String> keyvalues = new HashMap<Integer, String>(26);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hangman);

        initButtons();
    }

    @Override
    public void onClick(View view) {
        // Apparently button IDs are not guaranteed to be constant at runtime, that's why
        // if statements are recommended over switch case

        int id = view.getId();
        Button clicked = findViewById(id);

        if (id == R.id.button_a) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_b) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_c) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_d) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_e) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_f) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_g) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_h) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_i) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_j) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_k) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_l) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_m) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_n) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_o) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_p) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_q) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_r) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_s) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_t) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_u) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_v) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_w) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_x) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_y) {
            clicked.setEnabled(false);
        } else if (id == R.id.button_z) {
            clicked.setEnabled(false);
        }

        Log.d("MYLOG", "Button Clicked "+keyvalues.get(id));
    }

    private void initButtons()
    {
        btnA = findViewById(R.id.button_a);
        btnA.setOnClickListener(this);
        btnB = findViewById(R.id.button_b);
        btnB.setOnClickListener(this);
        btnC = findViewById(R.id.button_c);
        btnC.setOnClickListener(this);
        btnD = findViewById(R.id.button_d);
        btnD.setOnClickListener(this);
        btnE = findViewById(R.id.button_e);
        btnE.setOnClickListener(this);
        btnF = findViewById(R.id.button_f);
        btnF.setOnClickListener(this);
        btnG = findViewById(R.id.button_g);
        btnG.setOnClickListener(this);
        btnH = findViewById(R.id.button_h);
        btnH.setOnClickListener(this);
        btnI = findViewById(R.id.button_i);
        btnI.setOnClickListener(this);
        btnJ = findViewById(R.id.button_j);
        btnJ.setOnClickListener(this);
        btnK = findViewById(R.id.button_k);
        btnK.setOnClickListener(this);
        btnL = findViewById(R.id.button_l);
        btnL.setOnClickListener(this);
        btnM = findViewById(R.id.button_m);
        btnM.setOnClickListener(this);
        btnN = findViewById(R.id.button_n);
        btnN.setOnClickListener(this);
        btnO = findViewById(R.id.button_o);
        btnO.setOnClickListener(this);
        btnP = findViewById(R.id.button_p);
        btnP.setOnClickListener(this);
        btnQ = findViewById(R.id.button_q);
        btnQ.setOnClickListener(this);
        btnR = findViewById(R.id.button_r);
        btnR.setOnClickListener(this);
        btnS = findViewById(R.id.button_s);
        btnS.setOnClickListener(this);
        btnT = findViewById(R.id.button_t);
        btnT.setOnClickListener(this);
        btnU = findViewById(R.id.button_u);
        btnU.setOnClickListener(this);
        btnV = findViewById(R.id.button_v);
        btnV.setOnClickListener(this);
        btnW = findViewById(R.id.button_w);
        btnW.setOnClickListener(this);
        btnX = findViewById(R.id.button_x);
        btnX.setOnClickListener(this);
        btnY = findViewById(R.id.button_y);
        btnY.setOnClickListener(this);
        btnZ = findViewById(R.id.button_z);
        btnZ.setOnClickListener(this);

        keyvalues.put(R.id.button_a, "A");
        keyvalues.put(R.id.button_b, "B");
        keyvalues.put(R.id.button_c, "C");
        keyvalues.put(R.id.button_d, "D");
        keyvalues.put(R.id.button_e, "E");
        keyvalues.put(R.id.button_f, "F");
        keyvalues.put(R.id.button_g, "G");
        keyvalues.put(R.id.button_h, "H");
        keyvalues.put(R.id.button_i, "I");
        keyvalues.put(R.id.button_j, "J");
        keyvalues.put(R.id.button_k, "K");
        keyvalues.put(R.id.button_l, "L");
        keyvalues.put(R.id.button_m, "M");
        keyvalues.put(R.id.button_n, "N");
        keyvalues.put(R.id.button_o, "O");
        keyvalues.put(R.id.button_p, "P");
        keyvalues.put(R.id.button_q, "Q");
        keyvalues.put(R.id.button_r, "R");
        keyvalues.put(R.id.button_s, "S");
        keyvalues.put(R.id.button_t, "T");
        keyvalues.put(R.id.button_u, "U");
        keyvalues.put(R.id.button_v, "V");
        keyvalues.put(R.id.button_w, "W");
        keyvalues.put(R.id.button_x, "X");
        keyvalues.put(R.id.button_y, "Y");
        keyvalues.put(R.id.button_z, "Z");
    }
}
