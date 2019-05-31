package com.example.nombreapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity {
    TextView txtSaludo;
    Button btnNotificaciones;
    Button btnListado;
    Button btnListadoNotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtSaludo= findViewById(R.id.txtSaludo);
        btnListado= findViewById(R.id.btnListado);
        btnListadoNotas=findViewById(R.id.btnListadoNotas);

        Bundle extras = getIntent().getExtras();
        String nombre=extras.getString("nombre","sin nombre");

        txtSaludo.setText(" Hola "+ nombre );


        btnNotificaciones =findViewById(R.id.btnNotificaciones);
        btnNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(MenuActivity.this,NotificacionesActivity.class);
                startActivity(in);




            }
        });

    }



}
