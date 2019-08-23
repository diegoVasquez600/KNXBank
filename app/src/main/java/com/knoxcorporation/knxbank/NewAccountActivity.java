package com.knoxcorporation.knxbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.knoxcorporation.knxbank.Adapters.CountryData;

public class NewAccountActivity extends AppCompatActivity {
    Spinner countryDatos;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        countryDatos = findViewById(R.id.spinnerCountryData);
        countryDatos.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
        String areacode = CountryData.countryAreaCodes[countryDatos.getSelectedItemPosition()];
        phoneNumber = findViewById(R.id.accountNumberPhone);
        String phone = phoneNumber.getText().toString();
        String accountNumber = "+" + areacode + phone;
    }
}
