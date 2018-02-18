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
    static int db_version = 1;

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
        ContentValues cv = new ContentValues();
        cv.put("NAME", "TORK 1");
        cv.put("DESCRIPTION", "Desc 1");
        cv.put("IMAGE_RESOURCE_ID", R.drawable.p1);
        long res1 = db.insert("DRINKS", null, cv);

        cv = new ContentValues();
        cv.put("NAME", "Orange");
        cv.put("DESCRIPTION", "cup of orange");
        cv.put("IMAGE_RESOURCE_ID", R.drawable.p2);
        long res = db.insert("DRINKS", null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
