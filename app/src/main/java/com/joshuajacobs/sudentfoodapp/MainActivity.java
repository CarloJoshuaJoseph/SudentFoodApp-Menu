package com.joshuajacobs.sudentfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        ImageButton backB = findViewById(R.id.backB);
        ImageButton logOutB = findViewById(R.id.logOutB);
        ImageButton profileB = findViewById(R.id.profileB);

        CardView spinningWheelCard = findViewById(R.id.spinningWheelCard);
        CardView trackdeliveryCard = findViewById(R.id.trackdeliveryCard);
        CardView projectsCard = findViewById(R.id.projectsCard);
        CardView paymentsCard = findViewById(R.id.paymentsCard);
        CardView calenderCard = findViewById(R.id.calenderCard);
        CardView settingsCard = findViewById(R.id.settingsCard);

        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        logOutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        profileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });

        spinningWheelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { SpinningWheel(); }

        });

        trackdeliveryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Track Delivery", Toast.LENGTH_SHORT).show();
                {testsc();}
            }
        });

        projectsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Projects", Toast.LENGTH_SHORT).show();
                {testsc();}
            }
        });

        paymentsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Payments", Toast.LENGTH_SHORT).show();
                {testsc();}
            }
        });

        calenderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Calender", Toast.LENGTH_SHORT).show();
                {calendarsc();}
            }
        });

        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                {settingssc();}

            }
        });
    }
    public void SpinningWheel() {
        Intent intent = new Intent(this, SpinningWheel.class);
        startActivity(intent);
    }
    public void settingssc() {
        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(i);
    }
    //public void projectssc(){
    //    Intent intent2 = new Intent(MainActivity.this, Vendors.class);
    //    startActivity(intent2);
    //}
    public void calendarsc(){
        Intent intent3 = new Intent(MainActivity.this, Calendar.class);
        startActivity(intent3);
    }
    //public void paymentssc(){
    //    Intent intent4 = new Intent(MainActivity.this, Payments.class);
    //    startActivity(intent4);
    //}
    public void testsc(){
        Intent intent5 = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent5);
    }
}
