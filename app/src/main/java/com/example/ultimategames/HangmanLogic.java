package com.example.ultimategames;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HangmanLogic
{
    private GameHangman mGameHangman;
    private String mSolution;
    private String[] mWord;
    private ArrayList<String> mWord_collection;
    private int mFailCounter = 0;
    private int mGuessedLetter = 0;
    private int mPoints = 0; //Total Points user has scored

    public HangmanLogic(GameHangman game)
    {
        mGameHangman = game;

        mWord_collection = new ArrayList<>();
        mWord_collection.add("AAHS");
        mWord_collection.add("AALS");
        mWord_collection.add("ABAC");
        mWord_collection.add("ABAS");

        setRandomWord();
    }

    private void setRandomWord()
    {
        // Zufällig ein Wert aus der Wortliste auswählen
        int randomNumber = (int) (Math.random() * mWord_collection.size());
        String randomWord = mWord_collection.get(randomNumber);
        mSolution = randomWord;
        mWord = randomWord.split("(?!^)");
        Log.d("WORD", mWord[0] + " " + mWord[1] + " " + mWord[2] + " " + mWord[3]);
    }

    public void checkLetter(String guessed_letter)
    {
        // Flag for failed letter
        boolean letterGuessed = false;

        // Check every entered letter
        for( int i = 0; i < mWord.length; i++)
        {
            // Check if solution contains letter
            if(mWord[i].toUpperCase().equals(guessed_letter.toUpperCase()))
            {
                Log.d("GUESS", "Solution: " + mSolution + "; Letter: " + guessed_letter + "; Position: " +i);

                // Set flag on true
                letterGuessed = true;

                // show the correct guessed letters
                mGameHangman.ShowLetterAtPosition(guessed_letter, i);

                // Increase counter
                mGuessedLetter++;
            }
        }

        // Call Method for letter fails actions
        if(letterGuessed == false)
        {
            letterFailed();
        }

        // Check if word wurde erraten
        if(mGuessedLetter == mWord.length)
        {
            Log.d("WIN", "You win!");

            // If user guessed a word - increment Points
            mPoints++;

            // CLEAR THE PREV WORD
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

        // Game Over after 6 failed guesses
        // TODO: implement changing graphics
        if (mFailCounter >= 6)
        {
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Reset();
                }
            }, 500);


            // TODO GAME OVER
            Log.d("GAMEOVER","Game Over!");
        }
    }

    private void Reset()
    {
        mGuessedLetter = 0;
        mGameHangman.ResetView();
        mWord= null;
        setRandomWord();
    }
}
