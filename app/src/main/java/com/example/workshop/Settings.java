package com.example.workshop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Settings extends AppCompatActivity {

    RelativeLayout mLayout;
    int mDefaultColor = 0;
    private Button color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences preferences = getSharedPreferences("Pref", 0);
        SharedPreferences.Editor editor = preferences.edit();

        mLayout = (RelativeLayout) findViewById(R.id.layout);
        mDefaultColor = ContextCompat.getColor(Settings.this, R.color.white);
        color = (Button) findViewById(R.id.color);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker(editor);
            }
        });
    }

    public void openColorPicker(SharedPreferences.Editor editor) {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                mLayout.setBackgroundColor(mDefaultColor);
                editor.putString("Color", String.valueOf(mDefaultColor));
            }
        });
        colorPicker.show();
    }
}