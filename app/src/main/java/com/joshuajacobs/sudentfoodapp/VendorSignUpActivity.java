package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VendorSignUpActivity extends AppCompatActivity {

    EditText username, restaurantName, password, repassword;
    Button signup;
    DBHelperVendor DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_signup);

        username = (EditText) findViewById(R.id.vendor_signup_email);
        restaurantName = (EditText) findViewById(R.id.vendor_signup_restaurantName);
        password = (EditText) findViewById(R.id.vendor_signup_password);
        repassword = (EditText) findViewById(R.id.vendor_signup_confirmPassword);
        signup = (Button) findViewById(R.id.vendor_signup_button);
        DB = new DBHelperVendor(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String restuName = restaurantName.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||restuName.equals(""))
                    Toast.makeText(VendorSignUpActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, restuName, pass);
                            if(insert==true){
                                Toast.makeText(VendorSignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),VendorLoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(VendorSignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(VendorSignUpActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(VendorSignUpActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }
    public void goTOVendorLogin(View view) {
        Intent intent = new Intent(this, VendorLoginActivity.class);
        startActivity(intent);
    }
}