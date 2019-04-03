package com.example.ultimategames;

import com.example.TicTacToe.TicTacToe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TicTacToeUnitTest {
    TicTacToe ticTacToe;
    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testPlayer1Won() {
        int result;
        result = ticTacToe.changeField(0,0,1);
        result = ticTacToe.changeField(0,2,2);
        result = ticTacToe.changeField(2,2,1);
        result = ticTacToe.changeField(1,1,2);
        result = ticTacToe.changeField(2,0,1);
        result = ticTacToe.changeField(1,0,2);
        result = ticTacToe.changeField(2,1,1);
        Assert.assertEquals(1,result);
    }

    @Test
    public void testPlayer2Won() {
        int result;
        result = ticTacToe.changeField(0,0,1);
        result = ticTacToe.changeField(1,0,2);
        result = ticTacToe.changeField(2,2,1);
        result = ticTacToe.changeField(1,1,2);
        result = ticTacToe.changeField(0,2,1);
        result = ticTacToe.changeField(1,2,2);
        Assert.assertEquals(2,result);
    }

    @Test
    public void testDrawGame() {
        int result;
        result = ticTacToe.changeField(0,0,1);
        result = ticTacToe.changeField(1,1,2);
        result = ticTacToe.changeField(0,2,1);
        result = ticTacToe.changeField(0,1,2);
        result = ticTacToe.changeField(2,1,1);
        result = ticTacToe.changeField(1,2,2);
        result = ticTacToe.changeField(1,0,1);
        result = ticTacToe.changeField(2,0,2);
        result = ticTacToe.changeField(2,2,1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testUnfinishedGame() {
        int result;
        result = ticTacToe.changeField(0,0,1);
        result = ticTacToe.changeField(1,1,2);
        Assert.assertEquals(-1,result);
    }

    @Test
    public void testForColumnWin() {
        int result;
        ticTacToe.changeField(0,1,1);
        ticTacToe.changeField(0,2,2);
        ticTacToe.changeField(1,1,1);
        ticTacToe.changeField(1,2,2);
        result = ticTacToe.changeField(2,1,1);
        Assert.assertEquals(1,result);
    }
}
