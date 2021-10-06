package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String nom;
    private String prenom;
    private String numtel;
    private String adresse;
    private String notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nom = (EditText) findViewById(R.id.nom);
        EditText prenom = (EditText) findViewById(R.id.prenom);
        EditText numtel = (EditText) findViewById(R.id.numtel);
        EditText adresse = (EditText) findViewById(R.id.adresse);
        EditText notes = (EditText) findViewById(R.id.notes);
        Button enregistrer = (Button) findViewById(R.id.enregistrer);
        Button infoPerso = (Button) findViewById(R.id.infoPerso);
        Button contacts = (Button) findViewById(R.id.contacts);
        Button journal = (Button) findViewById(R.id.journal);


     ///   Context context = getActivity();
     ///   SharedPreferences sharedPref = context.getSharedPreferences(
      ///          getString(R.string.nom), Context.MODE_PRIVATE);



        infoPerso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InfosPerso = new Intent( MainActivity.this, InfosPerso.class);
                startActivity(InfosPerso);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Contacts = new Intent( MainActivity.this, Contacts.class);
                startActivity(Contacts);
            }
        });

        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Journal = new Intent( MainActivity.this, Journal.class);
                startActivity(Journal);
            }
        });



    }


}