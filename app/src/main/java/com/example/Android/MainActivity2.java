package com.example.Android;

import android.content.Intent;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup mRadioGroup;
    int id;
    String[] colorList;
    String[] sizeList;
    Items items;
    String selectedColor = null;
    String selectedSize = null;
    int selectedIdSize,selectedIdColor;
     RadioGroup rgColor , rgSize;

   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
         id = (int)intent.getExtras().get("item_id");

         items = Items.findItemsByid(id);

        TextView type= findViewById(R.id.edtType);
        TextView name= findViewById(R.id.edtName);
        TextView desc= findViewById(R.id.edtDesc);
        name.setText(items.getName());
        type.setText(items.getType());
        desc.setText(items.getDescription());

        ///To add Color & sizes choices
        addRadioButtons();

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


    public void addRadioButtons() {
        colorList = items.getColor().split(",");
        sizeList = items.getSize().split(",");



            rgColor = findViewById(R.id.rGColor);
            ArrayList<RadioButton> listRadioButtonC = new ArrayList<>();
            rgColor.setOrientation(RadioGroup.HORIZONTAL);// or RadioGroup.VERTICAL
            for (int i = 0; i < colorList.length; i++) {
                RadioButton rb = new RadioButton(this);
                rb.setId(i);
                rb.setText(colorList[i] + "");
                listRadioButtonC.add(rb);
                rgColor.addView(listRadioButtonC.get(i));
            }
            rgSize = findViewById(R.id.rGSize);
            ArrayList<RadioButton> listRadioButtonS = new ArrayList<>();
            rgColor.setOrientation(RadioGroup.HORIZONTAL);// or RadioGroup.VERTICAL
            for (int i = 0; i < sizeList.length; i++) {
                RadioButton rb = new RadioButton(this);
                rb.setText(sizeList[i] + "");
                rb.setId(i);
                listRadioButtonS.add(rb);
                rgSize.addView(listRadioButtonS.get(i));
            }


    }

    public void selectItem(String selectedColor,String selectedSize){
                    Intent intent = new Intent(this,
                    ShoppingList.class);
        intent.putExtra("item_id",id);
        intent.putExtra("color",selectedColor);
        intent.putExtra("size", selectedSize);
        startActivity(intent);

    }



    public void btnBack(View view){
        Intent intent = new Intent(view.getContext(),
                ItemsRecycle.class);

        view.getContext().startActivity(intent);

    }



    public void btnShopCart(View view) {
        if (rgColor.getCheckedRadioButtonId() != -1 && rgSize.getCheckedRadioButtonId() != -1) {


            selectedIdSize = rgSize.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedIdSize);
            selectedIdColor = rgColor.getCheckedRadioButtonId();

            RadioButton radioButtonC = findViewById(selectedIdColor);
            String selectedColor = (String) radioButton.getText();
            String selectedSize = (String) radioButtonC.getText();

            selectItem(selectedColor, selectedSize);

        }
    }
}



