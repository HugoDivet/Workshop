package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (RelativeLayout) findViewById(R.id.layout);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Pref", 0 );


        String tLayout = preferences.getString("Color", "");
        mLayout.setBackgroundColor(Integer.parseInt(tLayout));
    }
}