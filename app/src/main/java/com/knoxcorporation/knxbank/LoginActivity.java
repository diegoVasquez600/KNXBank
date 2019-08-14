package com.knoxcorporation.knxbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.*;
import com.knoxcorporation.knxbank.Entidades.Cliente;
public class LoginActivity extends AppCompatActivity {
        EditText usuario,contrasena;
        Button btnlogin,btnregister;
        DatabaseReference databasereference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Intent de registro desde login
        initializeFirebase();
            btnregister = findViewById(R.id.btnRegister);
            btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent toRegister = new Intent(getApplicationContext(),RegisterActivity.class);
                    startActivity(toRegister);
                }
            });
        //Button login
            btnlogin= findViewById(R.id.btnLogin);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usuario= findViewById(R.id.registerDNI);
                    contrasena = findViewById(R.id.registerPassword);
                    final String user=usuario.getText().toString(),pass=contrasena.getText().toString();
                    //Busqueda de usuario
                    databasereference.orderByChild("telefono").equalTo(user).addValueEventListener(new ValueEventListener(){
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                           for (DataSnapshot child : dataSnapshot.getChildren()) {
                                final String model;
                                model = child.getValue(Cliente.class);
                                //Validacion usuario sea igual a edit text
                                if (!(model == user )) {
                                    //Busqueda clave
                                    databasereference.orderBychild("clave").equalto(pass).addValueEventListener(new ValueEventListener(){
                                        for (DataSnapshot child: datasnapshot.getChildren()){
                                            model=child.getValue(Cliente.class);
                                            //Validacion clave sea igual a edittext pass
                                            if (!(model==pass)){
                                                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(i);
                                            }else{
                                                Toast.makeText(getApplicationContext(),"Contraseña erronea",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }else{
                                    Toast.makeText(getApplicationContext(),"Usuario erroneo",Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });


                }
            });


    }

    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase=firebaseDatabase.getInstance();
        databasereference=firebaseDatabase.getReference();
    }
}
