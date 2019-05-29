package com.example.TicTacToe;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PvCTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        //Context appContext = InstrumentationRegistry.getTargetContext();

        PvC pvC = new PvC();
        //ContextWrapper contextWrapper = new ContextWrapper(pvC.getBaseContext());

        // HORIZONTAL CHECKS
        int r = pvC.Computer_Turn(true,0,1);
        if (r == 2) {
            Log.d("PvC Logic", "0 1 Pass");
        }
        r = pvC.Computer_Turn(true,0,2);
        if (r == 1) {
            Log.d("PvC Logic", "0 2 Pass");
        }
        r = pvC.Computer_Turn(true,3,4);
        if (r == 5) {
            Log.d("PvC Logic", "3 4 Pass");
        }
        r = pvC.Computer_Turn(true,3,5);
        if (r == 4) {
            Log.d("PvC Logic", "3 5 Pass");
        }
        r = pvC.Computer_Turn(true,6,7);
        if (r == 8) {
            Log.d("PvC Logic", "6 7 Pass");
        }

        // VERTICAL TESTS
        r = pvC.Computer_Turn(true,0,3);
        if (r == 6) {
            Log.d("PvC Logic", "0 3 Pass");
        }
        r = pvC.Computer_Turn(true,5,8);
        if (r == 2) {
            Log.d("PvC Logic", "5 8 Pass");
        }
        r = pvC.Computer_Turn(true,1,7);
        if (r == 4) {
            Log.d("PvC Logic", "1 7 Pass");
        }
        r = pvC.Computer_Turn(true,4,7);
        if (r == 1) {
            Log.d("PvC Logic", "4 7 Pass");
        }
        r = pvC.Computer_Turn(true,3,6);
        if (r == 0) {
            Log.d("PvC Logic", "3 6 Pass");
        }

    }
}
