package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HuellaOpin2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huella_opin2);

    }
   public void pin (View v){
        Intent sif = new Intent(this,CodigoPin3.class);
        startActivity(sif);
    }
}