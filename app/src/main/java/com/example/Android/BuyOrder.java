package com.example.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.TextView;

public class BuyOrder extends AppCompatActivity {
    TextView txtprice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_order);
        Intent intent1 = getIntent();

        double price = intent1.getExtras().getDouble("price");
        txtprice = findViewById(R.id.totalPrice);
        txtprice.setText("Total Price: "+String.valueOf(price));
    }
}