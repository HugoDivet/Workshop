package com.example.workshop;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InfosPerso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_perso);

        FloatingActionButton AddInfosPerso = (FloatingActionButton) findViewById(R.id.AddInfos);
        FloatingActionButton SettingsInfos = (FloatingActionButton) findViewById(R.id.SettingsInfos);

        AddInfosPerso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent AddInfosPerso = new Intent(InfosPerso.this, AddInfosPerso.class);
                startActivity(AddInfosPerso);
            }
        });
        SettingsInfos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent SettingsInfos = new Intent(InfosPerso.this, Settings.class);
                startActivity(SettingsInfos);
            }
        });
    }
}