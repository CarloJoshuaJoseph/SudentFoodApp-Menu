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

public class FoodRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<FoodItemActivity> foodItemActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeFoodItems();

        FoodAdapter adapter = new FoodAdapter(foodItemActivityList, this);
        recyclerView.setAdapter(adapter);


        Button proceedToOrderBtn = findViewById(R.id.ProceedToOrderButton);


        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(FoodRecycler.this, OrderActivity.class));
            }
        });
    }
    public void saveFoodToDatabase(FoodItemActivity foodItemActivity) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", foodItemActivity.getName());
        values.put("price", foodItemActivity.getPrice());

        long newRowId = db.insert("snacks", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Food added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add food to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void initializeFoodItems() {
        foodItemActivityList = new ArrayList<>();
        foodItemActivityList.add(new FoodItemActivity("Burger", R.drawable.burger_image, 8));
        foodItemActivityList.add(new FoodItemActivity("Pizza", R.drawable.pizza_image, 12));
        foodItemActivityList.add(new FoodItemActivity("Vetkoek", R.drawable.vetkoek_image, 12));
        foodItemActivityList.add(new FoodItemActivity("Hot Chips", R.drawable.chips, 12));
        foodItemActivityList.add(new FoodItemActivity("Koeksisters", R.drawable.donuts_image, 12));
    }

    // ... other methods
}
