package com.session.javadmorsali.food_menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    SQLiteDatabase db;
    Cursor favoritecursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ListView listview = (ListView) findViewById(R.id.list_option);
        listview.setOnItemClickListener(new ListClickListener());

        ListView listview_faivorite = (ListView) findViewById(R.id.list_faivorite);

        try {
            FoodDataSqlHelper helper = new FoodDataSqlHelper(this);
            db = helper.getReadableDatabase();
            favoritecursor = db.query("DRINKS", new String[]{"_id", "NAME"}, "FAVORITE =1 ", null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_2, favoritecursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listview_faivorite.setAdapter(favoriteAdapter);

        } catch (SQLException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        try {
            FoodDataSqlHelper helper = new FoodDataSqlHelper(this);
            db = helper.getReadableDatabase();
            Cursor newcursor = db.rawQuery("SELECT * FROM DRINKS WHERE FAVORITE = 1 ;", null);
            boolean res = newcursor.moveToFirst();
            ListView listview_faivorite = (ListView) findViewById(R.id.list_faivorite);
            CursorAdapter adapter = (CursorAdapter) listview_faivorite.getAdapter();
            adapter.changeCursor(newcursor);
            favoritecursor = newcursor;

        } catch (SQLException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        favoritecursor.close();
        db.close();
    }

    class ListClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(MainActivity.this, FoodItemsActivity.class);
            switch (position) {
                case 0:
                    ShowDialog(MainActivity.this);

                    //intent.putExtra("foodtypeid", FoodTypes.IranianFood);
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

    private void ShowDialog(Context context) {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

