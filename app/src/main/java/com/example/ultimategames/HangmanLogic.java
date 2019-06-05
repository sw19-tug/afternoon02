package com.example.ultimategames;

import android.media.Image;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class HangmanLogic
{
    private GameHangman mGameHangman;
    private DatabaseHelper mDatabaseHelper;
    private String mSolution;
    private String[] mWord;
    private ArrayList<String> mWord_collection;
    private int mFailCounter = 0;
    private int mGuessedLetter = 0;
    private int mPoints = 0; //Total Points user has scored

    public HangmanLogic(GameHangman game, DatabaseHelper databaseHelper)
    {
        mGameHangman = game;
        mDatabaseHelper = databaseHelper;

        mWord_collection = mDatabaseHelper.getAllWords();
        mWord_collection.add("WHAT");
        mWord_collection.add("TAKE");
        mWord_collection.add("BASTARD");
        mWord_collection.add("YOU");

        setRandomWord();
        mGameHangman.UpdateStats(mPoints, mFailCounter);
        mGameHangman.CreateWordView(mSolution.length());
    }

    private void setRandomWord()
    {
        int randomNumber = (int) (Math.random() * mWord_collection.size());

        mSolution = mWord_collection.get(randomNumber);
        mWord = mSolution.split("(?!^)");
        // Log.d("LOGRKB", "Selected word" + mWord);

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

    public void letterFailed()
    {
        // Increment fail counter
        mFailCounter++;
        mGameHangman.UpdateStats(mPoints, mFailCounter);

        // Game Over after 8 failed guesses
        if (mFailCounter >= 8)
        {
            mPoints -= 2;
            mGameHangman.Lose();
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Reset();
                }
            }, 500);
        }

        // RKB 20190605 - START
        // Get Image view "Galgen"
        ImageView imageViewHangmanPic = (ImageView) mGameHangman.findViewById(R.id.imageViewHangmanPic);

        // Set the next image of "Galgen" abhängig von der Anzahl der Fails (mit switch danach machen)
        if(mFailCounter == 1){
            // First Fail, First Picture
            imageViewHangmanPic.setImageResource(R.drawable.hangdroid_1);
        }else if (mFailCounter == 2)
        {
            // Second Fail, Second Picture
            imageViewHangmanPic.setImageResource(R.drawable.hangdroid_2);
        }
        // RKB 20190605 - END
    }

    private void Reset()
    {
        mGuessedLetter = 0;
        mFailCounter = 0;
        mGameHangman.ResetView();
        mWord = null;
        setRandomWord();
        mGameHangman.UpdateStats(mPoints, mFailCounter);
        mGameHangman.CreateWordView(mSolution.length());
    }
}
