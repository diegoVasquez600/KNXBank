package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.auth.FirebaseAuth;
import com.knoxcorporation.knxbank.Adapters.CountryData;

public class LoginActivity extends AppCompatActivity {
       EditText loginPhoneNumber, loginPassword;
       Spinner countryCodes;
       Button buttonLogin, buttonToRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countryCodes = findViewById(R.id.countryCode);
        countryCodes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        buttonToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent to RegisterActivity
                Intent toRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toRegister);
                finish();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String areaCode = CountryData.countryAreaCodes[countryCodes.getSelectedItemPosition()];
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
                //TODO: Get password from Firebase and validate if is correct
                //If password and number validations are correct Intent to VerificationActivity
                Intent toVerification = new Intent(getApplicationContext(), VerificationActivity.class);
                toVerification.putExtra("phoneNumber", phone);
                startActivity(toVerification);
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
