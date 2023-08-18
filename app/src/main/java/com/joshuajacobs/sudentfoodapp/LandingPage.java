package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        Button sign = findViewById(R.id.sign_up_btn);
        Button sign2=findViewById(R.id.signInBtn);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this , VendorOrCustomerSignUp.class));
            }


        });
        sign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this,VendorOrCustomerLogin.class));
            }
        });
    }}
