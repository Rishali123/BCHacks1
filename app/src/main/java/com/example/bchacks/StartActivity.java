package com.example.bchacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartActivity extends AppCompatActivity
{

    Button HomeLoginButton;
    Button HomeSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        HomeLoginButton = findViewById(R.id.HomeLoginButton);
        HomeSignupButton = findViewById(R.id.HomeSignUpButton);

        HomeLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        HomeSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}