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

public class SignIn extends AppCompatActivity {
    EditText userText, passText;
    Button btnSignIn;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userText = findViewById(R.id.SignInText_1);
        passText = findViewById(R.id.SignInText_2);
        btnSignIn = findViewById(R.id.SignInBtn_1);

        reff = FirebaseDatabase.getInstance().getReference().child("User");

    }

    @Override
    protected void onStart() {
        super.onStart();

        final String username = userText.getText().toString().trim();
        final String password = passText.getText().toString().trim();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(username) && dataSnapshot.child(username).getValue() == password){
                            Intent home = new Intent(getApplicationContext(), Home.class);
                            home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(home);
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
