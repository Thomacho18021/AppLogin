package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Nombre, Contraseña, Registrate;
    private EditText txtNombre, txtContraseña;
    private Button btnIniciar, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        Nombre = findViewById(R.id.Apellido);
        Contraseña = findViewById(R.id.Apellido);
        Registrate = findViewById(R.id.Registrate);

        //EditText
        txtNombre = findViewById(R.id.txtNombre);
        txtContraseña = findViewById(R.id.txtApellido);

        //Button
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistro = findViewById(R.id.btnRegistro);


        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });
    }


}