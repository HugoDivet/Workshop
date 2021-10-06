package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import android.os.Bundle;

public class Contacts extends AppCompatActivity {
private Button utilisateur1;
private Button utilisateur2;
    private Button utilisateur3;
    private Button utilisateur4;
    private Button utilisateur5;
    private Button utilisateur6;
    private Button utilisateur7;
    private Button utilisateur8;
    private Button utilisateur9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        utilisateur1 = (Button) findViewById(R.id.utilisateur1);
        utilisateur2 = (Button) findViewById(R.id.utilisateur2);
        utilisateur3 = (Button) findViewById(R.id.utilisateur3);
        utilisateur4 = (Button) findViewById(R.id.utilisateur4);
        utilisateur5 = (Button) findViewById(R.id.utilisateur5);
        utilisateur6 = (Button) findViewById(R.id.utilisateur6);
        utilisateur7 = (Button) findViewById(R.id.utilisateur7);
        utilisateur8 = (Button) findViewById(R.id.utilisateur8);
        utilisateur9 = (Button) findViewById(R.id.utilisateur9);

        utilisateur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        utilisateur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        utilisateur3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        utilisateur4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        utilisateur5.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        utilisateur6.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        utilisateur7.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        utilisateur8.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
        utilisateur9.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
    }

}
