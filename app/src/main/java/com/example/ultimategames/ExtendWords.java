package com.example.ultimategames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExtendWords extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private EditText editTextNewWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_words);

        Button addWordBtn = findViewById(R.id.addWordBtn);
        Button removeWordBtn = findViewById(R.id.removeWordBtn);

        editTextNewWord = (EditText) findViewById(R.id.newWord);

        mDatabaseHelper = new DatabaseHelper(this);

        addWordBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editTextNewWord.getText().toString();

                if(editTextNewWord.length() != 0)
                {
                    addWord(newEntry);
                    editTextNewWord.setText("");
                }else
                {
                    toastMessage(getResources().getString(R.string.err_enter_new_word));
                }
            }
        });

        removeWordBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editTextNewWord.getText().toString();

                if(editTextNewWord.length() != 0)
                {
                    removeWord(newEntry);
                    editTextNewWord.setText("");
                }else
                {
                    toastMessage(getResources().getString(R.string.err_enter_new_word));
                }
            }
        });
    }

    public void addWord(String newWord)
    {
        boolean insertData = mDatabaseHelper.addData(newWord.toLowerCase());

        if(insertData)
        {
            toastMessage(getResources().getString(R.string.word_added));
        }else{
            toastMessage(getResources().getString(R.string.err_word_exist));
        }
    }

    public void removeWord(String word)
    {
        if (mDatabaseHelper.deleteWord(word))
        {
            toastMessage(getResources().getString(R.string.word_removed));
        }
        else
        {
            toastMessage(getResources().getString(R.string.err_word_not_exist));
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
