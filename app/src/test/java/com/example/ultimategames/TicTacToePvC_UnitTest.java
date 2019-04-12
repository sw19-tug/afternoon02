package com.example.ultimategames;

import android.os.Debug;
import android.util.Log;

import com.example.TicTacToe.PvC;

public class TicTacToePvC_UnitTest {

    PvC pvc = new PvC();

    void main () {

        Log.d("PC turn", "" + pvc.Computer_Turn());
    }
}
