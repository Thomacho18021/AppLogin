package com.srcarrillo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {
    private ImageView imagen;
    private TextView MenuTitle;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        imagen = findViewById(R.id.imagen);
        MenuTitle = findViewById(R.id.MenuTitle);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        setTitulo();




        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setTitulo(){
        Bundle extra = getIntent().getExtras();
        if(extra.get("genero")=="Masculino"){
            MenuTitle.setText("Bienvenido Sr. "+extra.get("nombre"));
        }else{
            MenuTitle.setText("Bienvenida Srta. "+extra.get("nombre"));
        }
    }
}