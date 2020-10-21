package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class menuPrincipal5 extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal5);

        et_codigo = (EditText) findViewById(R.id.txt_codigo);
        et_descripcion = (EditText) findViewById(R.id.txt_descripcion);
        et_precio = (EditText) findViewById(R.id.txt_precio);
    }

    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscarr(View v) {
        Intent ds = new Intent(this, buscar.class);
        startActivity(ds);
    }

    public void editar(View vv) {
        Intent dss = new Intent(this, editar.class);
        startActivity(dss);
    }

    public void eliminar(View vvw) {
        Intent dsss = new Intent(this, eliminar.class);
        startActivity(dsss);

    }
}