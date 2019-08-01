package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import com.knoxcorporation.knxbank.Databases.conexionsqlitehelper;
import com.knoxcorporation.knxbank.utilidades.utilidades;

public class RegisterActivity extends AppCompatActivity {
    EditText Nombre,apellido,edad,DNI,contrasena,email;
    private Button registrar=findViewById(R.id.buttonRegister);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //
        Nombre=findViewById(R.id.registerFistname);
        apellido=findViewById(R.id.registerLastname);
        edad=findViewById(R.id.registerYears);
        DNI=findViewById(R.id.registerDNI);
        contrasena=findViewById(R.id.registerPassword);
        email=findViewById(R.id.registerPassword);

        registrar = new Button(this);
        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });



        };





    }

    private void registrarUsuario() {
        conexionsqlitehelper conn= new conexionsqlitehelper(this,"knxcBankdb",null,1 );
        SQLiteDatabase open=conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(utilidades.CAMPO_DNI,DNI.getText().toString());
        values.put(utilidades.CAMPO_NOMBRE,Nombre.getText().toString());
        values.put(utilidades.CAMPO_APELLIDOS,apellido.getText().toString());
        values.put(utilidades.CAMPO_CLAVE,contrasena.getText().toString());
        values.put(utilidades.CAMPO_EDAD,edad.getText().toString());
        values.put(utilidades.CAMPO_EMAIL,email.getText().toString());
    }
}
