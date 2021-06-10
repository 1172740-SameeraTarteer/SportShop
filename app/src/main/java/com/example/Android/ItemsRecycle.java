package com.example.Android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ItemsRecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_recycle);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.item_recycler);

        String[] captions = new String[Items.Items.length];
        int[] imageIDs = new int[Items.Items.length];
        int[] price = new int[Items.Items.length];
        String[] rating = new String[Items.Items.length];
        int[] ids = new int[Items.Items.length];

        for(int i = 0; i<captions.length;i++){

            captions[i] = Items.Items[i].getName();
            price[i] = Items.Items[i].getPrice();
            rating[i] = Items.Items[i].getRating();
            imageIDs[i] = Items.Items[i].getImageID();
            ids[i] = Items.Items[i].getId();

        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, imageIDs,price,rating,ids);
        recycler.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shoppinglist, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.listId:
                Intent intent = new Intent(this,
                        ShoppingList.class);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}