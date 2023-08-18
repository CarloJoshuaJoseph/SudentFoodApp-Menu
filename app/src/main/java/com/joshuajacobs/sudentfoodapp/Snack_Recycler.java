package com.joshuajacobs.sudentfoodapp;

import static android.widget.Toast.makeText;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Snack_Recycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<SnackItemActivity> snackItemActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_activity);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the snack items
        initializeSnackItems();

        // Set up the RecyclerView adapter
        SnackAdapter adapter = new SnackAdapter(snackItemActivityList, this);
        recyclerView.setAdapter(adapter);

        // Get the "Proceed to Order" button
        Button proceedToOrderBtn = findViewById(R.id.ProceedToOrderButton);

        // Set an OnClickListener for the button
        proceedToOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the OrderActivity
                startActivity(new Intent(Snack_Recycler.this, OrderActivity.class));
            }
        });
    }

    private void initializeSnackItems() {
        snackItemActivityList = new ArrayList<>();
        snackItemActivityList.add(new SnackItemActivity("Fruit and Nut chocolate", R.drawable.fruitnut_image, 20));
        snackItemActivityList.add(new SnackItemActivity("Lays chips", R.drawable.chips_image, 10));
        snackItemActivityList.add(new SnackItemActivity("Biscuit", R.drawable.oreo_image, 15));
        snackItemActivityList.add(new SnackItemActivity("KitKat", R.drawable.kitkat_image, 25));  // New snack item
        snackItemActivityList.add(new SnackItemActivity("Bubblegum", R.drawable.bubblegum_image, 5));  // New snack item
        snackItemActivityList.add(new SnackItemActivity("M&Ms", R.drawable.mms_image, 30));  // New snack item
        snackItemActivityList.add(new SnackItemActivity("Sour Patch Kids", R.drawable.sourpatch_image, 12));  // New snack item
    }

    public void saveSnackToDatabase(SnackItemActivity snackItemActivity) {
        menuDatabaseHelper dbHelper = new menuDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", snackItemActivity.getName());
        values.put("price", snackItemActivity.getPrice());

        long newRowId = db.insert("snacks", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Snack added to basket", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add snack to basket", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}
