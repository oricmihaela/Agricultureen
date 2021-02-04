package com.example.lv1.agri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BaseAdapter {
    private DBHelper dbHelper;

    private static final String TABLE = "Users";
    //dodajemo iste podatke kao u UserData
    private static  final String MAIL = "mail";
    private static  final String PASSWORD = "password";

    private static final String SELECT_USERS = "SELECT * FROM " + TABLE;

    public BaseAdapter(Context context) {
        dbHelper = new DBHelper(context, TABLE, MAIL + " TEXT PRIMARY KEY, "
            + PASSWORD + " TEXT");
    }



    public UserData getUser(String _id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String findUser = "SELECT * FROM " + TABLE + " WHERE " + MAIL + "='" + _id+"'";
        Cursor cursor = sqLiteDatabase.rawQuery(findUser, null);
        cursor.moveToFirst();
        UserData userData = new UserData(cursor.getString(0), cursor.getString(1));
        cursor.close();
        sqLiteDatabase.close();
        return userData;
    }
    public boolean insertUser(String mail, String password) {
        try {
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

            ContentValues initialValues = new ContentValues();
            initialValues.put(MAIL, mail);
            initialValues.put(PASSWORD, password);
            sqLiteDatabase.insert(TABLE, null, initialValues);
            sqLiteDatabase.close();
        } catch (SQLException sqlerror) {
            Log.v("Insert into table error", sqlerror.getMessage());
            return false;
        }
        return true;
    }

}
