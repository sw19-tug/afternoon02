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
    @Before
    public void setUp() throws Exception {
        ttb = new TTB_Activity();
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

    public void timerShouldbeReset() throws InterruptedException {
        ttb.timer();

        // wait for some time till the counter is incremented
        Thread.sleep(2000);

        assert(Time == 0);



    }

}
