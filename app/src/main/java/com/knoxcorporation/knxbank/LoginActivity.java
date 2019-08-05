package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.knoxcorporation.knxbank.Databases.*;

public class LoginActivity extends AppCompatActivity {
        EditText usuario,contrasena;
        Button btnlogin,btnregister;
        conexionsqlitehelper helper=new conexionsqlitehelper(this,"knxcBankdb",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Intent de registro desde login
            btnregister=(Button)findViewById(R.id.btnRegister);
            btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getApplicationContext(),RegisterActivity.class);
                    startActivity(i);
                }
            });
        //Button login
            btnlogin=(Button)findViewById(R.id.btnLogin);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usuario=(EditText) findViewById(R.id.registerDNI);
                    contrasena=(EditText) findViewById(R.id.registerPassword);
                    try{
                        //Metodo en conexion para la busqueda de los registros
                        Cursor cursor= helper.Consultarusuario(usuario.getText().toString(),contrasena.getText().toString());
                        //Validacion si registro existe
                        if(cursor.getCount()>0){
                            Intent i=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(),"Usuario o contraseña invalido",Toast.LENGTH_LONG).show();
                        }
                        usuario.setText("");
                        contrasena.setText("");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            });


    }
}
