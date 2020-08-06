package com.tdc.quanlythuoctay.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.tdc.quanlythuoctay.model.AccoutModel;

public class DatabaseHandler extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "UserManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "User";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "User";
    private static final String KEY_PASS= "Pass";
    private static final String KEY_AVATAR = "Avatar";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_user_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_PASS, KEY_AVATAR);
        db.execSQL(create_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_user_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_user_table);
        onCreate(db);
    }
    public void addUser(AccoutModel user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getUser());
        values.put(KEY_PASS, user.getPass());
        values.put(KEY_AVATAR, user.getAvatar());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public AccoutModel getUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_NAME + " = ?", new String[] { username },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        AccoutModel user = new AccoutModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return user;
    }
    public AccoutModel Login(String username ,String pass) {
        AccoutModel user;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_NAME + " = ? AND "+KEY_PASS +" = ?", new String[] { username ,pass},null, null, null);
        if( cursor != null && cursor.moveToFirst()){
            user = new AccoutModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cursor.close();
            return user;
        }
        else
        {
            return null;
        }

    }
}