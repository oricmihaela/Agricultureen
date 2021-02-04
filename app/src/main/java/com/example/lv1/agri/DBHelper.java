package com.example.lv1.agri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UsersDB";
    private String createStatement = ""; //prazno da bi mogli samo + za sastavljanje stringa
    private String tableName;
    private Context context;

    public DBHelper(Context context, String tableName, String fields) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.createStatement = "CREATE TABLE IF NOT EXISTS ";
        this.createStatement += tableName + " (";
        this.createStatement += fields + ") WITHOUT ROWID;";
        this.tableName = tableName;
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + this.tableName);
        onCreate(db);
    }
}
