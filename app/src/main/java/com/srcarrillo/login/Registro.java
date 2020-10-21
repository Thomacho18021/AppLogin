package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;

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
                if(txtNombre.getText().toString().length()<3){
                    txtNombre.setError("Mínimo 3 Caracteres");
                    return;

                }else if(txtApellido.getText().toString().length()<4){
                    txtApellido.setError("Mínimo 4 Caracteres");
                    return;

                }else if(ValidarMail(txtEmail.getText().toString())==false){
                    txtEmail.setError("Email inválido");
                    return;

                }else /*if(txtConContraseña.getText().toString().trim() != txtContraseña.getText().toString().trim()){
                    txtConContraseña.setError("Contraseña No Coincide");
                    Toast.makeText(Registro.this, "Contraseña 1: "+txtContraseña.getText().toString()+"\nContraseña 2: "+txtConContraseña.getText().toString(), Toast.LENGTH_LONG).show();
                    return;

                }else*/ if(txtTelefono.getText().toString().length()<12){
                    txtTelefono.setError("Teléfono Inválido");
                    return;

                }else if((rbMasculino.isSelected()==false) && (rbFemenino.isSelected()==false)){
                    rbFemenino.setError("Selecciona un Género");
                    return;

                }else{
                    String Nombre = txtNombre.getText().toString();
                    String Apellido = txtApellido.getText().toString();
                    String Email = txtEmail.getText().toString();
                    String Contraseña = txtContraseña.getText().toString();
                    String Telefono = txtTelefono.getText().toString();
                    String Genero = "";
                    if(rbMasculino.isSelected()){
                        Genero = toString().valueOf(rbMasculino);
                    } else if(rbFemenino.isSelected()){
                        Genero = toString().valueOf(rbFemenino);
                    }
                    Usuario usuario = new Usuario(Nombre,Apellido,Email,Contraseña,Genero,Telefono);
                    MainActivity.listaUsuario.add(usuario);
                    Toast.makeText(Registro.this,
                            "Nombre: "+ Nombre+"\nApellido: "+Apellido+"\nEmail: "+Email+"\nContraseña: "+Contraseña+"\nGénero: "+Genero+"\nTeléfono: "+Telefono ,
                            Toast.LENGTH_LONG).show();

                }




            }
        });


    }
    private boolean ValidarContraseña(String Contraseña, String ConContraseña){
        if(Contraseña == ConContraseña){
            return true;
        }else {
            return false;
        }
    }

    private static boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
}