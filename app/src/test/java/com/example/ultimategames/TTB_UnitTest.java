package com.example.ultimategames;

import android.view.ViewGroup;
import android.widget.Button;

import com.example.ultimategames.TouchTheBlock.TTB_Activity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TTB_UnitTest {
    TTB_Activity ttb;
    WelcomeScreenActivity welcome;
    @Before
    public void setUp() throws Exception {
        ttb = new TTB_Activity();
        welcome = new WelcomeScreenActivity();
    }

    @Test
    public void pointsShouldBeIncreased() {

        int OldPoints = ttb.testcounter;
        ttb.addPoints();
        assert (OldPoints < ttb.testcounter);

    }

    @Test
    public void pointsShouldBeDecreased() {

        int OldPoints = ttb.testcounter;
        ttb.deductPoints();
        assert (OldPoints > ttb.testcounter);
    }

    @Test
    public void illegalRestart() {

        welcome.global_score = 1;
        int oldScore = welcome.global_score;
        ttb.reStart();

        assert (welcome.global_score != oldScore);
    }

    @Test
    public void restartPointDeduction() {

        welcome.global_score = 11;
        int oldScore = welcome.global_score;
        ttb.reStart();

        assert (oldScore != welcome.global_score -10);
    }



}
