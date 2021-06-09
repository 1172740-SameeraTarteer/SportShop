
package com.example.Android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        Intent intent = getIntent();
//        int id = Integer.parseInt(intent.getExtras().getString("selectedId"));
//        String color = intent.getExtras().getString("color");
//        String size = intent.getExtras().getString("size");
//
//       ArrayList<Items> items = new ArrayList<>();
//        items.add(new Items(id,items.get(id).getName(),color,items.get(id).getPrice(),items.get(id).getImageID())) ;
//        RecyclerView recycler = (RecyclerView)findViewById(R.id.shop_recycler);
//
//        String[] captions = new String[items.size()];
//        int[] ids = new int[items.size()];
//        int[] price = new int[items.size()];
//        String[] rating = new String[items.size()];
//
//        for(int i = 0; i<captions.length;i++){
//            captions[i] = items.get(i).getName();
//            price[i] = items.get(i).getPrice();
//            rating[i] = " ";
//            ids[i] = items.get(i).getImageID();
//        }
//        recycler.setLayoutManager(new LinearLayoutManager(this));
//        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids,price,rating);
//        recycler.setAdapter(adapter);
    }




}