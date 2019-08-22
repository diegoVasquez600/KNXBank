package com.knoxcorporation.knxbank;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
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
import android.widget.TextView;

public class WalletActivity extends AppCompatActivity {
    TextView Name,currentbalance,currentbalancetxt,receivedmoney,receivedmoneytxt,sentmoney,sentmoneytxt,generaltxt;
    Bundle phone;

    DatabaseReference databasereference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // Drawable originalDrawable = getResources().getDrawable();

        FloatingActionButton fab = findViewById(R.id.fabAddAccount);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Name=findViewById(R.id.campoNombre);
        currentbalance=findViewById(R.id.currentBalance);
        currentbalancetxt=findViewById(R.id.currentBalanceText);
        receivedmoney=findViewById(R.id.receivedMoney);
        receivedmoneytxt=findViewById(R.id.ReceivedText);
        sentmoney=findViewById(R.id.sentMoney);
        sentmoneytxt=findViewById(R.id.SentText);
        generaltxt=findViewById(R.id.generalText);
        //traigo el intent y verifico en firebase
        phone=getIntent().getExtras();
        final String user=phone.getString("phoneNumber");
        initializeFirebase();
        databasereference.child("Cliente").equalTo(user).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child:dataSnapshot.getChildren()){
                    Cliente model=child.getValue(Cliente.class);
                    if (model.equals(user)){
                        String nombre=dataSnapshot.child("nombre").getValue().toString();
                        Name.setText(nombre);
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

}
