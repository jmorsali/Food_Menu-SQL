package com.session.javadmorsali.food_menu;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FoodItemDetailesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_detailes);
        Intent intent = getIntent();

        long foodid = (Long) intent.getExtras().get("fooditemId");
        FoodTypes FoodTypeId = (FoodTypes) intent.getExtras().get("foodtypeId");


        try {
            FoodDataSqlHelper helper = new FoodDataSqlHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            Cursor cursor = db.rawQuery(String.format("SELECT NAME,DESCRIPTION,IMAGE_RESOURCE_ID,FAVORITE FROM DRINKS WHERE _id=%d;", foodid), null);
            IFoodItem item;
            if (cursor.moveToFirst()) {
                item = new Drink(cursor.getString(0), cursor.getString(1), cursor.getInt(2));
                item.setIs_Favorite(cursor.getInt(3) == 1);
            } else
                item = new Drink("نامعلوم", "نامعلوم", 0);


            ImageView photo = (ImageView) findViewById(R.id.photo);
            if (item.getImageResourceId() != -1)
                photo.setImageResource(item.getImageResourceId());

            TextView name = (TextView) findViewById(R.id.name);
            name.setText(item.getName());

            TextView description = (TextView) findViewById(R.id.description);
            description.setText(item.getDescription());

            ToggleButton tglbtnfavorite = (ToggleButton) findViewById(R.id.tglbtnfavorite);
            tglbtnfavorite.setChecked(item.getIs_Favorite());


        } catch (SQLException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void tglbtnfavorite_Clicked(View view) {

        Long foodid = (Long) getIntent().getExtras().get("fooditemId");
        new UpdateDrinkTask().execute(foodid);

    }

    private class UpdateDrinkTask extends AsyncTask<Long, Void, Boolean> {

        ContentValues foodvalue;

        @Override
        protected Boolean doInBackground(Long... foods) {
            long foodid = foods[0];
            SQLiteOpenHelper helper = new FoodDataSqlHelper(FoodItemDetailesActivity.this);

            try {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.update("DRINKS", foodvalue, "_id=?", new String[]{Long.toString(foodid)});
                db.close();
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast.makeText(FoodItemDetailesActivity.this, "خطا", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onPreExecute() {
            ToggleButton tglbtnfavorite = (ToggleButton) findViewById(R.id.tglbtnfavorite);
            Boolean value = tglbtnfavorite.isChecked();
            foodvalue = new ContentValues();
            foodvalue.put("FAVORITE", value ? 1 : 0);
        }
    }

}


