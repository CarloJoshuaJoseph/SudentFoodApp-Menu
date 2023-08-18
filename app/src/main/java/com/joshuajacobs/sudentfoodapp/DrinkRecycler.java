package com.joshuajacobs.sudentfoodapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DrinkRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DrinkItemActivity> drinkItemActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeDrinkItems();

        DrinkAdapter adapter = new DrinkAdapter(drinkItemActivityList, this);
        recyclerView.setAdapter(adapter);

        Button proceedToOrderBtn = findViewById(R.id.ProceedToOrderButton);

        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrinkRecycler.this, OrderActivity.class));
            }
        });


    }
    public void saveDrinkToDatabase(DrinkItemActivity drinkItemActivity) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", drinkItemActivity.getDrinkName());
        values.put("price", drinkItemActivity.getDrinkPrice());

        long newRowId = db.insert("drinks", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Drink added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add drink to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }


    private void initializeDrinkItems() {
        drinkItemActivityList = new ArrayList<>();
        drinkItemActivityList.add(new DrinkItemActivity("Water", R.drawable.water_image, 5));
        drinkItemActivityList.add(new DrinkItemActivity("Fanta", R.drawable.fanta_image, 10));
        drinkItemActivityList.add(new DrinkItemActivity("Coke", R.drawable.coke_image, 10));
        drinkItemActivityList.add(new DrinkItemActivity("Pepsi", R.drawable.pepsi_image, 10));
        drinkItemActivityList.add(new DrinkItemActivity("Oros", R.drawable.oros_image, 8));
        drinkItemActivityList.add(new DrinkItemActivity("Caprisun", R.drawable.caprisun_image, 15));
    }


}
