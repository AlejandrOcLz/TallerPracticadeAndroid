package com.example.taller1_corte2;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText etuser, etpass;
    Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = findViewById(R.id.editTextTextPersonName);
        etpass = findViewById(R.id.editTextTextPassword);

        inicio = findViewById(R.id.button);

        inicio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                if(etuser.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(),"Por favor ingrese un usuario", Toast.LENGTH_LONG).show();
                }else{
                    if(etpass.getText().toString().matches("")){
                        Toast.makeText(getApplicationContext(),"Por favor ingrese una contraseña", Toast.LENGTH_LONG).show();
                    }else{
                        Intent sesion = new Intent(getApplicationContext(),InicioSesionB.class);
                        Bundle data = new Bundle();
                        data.putString("name",etuser.getText().toString());
                        sesion.putExtras(data);
                        startActivity(sesion);
                        onDestroy();
                    }
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}