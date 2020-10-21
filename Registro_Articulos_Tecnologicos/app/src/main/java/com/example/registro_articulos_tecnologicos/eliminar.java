package com.example.registro_articulos_tecnologicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class eliminar extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        et_codigo=(EditText)findViewById(R.id.id_codigoEliminar);
        et_descripcion=(EditText)findViewById(R.id.id_nombreEliminar);
        et_precio=(EditText)findViewById(R.id.id_precioEliminar);

    }

    //Método para eliminar un producto o Artículo
    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad = BaseDatabase.delete("articulos", "codigo=" + codigo, null);
            BaseDatabase.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Artículo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }
    public void atras (View b){
        Intent pa = new Intent(this,menuPrincipal5.class);
        startActivity(pa);
    }

    //Método para modificar un artículo o producto


}