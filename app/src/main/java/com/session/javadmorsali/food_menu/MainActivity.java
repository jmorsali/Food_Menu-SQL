package com.session.javadmorsali.food_menu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = (ListView) findViewById(R.id.list_option);
        listview.setOnItemClickListener(new ListClickListener());
    }

    class ListClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, FoodItemsActivity.class);
            switch (position) {
                case 0:
                    intent.putExtra("foodtypeid", FoodTypes.IranianFood);
                    break;
                case 1:
                    intent.putExtra("foodtypeid", FoodTypes.FastFood);
                    break;
                case 2:
                    intent.putExtra("foodtypeid", FoodTypes.ItalianFood);
                    break;
                case 3:
                    intent.putExtra("foodtypeid", FoodTypes.Drink);
                    break;
                case 4:
                    intent.putExtra("foodtypeid", FoodTypes.Salad);
                    break;
            }

            startActivity(intent);

        }
    }
}

