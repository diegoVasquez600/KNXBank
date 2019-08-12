package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    String codeSent;
    EditText names, lastNames,age,idNumber,password,phoneNumber,email;
    Button registerButton,toLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register);
        names = findViewById(R.id.registerFistname);
        lastNames = findViewById(R.id.registerLastname);
        age = findViewById(R.id.registerYears);
        idNumber = findViewById(R.id.registerDNI);
        password = findViewById(R.id.registerPassword);
        phoneNumber = findViewById(R.id.registerPhone);
        email = findViewById(R.id.registerEmail);
        registerButton = findViewById(R.id.buttonRegister);
        toLoginButton = findViewById(R.id.buttonToLogin);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Register user information and phone auth verification
                verifyPhoneNumber();
            }
        });
        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(toLogin);
                finish();
            }
        });

    }

    private void verifyPhoneNumber() {
        //TODO: verifyPhoneNumber Method
        //To string from EditText
        String phone = phoneNumber.getText().toString();
        //Conditional if phone is empty
        String phoneError = getResources().getString(R.string.phoneError);
        String phonelength = getResources().getString(R.string.phonelenght);
        if (phone.isEmpty()){
            phoneNumber.setError(phoneError);
            phoneNumber.requestFocus();
            return;
        }if (phone.length() < 10){
            phoneNumber.setError(phonelength);
            phoneNumber.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
        }
    };

}
