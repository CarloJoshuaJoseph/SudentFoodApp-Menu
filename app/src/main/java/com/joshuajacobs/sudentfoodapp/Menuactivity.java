package com.joshuajacobs.sudentfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menuactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        Button button =findViewById(R.id.snacksButton);
        Button button1 =findViewById(R.id.foodButton);
        Button button3 =findViewById(R.id.drinksButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menuactivity.this, FoodRecycler.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menuactivity.this, DrinkRecycler.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menuactivity.this, Snack_Recycler.class);
                startActivity(intent);
            }
        });
    }
}