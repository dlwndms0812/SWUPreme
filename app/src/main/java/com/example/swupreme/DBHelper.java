package com.example.swupreme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME="t3";
    private static final String COLUMN_ID="_id";
    private static final String result="0";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    //db 처음 만들때 호출
    @Override
    public void onCreate(SQLiteDatabase db){
        String query="CREATE TABLE "+TABLE_NAME
                +" (" +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + result+" INTEGER); ";
        db.execSQL(query);
    }

    //db 업그레이드 필요시 호출
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int nerVersion){
        db.execSQL("DROP TABLE IF EXISTS t3");
        onCreate(db);
    }
}