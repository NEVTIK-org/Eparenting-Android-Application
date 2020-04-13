package com.example.nevtikorangtua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginAs extends AppCompatActivity implements View.OnClickListener {

    Button sbgOrangTua, sbgAnak;
    TextView logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);

        sbgOrangTua = findViewById(R.id.LoginAsBtn_1);
        sbgOrangTua.setOnClickListener(this);
        sbgAnak = findViewById(R.id.LoginAsBtn_2);
        sbgAnak.setOnClickListener(this);
        logIn = findViewById(R.id.LoginAsText_3);
        logIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.LoginAsBtn_1) {

        } else if (v.getId() == R.id.LoginAsBtn_2) {

        } else if (v.getId() == R.id.LoginAsText_3) {
            Intent sigin = new Intent(LoginAs.this, SignIn.class);
            startActivity(sigin);
        }
    }
}
