package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.ManufacturerUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView Nombre, Contraseña, Registrate;
    private EditText txtNombre, txtContraseña;
    private Button btnIniciar, btnRegistro;
    public static ArrayList<Usuario> listaUsuario = new ArrayList();

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
        btnRegistro = findViewById(R.id.btnRegistrarse);




        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String contraseña = txtContraseña.getText().toString();

                int sizeLista = listaUsuario.size();
                if(sizeLista<1){
                    Toast.makeText(MainActivity.this, "No hay registros", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    for (int i = 0; i <= sizeLista; i++) {
                        String name = listaUsuario.get(i).getNombre();
                        String genre = listaUsuario.get(i).getGenero();
                        String password = listaUsuario.get(i).getContraseña();

                        if (nombre.equals(name)) {
                            if (contraseña.equals(password)) {
                                Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                                intent.putExtra("nombre", nombre);
                                intent.putExtra("genero", genre);
                                startActivity(intent);
                            } else {
                                txtContraseña.setError("Contraseña Incorrecta");
                            }

                        } else {
                            txtNombre.setError("Nombre Inválido");
                        }

                    }


                }
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