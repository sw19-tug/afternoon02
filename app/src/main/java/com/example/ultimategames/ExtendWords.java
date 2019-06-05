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

    // Database Helper
    DatabaseHelper mDatabaseHelper;
    private EditText editTextNewWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_words);

        // Buttons
        Button addWordBtn = findViewById(R.id.addWordBtn);
        // Edit Text
        editTextNewWord = (EditText) findViewById(R.id.newWord);
        // Database Helper
        mDatabaseHelper = new DatabaseHelper(this);

        addWordBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Name from EditTextView
                String newEntry = editTextNewWord.getText().toString();

                // Check Eintrag
                if(editTextNewWord.length() != 0)
                {
                    // In this case we want to add entry to database
                    addWord(newEntry);
                    editTextNewWord.setText(""); // Und den Textview wieder auf leer setzten
                }else
                {
                    toastMessage("You must put something in the text field");
                }
            }

        });
    }

    public void addWord(String newWord)
    {
        Log.d("MYLOG", "MyLog addWord");
        // Rückgabewert beim Einfügen eines Wertes == boolean
        // Aufruf des Database helprs
        boolean insertData = mDatabaseHelper.addData(newWord);

        // Ausgabe wenn erfolgreich eingefügt
        if(insertData)
        {
            toastMessage("Data Successfully Inserted!");
            // Toast.makeText(this, "Word added to bla", Toast.LENGTH_LONG).show();
            Log.d("MYLOG", "Word inserted sucessfully [RKB]");
        }else{
            toastMessage("Something went wrong");
        }


    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
