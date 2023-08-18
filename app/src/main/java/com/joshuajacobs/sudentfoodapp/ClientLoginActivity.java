package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientLoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    DBHelperClient DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlogin);

        username = (EditText) findViewById(R.id.client_login_email);
        password = (EditText) findViewById(R.id.client_login_password);
        btnlogin = (Button) findViewById(R.id.client_login_button);
        DB = new DBHelperClient(this);

        //button:
        Button myButton = findViewById(R.id.client_login_button);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(ClientLoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(ClientLoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ClientLoginActivity.this , MainActivity.class));
                    }else{
                        Toast.makeText(ClientLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void goToVendorLoginPage(View view) {
        Intent intent = new Intent(this, VendorLoginActivity.class);
        startActivity(intent);
    }
}
