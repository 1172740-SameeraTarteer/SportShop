
package com.example.Android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {
    TextView textMsg,totalPrice;
    final double totalTaxV = (double) 0.14;
    static double price;
    Button btnCheckout;
    int id = 0;
    RecyclerView recycler;
    ArrayList<Items> itemsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
         recycler = (RecyclerView)findViewById(R.id.shop_recycler);

        Intent intent = getIntent();
        String color = null, size = null;
        textMsg = findViewById(R.id.text);
        totalPrice = findViewById(R.id.totalPrice1);
        btnCheckout=findViewById(R.id.btnCheckout);

        Log.d("bisan", "hello");

        if (intent != null && intent.getExtras() != null) {
            id = intent.getExtras().getInt("item_id", -1);
            color = intent.getExtras().getString("color", null);
            size = intent.getExtras().getString("size", null);
            Log.d("bisan", color + " " + size);


            if (id >= 0) {
                Items items = Items.findItemsByid(id);

                itemsList = new ArrayList<>();
                itemsList.add(new Items(id, items.getName(), color, items.getPrice(), items.getImageID(), size));

                textMsg.setText("Size: " + size + "\nColor: " + color);
                //add tax
                price = (items.getPrice() * totalTaxV)+items.getPrice();
                totalPrice.setText("Total Price (+14% Tax): "+(double) price);

                String[] captions = new String[itemsList.size()];
                int[] imageIDs = new int[itemsList.size()];
                int[] price = new int[itemsList.size()];
                String[] rating = new String[itemsList.size()];
                int[] ids = new int[itemsList.size()];

                for(int i = 0; i<captions.length;i++){

                    captions[i] = itemsList.get(i).getName();
                    price[i] = itemsList.get(i).getPrice();
                    rating[i] = "";
                    imageIDs[i] = itemsList.get(i).getImageID();
                    ids[i] = itemsList.get(i).getId();

                }
        recycler.setLayoutManager(new LinearLayoutManager(this));
                CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, imageIDs,price,rating,ids);
        recycler.setAdapter(adapter);
            }

        } else
            textMsg.setText("no Item Selected");
btnCheckout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(!itemsList.isEmpty()){
            Intent intent1 = new Intent(ShoppingList.this,
                    BuyOrder.class);
            intent1.putExtra("price", price);

            startActivity(intent1);
        }
        else
            Toast.makeText(ShoppingList.this, "Select Item", Toast.LENGTH_SHORT).show();

    }

});

    }




    public void btnBack(View view) {
        Intent intent = new Intent(ShoppingList.this,
                ItemsRecycle.class);

        startActivity(intent);
    }

    public void btnEmpty(View view) {
        itemsList.clear();
        recycler.setAdapter(null);
        textMsg.setText(" ");
                totalPrice.setText(" ");
    }
}

