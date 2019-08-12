package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.knoxcorporation.knxbank.Entidades.Cliente;
import com.knoxcorporation.knxbank.Entidades.Cuenta;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    String codeSent;
    EditText names, lastNames,age,idNumber,password,phoneNumber,email;
    Button registerButton,toLoginButton;

    DatabaseReference databasereference;
    FirebaseDatabase firebaseDatabase;
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
        initializeFirebase();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DONE: Register User information and phone auth verification
                //DONE: Register User information in the database
                register();
                //Intent to VerificationActivity


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

    private void register() {
        String Nombre=names.getText().toString(),Apellido=lastNames.getText().toString(),Edad=age.getText().toString(),DNI=idNumber.getText().toString(),
                pass=password.getText().toString(),telefono=phoneNumber.getText().toString(),correo=email.getText().toString();
        Cliente user= new Cliente();
        user.setID(UUID.randomUUID().toString());
        user.setNombre(Nombre);
        user.setApellidos(Apellido);
        user.setEdad(Edad);
        user.setDNI(DNI);
        user.setClave(pass);
        user.setTelefono(telefono);
        user.setCorreo(correo);
        databasereference.child("Cliente").child(user.getID()).setValue(user);
        Toast.makeText(getApplicationContext(),"Agregado correctamente",Toast.LENGTH_LONG).show();
        verifyPhoneNumber();
    }
    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase=firebaseDatabase.getInstance();
        databasereference=firebaseDatabase.getReference();

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
