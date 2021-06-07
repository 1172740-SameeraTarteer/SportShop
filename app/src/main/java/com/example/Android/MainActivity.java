package com.example.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test comment
        setContentView(R.layout.activity_main);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.item_recycler);

        String[] captions = new String[Items.Items.length];
        int[] ids = new int[Items.Items.length];
        String[] price = new String[Items.Items.length];
        String[] rating = new String[Items.Items.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = Items.Items[i].getName();
            price[i] = Items.Items[i].getPrice();
            rating[i] = Items.Items[i].getRating();
            ids[i] = Items.Items[i].getImageID();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids,price,rating);
        recycler.setAdapter(adapter);


//    RecyclerView.OnItemClickListener itemClickListener = new RecyclerView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent,
//                                View view,
//                                int position,
//                                long id) {
//            Intent intent = new Intent(MainActivity.this,
//                    MainActivity2.class);
//            // id of item from movie[] if first then id=0,...
//            intent.putExtra("movie_id", (int)id);
//            startActivity(intent);
//
//        }
//    };
//        recycler.setOnItemClickListener(itemClickListener);



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
            case R.id.listid:
                Intent intent = new Intent(MainActivity.this,
                ShoppingList.class);
                 startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    public void shoppingList(View view){
//        Intent intent = new Intent(view.getContext(),
//                ShoppingList.class);
//        startActivity(intent);
//
//    }
}
