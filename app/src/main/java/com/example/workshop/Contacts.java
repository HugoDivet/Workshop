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
import android.util.Log;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import android.os.Bundle;

public class Contacts extends AppCompatActivity {
    private Button ajout;
    private Button ajout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ajout = (Button) findViewById(R.id.ajout);
        ajout2 = (Button) findViewById(R.id.ajout2);


        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ajout_contact = new Intent(Contacts.this, Ajout_contact.class);
                startActivity(Ajout_contact);
            }
        });
        ajout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ajout_contact = new Intent(Contacts.this, Ajout_contact.class);
                startActivity(Ajout_contact);
            }
        });


    }
}
