package com.knoxcorporation.knxbank;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.knoxcorporation.knxbank.Entidades.Cliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class WalletActivity extends AppCompatActivity {
    TextView Name,currentbalance,currentbalancetxt,receivedmoney,receivedmoneytxt,sentmoney,sentmoneytxt,generaltxt;
    Bundle phone;
    //Toolbar toolbar = findViewById(R.id.toolbar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        findViewById(R.id.logOutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent toLogin = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toLogin);
                finish();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fabAddAccount);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tonewAccount = new Intent(getApplicationContext(), NewAccountActivity.class);
                startActivity(tonewAccount);
            }
        });

    }

}
