package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CodigoPin3 extends AppCompatActivity {
    private EditText ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_pin3);
        ingresar = (EditText)findViewById(R.id.id_ingreseContraseña);

    }
    public void verificar_contraseña (View v){
        String ingresarr = ingresar.getText().toString();
        int ingrese_codigo = Integer.parseInt(ingresarr);

        if (ingresarr.equals("12345")){
            Intent entrar = new Intent(this, cargando4.class);
            startActivity(entrar);
        }else{
            Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
        }
    }
}

