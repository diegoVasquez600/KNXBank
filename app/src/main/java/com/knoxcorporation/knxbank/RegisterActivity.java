package com.knoxcorporation.knxbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.knoxcorporation.knxbank.Adapters.CountryData;
import com.knoxcorporation.knxbank.Entidades.Cliente;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText names, lastNames,age,idNumber,password,phoneNumber,email;
    Spinner countryCodes;
    Button registerButton,toLoginButton;
    ProgressBar loading;
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
        countryCodes = findViewById(R.id.countryCodes);
        email = findViewById(R.id.registerEmail);
        registerButton = findViewById(R.id.buttonRegister);
        loading = findViewById(R.id.progressBar);
        toLoginButton = findViewById(R.id.buttonToLogin);
        loading.setVisibility(View.INVISIBLE);
        registerButton.setVisibility(View.VISIBLE);
        countryCodes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        initializeFirebase();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DONE: Register User information and phone auth verification
                //DONE: Register User information in the database
                //Area Code Method()
                registerButton.setVisibility(View.INVISIBLE);
                loading.setVisibility(View.VISIBLE);
                areaCode();
                register();
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

    private void areaCode() {
        String code = CountryData.countryAreaCodes[countryCodes.getSelectedItemPosition()];
        String phone = phoneNumber.getText().toString().trim();
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
        //phoneNumber
        String numberPhone = "+" + code + phone;
        Toast.makeText(getApplicationContext(),"Agregado correctamente",Toast.LENGTH_LONG).show();
        //Intent to VerificationActivity
        Intent toVerify = new Intent(getApplicationContext(), VerificationActivity.class);
        toVerify.putExtra("phoneNumber", numberPhone);
        startActivity(toVerify);
    }


    //Method register
    private void register() {
        String Nombre = names.getText().toString(),Apellido = lastNames.getText().toString(),Edad = age.getText().toString(),DNI = idNumber.getText().toString(),
                pass = password.getText().toString(),telefono = phoneNumber.getText().toString(),correo = email.getText().toString();
        Cliente user = new Cliente();
        user.setID(UUID.randomUUID().toString());
        user.setNombre(Nombre);
        user.setApellidos(Apellido);
        user.setEdad(Edad);
        user.setDNI(DNI);
        user.setClave(pass);
        user.setTelefono(telefono);
        user.setCorreo(correo);
        databasereference.child("Cliente").child(user.getID()).setValue(user);
    }

    //Realtime Database Method()
    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databasereference = firebaseDatabase.getReference();

    }



}
