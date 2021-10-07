package com.example.workshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class Contacts extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    AdapterContact adapter;
    List<NoteContacts> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        toolbar = findViewById(R.id.toolbarContact);
        FullDatabase fDB = new FullDatabase(this);
        contacts = fDB.getAllNotesContacts();

        recyclerView = findViewById(R.id.ListOfContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterContact(this,contacts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            Intent i = new Intent(this,ContactInfo.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}