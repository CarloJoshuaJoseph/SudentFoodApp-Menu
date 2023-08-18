package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VendorOrCustomerSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_or_customer_signup);

        Button vendorBtn=(Button)findViewById(R.id.signup_button);
        vendorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VendorOrCustomerSignUp.this, VendorSignUpActivity.class));

            }
        });

        Button clientBtn = (Button) findViewById(R.id.signup_buttonCustomer);
        clientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VendorOrCustomerSignUp.this,ClientSignUpActivity.class));
            }
        });
    }
}