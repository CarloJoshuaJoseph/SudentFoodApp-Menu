package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VendorOrCustomerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_or_customer_login);

        Button vendorBtn=(Button)findViewById(R.id.signup_button);
        Button custBtn= (Button)findViewById((R.id.signup_buttonCustomer)) ;
        vendorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VendorOrCustomerLogin.this,VendorLoginActivity.class));

            }
        });
        custBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VendorOrCustomerLogin.this,ClientLoginActivity.class));
            }
        });
    }
}