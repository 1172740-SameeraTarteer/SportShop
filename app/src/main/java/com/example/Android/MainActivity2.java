package com.example.Android;

import android.content.Intent;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("item_id");

        Items items = Items.Items[id];



        TextView type= findViewById(R.id.edtType);
        TextView name= findViewById(R.id.edtName);
        TextView desc= findViewById(R.id.edtDesc);
        TextView color= findViewById(R.id.edtColor);
        TextView size= findViewById(R.id.edtSize);



        name.setText(items.getName());
        type.setText(items.getType());
        desc.setText(items.getDescription());
        color.setText(items.getColor());
        size.setText(items.getSize());

//        year.setText(String.valueOf(items.getYear()));

    }
    public void btnBack(View view){
        Intent intent = new Intent(view.getContext(),
                MainActivity.class);
        startActivity(intent);

    }
}



