package com.example.third_assignment_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ListView lvNotes;
    private ArrayAdapter listAdapter;
    private ArrayList<String> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvNotes = findViewById(R.id.lvNotes);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.notesList = new ArrayList<String>(sp.getStringSet("notes", new HashSet<String>()));
        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notesList);
        this.lvNotes.setAdapter(this.listAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Object Constant;
        SharedPreferences sharedPref = this.getSharedPreferences(Constant.NOTES_FILE, this.MODE_PRIVATE);

        String lastSavedNote = sharedPref.getString(Constants.NOTE_KEY, s1: "NA");
        String lastSavedNoteDate = sharedPref.getString(Constants.NOTE_KEY_DATE, s1: "1900-01-01");
        Set<String>savedSet = sharedPref.getStringSet(Constants.NOTES_ARRAY_KEY, set:null);

        if (savedSet !=null) {
            this.listNoteItems.clear();
            this.listNoteItems.addAll(savedSet);
            this.adapter.notifyDataSetChanged();

        }

        Snackbar.make(lvNotes, String.format("%s: %s", getString(R.string.msg_last_saved_note), Snackbar.LENGTH_LONG).show();
        Toast.makeText(context: this, lastSavedNoteDate, Toast.LENGTH_LONG).show();



        //Your adapter loses reference to your list.
        //https://stackoverflow.com/questions/15422120/notifydatasetchange-not-working-from-custom-adapter
        notesList.clear();
        this.notesList.addAll((sp.getStringSet("notes", new HashSet<String>())));
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_note:
                Intent i = new Intent(PackageContext this, AddNoteActivity.class);
                startActivity(i);
                return true;
            case R.id.remove_note:
                return true;
            case R.id.update_note:
                Toast.makeText(getApplicationContext(), R.string.msg_updated_clicked, Toast.LENGTH_LONG).show();
                return true;
            case R.id.dunno:
                Toast.makeText(getApplicationContext(), R.string.msg_dunno_clicked, Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
