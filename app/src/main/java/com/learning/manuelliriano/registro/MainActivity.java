package com.learning.manuelliriano.registro;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner mySpinner; //Estado civil
    //EditTextVariable
    EditText myEditNacimiento, myEditName, myEditApellido, myEditEdad;
    EditText myEditMail;
    RadioGroup RG;

    //RadioButton
    RadioButton radioMasc, radioFem, radioSex;

    //Data for spinner
    private String[] data = {"Elegir", "Soltero/a", "Casado/a",
            "Union Libre", "Viudo",
            "Esperando un milagro"};
    final Calendar myCalendar = Calendar.getInstance();
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Componentes(); //Llama los componentes del layout


        //Dropdown adapter, insert options in the dropdown
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, data);
        mySpinner.setAdapter(adapter);

        //DatePicker
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }
        };

        myEditNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(context, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();

            }
        });


    }

    private void updateLabel(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        myEditNacimiento.setText(sdf.format(myCalendar.getTime()));
    }

    //Onclick button Nuevo
    public void NuevoFormulario(View view) {
        myEditMail.setText("");
        myEditApellido.setText("");
        myEditName.setText("");
        myEditEdad.setText("");
        myEditNacimiento.setText("");
        //Spinner first item
        mySpinner.setSelection(0);
        //Uncheck radio button
        radioMasc.setChecked(false);
        radioFem.setChecked(false);

        Toast.makeText(this, "Por favor inserte sus nuevos datos", Toast.LENGTH_LONG).show();

    }

    //Los editText
    public void Componentes(){
        mySpinner= findViewById(R.id.mySpinner);
        myEditNacimiento = findViewById(R.id.myEditNacimiento);
        myEditName = findViewById(R.id.myEditName);
        myEditApellido = findViewById(R.id.myEditLastName);
        myEditMail = findViewById(R.id.myEditCorreo);
        myEditEdad = findViewById(R.id.myEditAge);
        radioFem = findViewById(R.id.radioFemenino);
        radioMasc = findViewById(R.id.radioMacho);
        RG =findViewById(R.id.myRadioGroup);
    }

    public void EnviarFormulario(View view) {

        if (myEditName.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Por favor llene el campo Nombre", Toast.LENGTH_SHORT).show();
        }

        if (myEditApellido.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Por favor llene el campo Apellido", Toast.LENGTH_SHORT).show();
        }

        if (myEditMail.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Por favor llene el campo Correo", Toast.LENGTH_SHORT).show();
        }

        if (myEditEdad.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Por favor llene el campo Edad", Toast.LENGTH_SHORT).show();
        }

        if (RG.getCheckedRadioButtonId() == -1){
            Toast.makeText(MainActivity.this, "Por favor seleccione un genero aunque este confundido", Toast.LENGTH_SHORT).show();
        }
        if (mySpinner.getSelectedItem()=="Elegir"){

            Toast.makeText(MainActivity.this, "Por favor seleccione su estado civil", Toast.LENGTH_SHORT).show();
        }
        else{
            //Waiting what to do
            String nombre = myEditName.getText().toString();
            String apellido = myEditApellido.getText().toString();
            String email = myEditMail.getText().toString();
            String nacimmiento = myEditNacimiento.getText().toString();
            String estadoCivil = mySpinner.getSelectedItem().toString();
            String edad = myEditEdad.getText().toString();
            int index  = RG.getCheckedRadioButtonId();

            radioSex = findViewById(index);
            String genero = radioSex.getText().toString();

            Intent intent = new Intent(this, DatosActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("apellido", apellido);
            intent.putExtra("edad", edad);
            intent.putExtra("correo", email);
            intent.putExtra("nacimiento", nacimmiento);
            intent.putExtra("estado", estadoCivil);
            intent.putExtra("genero", genero);

            startActivity(intent);

        }

    }
}
