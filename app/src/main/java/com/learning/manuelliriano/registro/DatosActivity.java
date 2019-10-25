package com.learning.manuelliriano.registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    TextView nombre, apellido, genero, edad;
    TextView nacimiento, correo, status;
    String Snombre, Sapellido, Sgenero, Sedad;
    String Snacimiento, Scorreo, Sstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Elementos();//buscar los id en el layout

        Intent parametros = getIntent();
        Snombre = parametros.getStringExtra("nombre");
        Sapellido = parametros.getStringExtra("apellido");
        Sgenero = parametros.getExtras().getString("genero");
        Sedad = parametros.getExtras().getString("edad");
        Snacimiento = parametros.getExtras().getString("nacimiento");
        Scorreo = parametros.getExtras().getString("correo");
        Sstatus = parametros.getExtras().getString("estado");

        nombre.setText(Snombre);
        apellido.setText(Sapellido);
        edad.setText(Sedad+" años");
        genero.setText(Sgenero);
        nacimiento.setText(Snacimiento);
        correo.setText(Scorreo);
        status.setText(Sstatus);


    }

    public void Elementos(){
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        genero = findViewById(R.id.Genero);
        edad = findViewById(R.id.edad);
        nacimiento =findViewById(R.id.Fecha_Nacimiento);
        correo = findViewById(R.id.email);
        status = findViewById(R.id.Estatus);

    }
}
