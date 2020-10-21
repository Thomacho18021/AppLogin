package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Registro extends AppCompatActivity {
    private TextView Rtitulo, Nombre, Apellido, Email, Contraseña, conContraseña, Telefono, Genero;
    private Button btnRegistrarse;
    private EditText txtNombre, txtApellido, txtEmail, txtContraseña, txtConContraseña, txtTelefono;
    private RadioButton rbMasculino, rbFemenino;
    private RadioGroup rgGenero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //EditText
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        txtContraseña = findViewById(R.id.txtContraseña);
        txtConContraseña = findViewById(R.id.txtConContraseña);
        txtTelefono = findViewById(R.id.txtTelefono);

        //RadioButton
        rbFemenino = findViewById(R.id.rbFemenino);
        rbMasculino = findViewById(R.id.rbMasculino);


    }
}