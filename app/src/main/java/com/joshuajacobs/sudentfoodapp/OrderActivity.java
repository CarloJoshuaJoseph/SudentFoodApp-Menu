package com.joshuajacobs.sudentfoodapp;

import static android.widget.Toast.makeText;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private Button buttonRemoveItem;
    private Button placeOrderBtn;
    private EditText editTextName;
    private OrderDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        buttonRemoveItem = findViewById(R.id.buttonRemoveItem);
        placeOrderBtn = findViewById(R.id.placeOrder);
        editTextName = findViewById(R.id.editTextTextPersonName);

        dbHelper = new OrderDatabaseHelper(this);

        buttonRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for removing an item
                removeItem();
            }
        });

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for placing order
                placeOrder();
            }
        });
    }

    private void removeItem() {
        // Logic to remove an item from the order
        makeText(this, "Item removed from the order", Toast.LENGTH_SHORT).show();
    }

    private void placeOrder() {
        String name = editTextName.getText().toString().trim();

        if (name.isEmpty()) {
            makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get an instance of the database in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("name", name);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert("orders", null, values);

        if (newRowId == -1) {
            makeText(this, "Error occurred while placing the order", Toast.LENGTH_SHORT).show();
        } else {
            makeText(this, "Order placed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(OrderActivity.this, OrderExtendedActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}
