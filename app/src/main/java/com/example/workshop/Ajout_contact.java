package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import java.util.Date;

public class Ajout_contact extends AppCompatActivity
{
private TextView textView3;
private TextView textView4;
private TextView textView5;
private EditText editTextTextPersonName;
private EditText editTextTextPersonName2;
private EditText editTextDate;
private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_contact);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        button = (Button)  findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                saveName();
                savePrénom();

            }
        });
    }
    public void saveName()
    {
    SharedPreferences preferences = getSharedPreferences("Contacts", 0);
    SharedPreferences.Editor editor = preferences.edit();
    String nom = String.valueOf(button.getText());
    editor.putString("nom", nom);
    editor.apply();
    }
    public void savePrénom() {
        SharedPreferences preferences = getSharedPreferences("Contacts", 0);
        SharedPreferences.Editor editor = preferences.edit();
        String prénom = String.valueOf(button.getText());
        editor.putString("Prénom", prénom);
        editor.apply();
    }

}