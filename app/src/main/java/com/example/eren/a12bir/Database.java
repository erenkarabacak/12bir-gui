package com.example.eren.a12bir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;

/**
 * Created by eren on 01.12.2017.
 */

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "12bir";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_USERS = "users";
    private static final String ROW_ID = "id";
    private static final String ROW_NAME = "name";
    private static final String ROW_LASTNAME = "lastname";
    private static final String ROW_PHONE = "phone";
    private static final String ROW_MAIL = "mail";
    private static final String ROW_PASSWORD = "password";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLO_USERS + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_NAME + " TEXT NOT NULL, "
                + ROW_LASTNAME + " TEXT NOT NULL, "
                + ROW_MAIL + " TEXT NOT NULL, "
                + ROW_PASSWORD + " TEXT NOT NULL, "
                + ROW_PHONE + " TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLO_USERS);
        onCreate(sqLiteDatabase);

    }

    public void addData(String name, String lastname, String phone , String mail , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_NAME, name);
            cv.put(ROW_LASTNAME, lastname);
            cv.put(ROW_PHONE, phone);
            cv.put(ROW_MAIL, mail);
            cv.put(ROW_PASSWORD, password);
            db.insert(TABLO_USERS, null,cv);
            Log.e("Basarili","eklendi");
        }catch (Exception e){
            Log.e("Basarisiz","eklenmedi");
        }
        db.close();
    }



    public boolean checkUser(String mail, String password) {
        SQLiteDatabase sqldb = getWritableDatabase();
        String Query = "Select * from " + TABLO_USERS + " where " + ROW_MAIL + " ='" + mail +   "' and " + ROW_PASSWORD + " = '" + password + "'";

        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }






}
