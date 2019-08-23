package com.knoxcorporation.knxbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.knoxcorporation.knxbank.Adapters.CountryData;
import com.knoxcorporation.knxbank.Entidades.Cliente;

public class LoginActivity extends AppCompatActivity {
       EditText loginPhoneNumber, loginPassword;
       Spinner country;
   // private Button buttonLogin, buttonToRegister;
    DatabaseReference databasereference;
    FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*country =(Spinner) findViewById(R.id.spinnerCode);
        country.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
         */
        findViewById(R.id.buttonToRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent to RegisterActivity
                Intent toRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toRegister);
                finish();
            }
        });
       findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaciontel();
                //TODO: Get password from Firebase and validate if is correct
                //If password and number validations are correct Intent to VerificationActivity

            }
        });
    }

    private void loginfirebase() {
       final String areaCode = CountryData.countryAreaCodes[country.getSelectedItemPosition()];
       final String phone = "+" +areaCode+ LoginActivity.this.loginPhoneNumber.getText().toString();
       final String password = loginPassword.getText().toString();
       final String[] model = new String[1];

        //validacion telefono firebase
        initializeFirebase();
        databasereference.orderByChild("Cliente").equalTo(phone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()){
                    Cliente model=child.getValue(Cliente.class);
                    if (model.equals(phone)){
                        databasereference.orderByChild("Cliente").equalTo(password).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot child: dataSnapshot.getChildren()){
                                    Cliente model=child.getValue(Cliente.class);
                                    if (model.equals(password)){
                                        Intent toVerification = new Intent(getApplicationContext(), VerificationActivity.class);
                                        toVerification.putExtra("phoneNumber", phone);
                                        startActivity(toVerification);
                                        finish();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databasereference = firebaseDatabase.getReference();

    }

    private void verificaciontel() {
        String areaCode = CountryData.countryAreaCodes[country.getSelectedItemPosition()];
        String phone = "+" +areaCode+ LoginActivity.this.loginPhoneNumber.getText().toString();
        //Conditional if phone is empty
        String phoneError = getResources().getString(R.string.phoneError);
        String phonelength = getResources().getString(R.string.phonelenght);
        if (phone.isEmpty()){
            LoginActivity.this.loginPhoneNumber.setError(phoneError);
            loginPhoneNumber.requestFocus();
            return;
        }if (phone.length() < 10){
            loginPhoneNumber.setError(phonelength);
            loginPhoneNumber.requestFocus();
            return;
        }
        String password = loginPassword.getText().toString();
        if (password.isEmpty()){
            loginPassword.setError("Error");
            loginPassword.requestFocus();
            return;
        }else{
            loginfirebase();
        }

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
