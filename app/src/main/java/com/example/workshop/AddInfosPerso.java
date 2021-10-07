package com.example.workshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddInfosPerso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_infos_perso);


        Button EnregistrerAddInfos = (Button) findViewById(R.id.EnregistrerAddInfos);


        EnregistrerAddInfos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent EnregistrerAddInfos = new Intent(AddInfosPerso.this, InfosPerso.class);
                startActivity(EnregistrerAddInfos);
            }
        });
    }
}