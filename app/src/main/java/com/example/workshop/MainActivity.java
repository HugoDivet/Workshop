package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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


        EditText prenom = (EditText) findViewById(R.id.prenom);
        EditText numtel = (EditText) findViewById(R.id.numtel);
        EditText adresse = (EditText) findViewById(R.id.adresse);
        EditText notes = (EditText) findViewById(R.id.notes);
        EditText dateBirth = (EditText) findViewById(R.id.dateBirth);
        Button infoPerso = (Button) findViewById(R.id.infoPerso);
        Button contacts = (Button) findViewById(R.id.contacts);
        Button journal = (Button) findViewById(R.id.journal);
        ImageButton settings = (ImageButton) findViewById(R.id.ButtonSettings);

        EditText nom = (EditText) findViewById(R.id.nom);
        Button enregistrer = (Button) findViewById(R.id.enregistrer);
        Button showData = (Button) findViewById(R.id.showData);
        TextView showValue_nom = (TextView) findViewById(R.id.showValue_nom);
        TextView showValue_prenom = (TextView) findViewById(R.id.showValue_prenom);
        TextView showValue_dateBirth = (TextView) findViewById(R.id.showValue_datebirth);
        TextView showValue_adresse = (TextView) findViewById(R.id.showValue_adresse);
        TextView showValue_notes = (TextView) findViewById(R.id.showValue_notes);
        TextView showValue_numtel = (TextView) findViewById(R.id.showValue_numtel);



        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Settings = new Intent( MainActivity.this, Settings.class);
                startActivity(Settings);
            }
        });


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




        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nom.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter data", Toast.LENGTH_LONG).show();
                    nom.setError("Please input");
                    nom.requestFocus();
                    return;
                }
                saveData("key_1", nom.getText().toString());
                saveData("key_2", prenom.getText().toString());
                saveData("key_3", numtel.getText().toString());
                saveData("key_4", adresse.getText().toString());
                saveData("key_5", notes.getText().toString());
                saveData("key_6", dateBirth.getText().toString());
            }
        });

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = getData("key_1");
                String prenom = getData("key_2");
                String numtel = getData("key_3");
                String adresse = getData("key_4");
                String notes = getData("key_5");
                String dateBirth = getData("key_6");

                if(nom==null){
                    showValue_nom.setText("Pas de valeur");
                }
                else{
                    showValue_nom.setText(nom);
                    showValue_prenom.setText(prenom);
                    showValue_numtel.setText(numtel);
                    showValue_adresse.setText(adresse);
                    showValue_notes.setText(notes);
                    showValue_dateBirth.setText(dateBirth);
                }

            }
        });



    }

    private void saveData(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("Mypref", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key,value);
        editor.apply();

    }

    private String getData(String key){

        SharedPreferences sharedPreferences = getSharedPreferences("Mypref", 0);
        if (sharedPreferences.contains(key)){
            String data = sharedPreferences.getString(key,null);
            return data;
        }
        else{
            return null;
        }


    }


}