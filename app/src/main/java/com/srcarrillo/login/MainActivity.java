package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Nombre, Contraseña;
    private EditText txtNombre, txtContraseña;
    private Button btnIniciar, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        Nombre = findViewById(R.id.Contraseña);
        Contraseña = findViewById(R.id.Contraseña);

        //EditText
        txtNombre = findViewById(R.id.txtNombre);
        txtContraseña = findViewById(R.id.txtContraseña);

        //Button
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistro = findViewById(R.id.btnRegistro);

    }
}