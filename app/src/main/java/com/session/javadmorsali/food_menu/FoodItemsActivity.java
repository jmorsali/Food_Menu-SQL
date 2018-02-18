package com.session.javadmorsali.food_menu;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.sql.SQLData;

public class FoodItemsActivity extends ListActivity {

    FoodTypes FoodTypeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_food_items);
        Intent intent = getIntent();
        ListView view = getListView();
        FoodTypeId = (FoodTypes) intent.getExtras().get("foodtypeid");
        switch (FoodTypeId) {

            case IranianFood:
                ArrayAdapter<IranianFood> IranianFoodadapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, IranianFood.IranianFood);
                view.setAdapter(IranianFoodadapter);
                break;

            case Drink:
                //ArrayAdapter<Drink> Drinkadapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, Drink.Drinks);
                //view.setAdapter(Drinkadapter);

                FoodDataSqlHelper helper = new FoodDataSqlHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                //Cursor cursor = db.query("DRINKS", new String[]{"_id", "NAME"}, null, null, null, null, null);

                Cursor cursor = db.rawQuery("SELECT * FROM DRINKS;", null);

                CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1,
                        cursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);

                view.setAdapter(adapter);
                break;

            case Salad:
                ArrayAdapter<Salad> Saladadapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, Salad.Salads);
                view.setAdapter(Saladadapter);
                break;

            case ItalianFood:
                ArrayAdapter<ItalianFood> IttilianFoodadapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ItalianFood.ItalianFoods);
                view.setAdapter(IttilianFoodadapter);
                break;

            case FastFood:
                ArrayAdapter<FastFood> FastFoodadapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, FastFood.FastFoods);
                view.setAdapter(FastFoodadapter);
                break;

        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(this, FoodItemDetailesActivity.class);
        intent.putExtra("fooditemId", position);
        intent.putExtra("foodtypeId", FoodTypeId);
        startActivity(intent);

        super.onListItemClick(l, v, position, id);

    }
}
