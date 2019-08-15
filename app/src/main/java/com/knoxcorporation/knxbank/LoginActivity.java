package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.auth.FirebaseAuth;

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
                Intent toRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toRegister);
            }
        });
        //Button login
        btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = findViewById(R.id.registerDNI);
                contrasena = findViewById(R.id.registerPassword);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent toWallet = new Intent(getApplicationContext(), WalletActivity.class);
            //Kill all other Activities by D'V
            toWallet.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(toWallet);
        }
    }
}
