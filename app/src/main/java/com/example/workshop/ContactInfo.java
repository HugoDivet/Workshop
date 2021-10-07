package com.example.workshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class ContactInfo extends AppCompatActivity {

    EditText nom,prenom,relation,phone,note;
    Button save;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        relation = findViewById(R.id.relation);
        phone = findViewById(R.id.phone);
        note = findViewById(R.id.note);
        save = findViewById(R.id.btnSave);
        toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contact_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSave){
            if(nom.getText().length() != 0) {
                NoteContacts note_contact = new NoteContacts(nom.getText().toString(), prenom.getText().toString(), note.getText().toString(), relation.getText().toString(),"", phone.getText().toString());
                FullDatabase fDB = new FullDatabase(this);
                long id = fDB.addNoteContacts(note_contact);
                NoteContacts check = fDB.getNoteContacts(id);
                Log.d("test", "Note: " + id + " -> Title:" + check.getNom() + " " + check.getPrenom() + " " + check.getRelation() + " " + check.getTel() + " " + check.getInfos());
                onBackPressed();
            }
        }
        if(item.getItemId() == R.id.menuDelete){

        }
        return super.onOptionsItemSelected(item);
    }
}