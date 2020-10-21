package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class cargando4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargando4);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inti = new Intent(cargando4.this, menuPrincipal5.class);
                startActivity(inti);
            }
        }, 4000);
    }





}

