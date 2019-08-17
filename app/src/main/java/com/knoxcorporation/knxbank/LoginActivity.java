package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
       EditText loginPhoneNumber, loginPassword;
       Button buttonLogin, buttonToRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent to RegisterActivity
                Intent toRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toRegister);
                finish();
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
