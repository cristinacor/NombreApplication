package com.example.nombreapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.design.widget.Snackbar;


public class NotificacionesActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnToast;
    Button btnSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        btnToast=findViewById(R.id.btnToast);
        btnSnack=findViewById(R.id.btnSnack);


        btnToast.setOnClickListener(this);
        btnSnack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button botonpulsar=(Button) v;

        if(botonpulsar==btnToast){

            Toast.makeText(this,"Has pulsado el botón "+ botonpulsar.getText(),Toast.LENGTH_LONG);
            Intent intent= new Intent(NotificacionesActivity.this,
                    NotificacionesActivity.class);
            startActivity(intent);


        }
        if(botonpulsar==btnSnack) {
            Snackbar.make(v,"Es un Snackbarr",Snackbar.LENGTH_LONG).show();

        }
    }
}
