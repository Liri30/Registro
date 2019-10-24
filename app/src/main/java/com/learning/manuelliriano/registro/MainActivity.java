package com.learning.manuelliriano.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner mySpinner;
    private String[] data = {"Soltero/a", "Casado/a", "Union Libre", "Viudo", "Esperando un milagro"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner= findViewById(R.id.mySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, data);
        mySpinner.setAdapter(adapter);

    }
}
