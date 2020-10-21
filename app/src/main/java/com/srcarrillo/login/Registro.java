package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //Button
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombre = "";
                String Apellido = "";
                String Email = "";
                String Contraseña = "";
                String Telefono ="";
                String Genero = "";
                if (txtNombre.getText().toString().length() < 3) {
                    txtNombre.setError("Mínimo 3 Caracteres");
                    return;
                } else {
                    Nombre = txtNombre.getText().toString();
                }

                if (txtApellido.getText().toString().length() < 4) {
                    txtApellido.setError("Mínimo 4 Caracteres");
                    return;
                } else {
                    Apellido = txtApellido.getText().toString();
                }

                if (ValidarMail(txtEmail.getText().toString()) == false) {
                    txtEmail.setError("Email inválido");
                    return;
                } else{
                    Email = txtEmail.getText().toString();
                }

                if (ValidarContraseña()==false) {
                    txtConContraseña.setError("Contraseña No Coincide");
                    return;
                } else{
                    Contraseña = txtContraseña.getText().toString();
                }

                if (txtTelefono.getText().toString().length() < 12) {
                    txtTelefono.setError("Teléfono Inválido");
                    return;

                } else {
                    Telefono = txtTelefono.getText().toString();
                }

                if ((rbMasculino.isChecked() == false) && (rbFemenino.isChecked() == false)) {
                    rbFemenino.setError("Selecciona un Género");
                    return;
                } else{
                    if (rbMasculino.isChecked()) {
                        Genero = rbMasculino.getText().toString();
                    } else if (rbFemenino.isChecked()) {
                        Genero = rbFemenino.getText().toString();
                    }
                }
                Usuario usuario = new Usuario(Nombre, Apellido, Email, Contraseña, Genero, Telefono);
                MainActivity.listaUsuario.add(usuario);
                Toast.makeText(Registro.this,
                        "Nombre: " + Nombre + "\nApellido: " + Apellido + "\nEmail: " + Email + "\nContraseña: " + Contraseña + "\nGénero: " + Genero + "\nTeléfono: " + Telefono,
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Registro.this, MainActivity.class);
                startActivity(intent);







            }
        });


    }
    private boolean ValidarContraseña(){
        boolean valor= false;
        if( txtContraseña.getText().toString().equals(txtConContraseña.getText().toString())){
            valor = true;
        }
        return valor;
    }

    private static boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
}