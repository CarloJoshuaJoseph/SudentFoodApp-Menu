package com.joshuajacobs.sudentfoodapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class OrderExtendedActivity extends AppCompatActivity {

    private Button ProceedToPaymentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_extended);

        ProceedToPaymentBtn = findViewById(R.id.proceedPayment);

        ProceedToPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the functionality for proceeding to payment
                startActivity(new Intent(OrderExtendedActivity.this,CardFormActivity.class));
            }
        });
    }

    private void proceedToPayments() {
        // Logic to proceed view order screen
        Toast.makeText(this, "Order confirmed! Proceeding to payments", Toast.LENGTH_SHORT).show();
    }
}
