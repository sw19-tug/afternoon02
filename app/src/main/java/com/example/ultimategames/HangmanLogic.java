package com.example.ultimategames;

import android.os.Handler;

import java.util.ArrayList;

public class HangmanLogic
{
    private GameHangman mGameHangman;
    private String mSolution;
    private String[] mWord;
    private ArrayList<String> mWord_collection;
    private int mFailCounter = 0;
    private int mGuessedLetter = 0;
    private int mPoints = 0;

    public HangmanLogic(GameHangman game)
    {
        mGameHangman = game;

        mWord_collection = new ArrayList<>();
        mWord_collection.add("AAHS");
        mWord_collection.add("AALS");
        mWord_collection.add("ABAC");
        mWord_collection.add("ABAS");

        setRandomWord();
        mGameHangman.UpdateStats(mPoints, mFailCounter);
    }

    private void setRandomWord()
    {
        int randomNumber = (int) (Math.random() * mWord_collection.size());

        String randomWord = mWord_collection.get(randomNumber);
        mSolution = randomWord;
        mWord = randomWord.split("(?!^)");
    }

    public void checkLetter(String guessed_letter)
    {
        boolean letterGuessed = false;

        for( int i = 0; i < mWord.length; i++)
        {
            if(mWord[i].toUpperCase().equals(guessed_letter.toUpperCase()))
            {
                letterGuessed = true;
                mGameHangman.ShowLetterAtPosition(guessed_letter, i);
                mGuessedLetter++;
            }
        }

        if(letterGuessed == false)
        {
            letterFailed();
        }

        // Check if word was completed successfully
        if(mGuessedLetter == mWord.length)
        {
            mPoints++;
            mGameHangman.UpdateStats(mPoints, mFailCounter);
            mGameHangman.Win();

            // Reset the game screen with small delay (allows for the tap to end)
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Reset();
                }
            }, 500);
        }
    }

    private void letterFailed()
    {
        // Increment fail counter
        mFailCounter++;
        mGameHangman.UpdateStats(mPoints, mFailCounter);

        // Game Over after 6 failed guesses
        if (mFailCounter >= 6)
        {
            mGameHangman.Lose();
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Reset();
                }
            }, 500);
        }
    }

    private void Reset()
    {
        mGuessedLetter = 0;
        mFailCounter = 0;
        mGameHangman.ResetView();
        mWord = null;
        setRandomWord();
        mGameHangman.UpdateStats(mPoints, mFailCounter);
    }
}