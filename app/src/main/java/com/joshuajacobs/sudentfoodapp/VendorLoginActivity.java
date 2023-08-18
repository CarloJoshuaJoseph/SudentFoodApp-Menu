package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VendorLoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    DBHelperVendor DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_login);

        username = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        btnlogin = (Button) findViewById(R.id.login_button);
        DB = new DBHelperVendor(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(VendorLoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(VendorLoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(VendorLoginActivity.this , VendorHomePage.class));
                    }else{
                        Toast.makeText(VendorLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void goTOVendorSignUp(View view) {
        Intent intent = new Intent(this, VendorSignUpActivity.class);
        startActivity(intent);
    }
}
