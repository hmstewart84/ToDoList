package com.example.user.todolist;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;



public class Main_Activity_2 extends AppCompatActivity {

    ArrayList<String> detailsPage = null;

    TextView textview;
    EditText mTextToSave;
    Button mSaveButton;
    TextView noteDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__activity_2);

        textview = (TextView) findViewById(R.id.message_display);

        Intent intent = getIntent();

        // needs to be final to access this in onClickListener inner class
        final String message = intent.getStringExtra("selected_item");

        textview.setText(message);

        mTextToSave = (EditText) findViewById(R.id.editText);
        mSaveButton = (Button) findViewById(R.id.button1);

        noteDisplay = (TextView) findViewById(R.id.noteDisplay);

        String savedText = SavedTextPreferences.getStoredText(this, message);

        if (savedText != null && !savedText.isEmpty()) {

            noteDisplay.setText(savedText);

        }
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSave = mTextToSave.getText().toString();
                Log.d("PersistenceExample:", "Save Button Clicked!");
                Log.d("PersistenceExample:", "The text to save is: '" + textToSave + "'");
                noteDisplay.setText(textToSave);
                Context context = v.getContext();
                SavedTextPreferences.setStoredText(context, message, textToSave);
            }

        });

    }
}
