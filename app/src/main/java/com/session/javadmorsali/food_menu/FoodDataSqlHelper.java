package com.session.javadmorsali.food_menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jmorsali on 2018-02-13.
 */

public class FoodDataSqlHelper extends SQLiteOpenHelper {

    static String dbName = "starBuzz";
    static int db_version = 2;

    public FoodDataSqlHelper(Context context) {
        super(context, dbName, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINKS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "DESCRIPTION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER);"
        );

        insertDrink(db, "TORK 1", "Desc 1", R.drawable.p1);
        insertDrink(db, "Orange 1", "cup of orange", R.drawable.p2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        updateDB(db, oldVersion, newVersion);
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues cv = new ContentValues();
        cv.put("NAME", name);
        cv.put("DESCRIPTION", description);
        cv.put("IMAGE_RESOURCE_ID", resourceId);
        long res1 = db.insert("DRINKS", null, cv);


    }

    private void updateDB(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion > 1) {
            onCreate(db);
        }
        insertDrink(db, "Filter", "our best drip cofee", R.drawable.filter);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINKS ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
