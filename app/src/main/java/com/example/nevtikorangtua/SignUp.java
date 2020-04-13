package com.example.nevtikorangtua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText username, password;
    Button btnMake;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.SignUpText_1);
        password = findViewById(R.id.SignUpText_2);
        btnMake = findViewById(R.id.SignUpBtn_2);

        final String nameUser = username.getText().toString().trim();
        final String passwd = password.getText().toString().trim();

        reff  = FirebaseDatabase.getInstance().getReference().child("User");

        btnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(nameUser)) {
                            Toast.makeText(SignUp.this, "username already registered", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            reff = reff.child(nameUser);
                            reff.setValue(passwd);
                            reff.push();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
