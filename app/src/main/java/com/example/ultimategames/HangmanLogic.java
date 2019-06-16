package com.example.ultimategames;

import android.os.Handler;
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
        mGameHangman.UpdateStats(WelcomeScreenActivity.global_score, mFailCounter);

        mGameHangman.CreateWordView(mSolution.length());
    }

    private void setRandomWord()
    {
        int randomNumber = (int) (Math.random() * mWord_collection.size());

        mSolution = mWord_collection.get(randomNumber);
        mWord = mSolution.split("(?!^)");
    }

    public void getHint()
    {
        int index = mGameHangman.GetFirstHiddenLetterIndex();
        String letter = mWord[index];

        for( int i = 0; i < mWord.length; i++)
        {
            if(mWord[i].toUpperCase().equals(letter.toUpperCase()))
            {
                mGameHangman.ShowLetterAtPosition(letter, i);
                mGuessedLetter++;
            }
        }

        WelcomeScreenActivity.global_score -= 3;
        mGameHangman.UpdateStats(WelcomeScreenActivity.global_score, mFailCounter);
        mGameHangman.ShowLetterAtPosition(mWord[index], index);

        if(mGuessedLetter == mWord.length)
        {
            WelcomeScreenActivity.global_score++;
            mGameHangman.UpdateStats(WelcomeScreenActivity.global_score, mFailCounter);

            mGameHangman.Win();

            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Reset();
                }
            }, 500);
        }
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

        if(mGuessedLetter == mWord.length)
        {
            WelcomeScreenActivity.global_score++;
            mGameHangman.UpdateStats(WelcomeScreenActivity.global_score, mFailCounter);

            mGameHangman.Win();

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
        mFailCounter++;
        mGameHangman.UpdateStats(WelcomeScreenActivity.global_score, mFailCounter);


        if (mFailCounter >= 8)
        {
            WelcomeScreenActivity.global_score -= 2;

            mGameHangman.Lose();
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Reset();
                }
            }, 500);
        }

        // Set picture according to number of fails
        ImageView imageViewHangmanPic = (ImageView) mGameHangman.findViewById(R.id.imageViewHangmanPic);

        if(mFailCounter == 1){
            imageViewHangmanPic.setImageResource(R.drawable.hangman_1);
        }else if (mFailCounter == 2)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_2);
        }
        else if (mFailCounter == 3)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_3);
        }
        else if (mFailCounter == 4)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_4);
        }
        else if (mFailCounter == 5)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_5);
        }
        else if (mFailCounter == 6)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_6);
        }
        else if (mFailCounter == 7)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_7);
        }
        else if (mFailCounter == 8)
        {
            imageViewHangmanPic.setImageResource(R.drawable.hangman_8);
        }
    }

    private void Reset()
    {
        mGuessedLetter = 0;
        mFailCounter = 0;
        mGameHangman.ResetView();
        mWord = null;
        setRandomWord();

        // Reset Hangman Picture as well
        ImageView imageViewHangmanPic = (ImageView) mGameHangman.findViewById(R.id.imageViewHangmanPic);
        imageViewHangmanPic.setImageResource(R.drawable.hangman);

        mGameHangman.UpdateStats(WelcomeScreenActivity.global_score, mFailCounter);

        mGameHangman.CreateWordView(mSolution.length());
    }
}
