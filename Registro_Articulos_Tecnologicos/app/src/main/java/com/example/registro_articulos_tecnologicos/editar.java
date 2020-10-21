
package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class editar extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        et_codigo = (EditText)findViewById(R.id.id_codigoEditar);
        et_descripcion = (EditText)findViewById(R.id.id_descripcionEditar);
        et_precio = (EditText)findViewById(R.id.id_precioEditar);
    }
    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = BaseDatabase.update("articulos", registro, "codigo=" + codigo, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "Artículo modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void atras (View v){
        Intent atas = new Intent(this,menuPrincipal5.class);
        startActivity(atas);
    }
}