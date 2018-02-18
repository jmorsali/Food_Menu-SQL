package com.session.javadmorsali.food_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodItemDetailesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_detailes);
        Intent intent = getIntent();

        int position = (Integer) intent.getExtras().get("fooditemId");
        FoodTypes FoodTypeId = (FoodTypes) intent.getExtras().get("foodtypeId");

        IFoodItem item = null;
        switch (FoodTypeId) {
            case IranianFood:
                item = IranianFood.IranianFood[position];
                break;
            case Drink:
                item = Drink.Drinks[position];
                break;
            case Salad:
                item = Salad.Salads[position];
                break;
            case ItalianFood:
                item = ItalianFood.ItalianFoods[position];
                break;
            case FastFood:
                item = FastFood.FastFoods[position];
                break;
        }


        ImageView photo = (ImageView) findViewById(R.id.photo);
        if (item.getImageResourceId() != -1)
            photo.setImageResource(item.getImageResourceId());

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(item.getName());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(item.getDescription());

    }
}
