package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class LoginActivity extends AppCompatActivity {
        EditText usuario,contrasena;
        Button btnlogin,btnregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Intent de registro desde login
            btnregister = findViewById(R.id.btnRegister);
            btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent toRegister = new Intent(getApplicationContext(),RegisterActivity.class);
                    startActivity(toRegister);
                }
            });
        //Button login
            btnlogin= findViewById(R.id.btnLogin);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usuario= findViewById(R.id.registerDNI);
                    contrasena = findViewById(R.id.registerPassword);

                }
            });


    }
}
