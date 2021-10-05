package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText numtel;
    private EditText adresse;
    private EditText notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        numtel = (EditText) findViewById(R.id.numtel);
        adresse = (EditText) findViewById(R.id.adresse);
        notes = (EditText) findViewById(R.id.notes);








    }
}