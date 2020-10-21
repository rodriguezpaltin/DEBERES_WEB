package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class buscar extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        et_codigo = (EditText) findViewById(R.id.id_codigoo);
        et_descripcion = (EditText) findViewById(R.id.id_descripcion);
        et_precio = (EditText) findViewById(R.id.id_precio);
    }

    public void Buscar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);

            if (fila.moveToFirst()) {
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this, "No existe el artículo", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }

    public void atras(View e) {
        Intent ppa = new Intent(this, menuPrincipal5.class);
        startActivity(ppa);

    }


}