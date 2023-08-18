package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientSignUpActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    DBHelperClient DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_signup);

        username = (EditText) findViewById(R.id.client_signup_email);
        password = (EditText) findViewById(R.id.client_signup_password);
        repassword = (EditText) findViewById(R.id.client_signup_confirm);
        signup = (Button) findViewById(R.id.client_signup_button);
        DB = new DBHelperClient(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(ClientSignUpActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(ClientSignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),ClientLoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(ClientSignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(ClientSignUpActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ClientSignUpActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }

    public void goToClientLoginPage(View view) {
        Intent intent = new Intent(this, ClientLoginActivity.class);
        startActivity(intent);
    }
}
