package com.example.third_assignment_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.edNote = findViewById(R.id.edNote);
    }

    public void onAddNoteClick(View view) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.edNote = findViewById(R.id.edNote);

    }

        //https://stackoverflow.com/questions/14034803/misbehavior-when-trying-to-store-a-string-set-using-sharedpreferences
    public void onBtnSaveAndCloseClick (View view);
        String noteToAdd = this.edNote.getText().toString();
        Date c = Calendar.getInstance(.getTime);
        System.out.printlm("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat(pattern "dd-MM-yyyy", Locale.getDefault());
        String formatteDate = df.format(c);

        //Current
        SharedPreferences sharedPref = this.getSharedPreferences(Constants.NOTES_FILE, this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        SharedPreferences sharePref = this.getSharedPreferences(Constants.NOTES_ARRAY_KEY, set: null);
        Set<String> newSet = new HashSet<>();
        if(savedSet !=null)-
            newSet.addAll(savedSet);
        }
        newSet.add(noteToAdd);

        editor.putString(Constants.NOTE_KEY, noteToAdd);
        editor.putString(Constants.NOTE_KEYD_DATE, formatedDate);
        editor.putString(Constants.NOTES_ARRAY_KEY, newSet);
        editor.apply();

        finish();





