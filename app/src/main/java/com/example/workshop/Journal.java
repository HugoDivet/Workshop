package com.example.workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class Journal extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eTextDate;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        FloatingActionButton ajouterInfoJournal = (FloatingActionButton) findViewById(R.id.floatingActionButtonAdd);
        FloatingActionButton retourMenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonRetourMenu);
        ImageButton settings = (ImageButton) findViewById(R.id.ButtonSettings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Settings = new Intent(Journal.this, Settings.class);
                startActivity(Settings);
            }
        });

        ajouterInfoJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AjouterInfoJournal = new Intent(Journal.this, AddJournal.class);
                startActivity(AjouterInfoJournal);
            }
        });

        retourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RetourMenu = new Intent(Journal.this, MainActivity.class);
                startActivity(RetourMenu);
            }
        });

        eTextDate=(EditText) findViewById(R.id.editText1);
        eTextDate.setInputType(InputType.TYPE_NULL);
        eTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Journal.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eTextDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


    }
}