
package com.example.nombreapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editNombre;
    EditText editPassword;
    CheckBox checkRecordar;
    Button btnEntrar;
    TextView txtSaludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombre= findViewById(R.id.editNombre);
        editPassword= findViewById(R.id.editPassword);
        btnEntrar=findViewById(R.id.btnEntrar);
        checkRecordar=findViewById(R.id.checkRecordar);
        SharedPreferences prefs=getSharedPreferences("mis preferencias", Context.MODE_PRIVATE);
        editNombre.setText(prefs.getString("nombre",""));
        editPassword.setText(prefs.getString("contraseña",""));

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNombre = editNombre.getText().toString();
                String textoPass= editPassword.getText().toString();
                boolean correcto= true;

                if(textoNombre.isEmpty()){
                    editNombre.setError("Pon tu nombre");
                    correcto= false;
                }
                if(textoPass.isEmpty()){
                    editPassword.setError("Pon una contraseña");
                    correcto= false;
                }
                if(correcto){

                    Intent intent= new Intent(MainActivity.this,MenuActivity.class );
                    intent.putExtra("nombre",textoNombre);
                    startActivity(intent);
                }


                txtSaludo= findViewById(R.id.txtSaludo);
                final EditText editNombre= findViewById(R.id.editNombre);

                Button btnEntrar= findViewById(R.id.btnEntrar);
                btnEntrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtSaludo.setText(editNombre.getText().toString());
                        txtSaludo.setVisibility(View.VISIBLE);
                    }
                });

            }
        });

    }
}
