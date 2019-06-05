package com.example.ultimategames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;

public class GameHangman extends AppCompatActivity implements View.OnClickListener {

    private Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM,
                   btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;

    private HashMap<Integer, String> keyvalues = new HashMap<Integer, String>(26);
    private HangmanLogic hangman_logic;
    private DatabaseHelper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hangman);

        database_helper = new DatabaseHelper(this);
        hangman_logic = new HangmanLogic(this, database_helper);

        initButtons();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Button clicked = findViewById(id);
        clicked.setEnabled(false);
        hangman_logic.checkLetter(keyvalues.get(id));
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

    public void ResetView()
    {
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        btnG.setEnabled(true);
        btnH.setEnabled(true);
        btnI.setEnabled(true);
        btnJ.setEnabled(true);
        btnK.setEnabled(true);
        btnL.setEnabled(true);
        btnM.setEnabled(true);
        btnN.setEnabled(true);
        btnO.setEnabled(true);
        btnP.setEnabled(true);
        btnQ.setEnabled(true);
        btnR.setEnabled(true);
        btnS.setEnabled(true);
        btnT.setEnabled(true);
        btnU.setEnabled(true);
        btnV.setEnabled(true);
        btnW.setEnabled(true);
        btnX.setEnabled(true);
        btnY.setEnabled(true);
        btnZ.setEnabled(true);
    }

    public void CreateWordView(int length)
    {
        LinearLayout word = findViewById(R.id.word);

        // Remove existing TextViews
        word.removeAllViews();

        // Create new TextViews
        for (int i = 0; i < length; i++)
        {
            TextView letter = (TextView)getLayoutInflater().inflate(R.layout.character_textview_template, null);
            letter.setPadding(dpToPx(2), 0, dpToPx(2), 0);
            word.addView(letter);
        }
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public void ShowLetterAtPosition(String letter, int position)
    {
        LinearLayout word = findViewById(R.id.word);
        TextView character = (TextView)word.getChildAt(position);
        character.setText(letter);
    }

    public void UpdateStats(int score, int wrong)
    {
        TextView tvScore = (TextView) findViewById(R.id.hangman_score);
        TextView tvWrong = (TextView) findViewById(R.id.hangman_wrong);
        String textScore = Integer.toString(score);
        String textWrong = Integer.toString(wrong);
        tvScore.setText(textScore);
        tvWrong.setText(textWrong);
    }

    public void Win()
    {
        Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
    }

    public void Lose()
    {
        Toast.makeText(this, "You lose!", Toast.LENGTH_SHORT).show();
    }
}
