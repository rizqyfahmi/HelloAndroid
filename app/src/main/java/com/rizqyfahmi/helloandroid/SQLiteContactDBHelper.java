package com.rizqyfahmi.helloandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteContactDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "create table "+SQLiteContactContract.ContactEntry.TABLE_NAME+" ("+SQLiteContactContract.ContactEntry.CONTACT_ID+" number, "+SQLiteContactContract.ContactEntry.NAME+" text, "+SQLiteContactContract.ContactEntry.EMAIL+" text)";
    public static final String DROP_TABLE = "drop table if exists "+SQLiteContactContract.ContactEntry.TABLE_NAME;

    public SQLiteContactDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operation", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operation", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteContactContract.ContactEntry.CONTACT_ID, id);
        contentValues.put(SQLiteContactContract.ContactEntry.NAME, name);
        contentValues.put(SQLiteContactContract.ContactEntry.EMAIL, email);

        db.insert(SQLiteContactContract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operation", "One row inserted");
    }

    public Cursor readContacts(SQLiteDatabase db){
        String[] projections = {SQLiteContactContract.ContactEntry.CONTACT_ID, SQLiteContactContract.ContactEntry.NAME, SQLiteContactContract.ContactEntry.EMAIL};
        Cursor cursor = db.query(SQLiteContactContract.ContactEntry.TABLE_NAME, projections, null, null, null, null, null);

        return cursor;
    }

    public void updateContact(int id, String name, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteContactContract.ContactEntry.NAME, name);
        contentValues.put(SQLiteContactContract.ContactEntry.EMAIL, email);

        String selection = SQLiteContactContract.ContactEntry.CONTACT_ID+" = "+id;
        db.update(SQLiteContactContract.ContactEntry.TABLE_NAME, contentValues, selection, null);
    }

    public void deleteContact(int id, SQLiteDatabase db){
        String selection = SQLiteContactContract.ContactEntry.CONTACT_ID+" = "+id;
        db.delete(SQLiteContactContract.ContactEntry.TABLE_NAME, selection, null);
    }
}
