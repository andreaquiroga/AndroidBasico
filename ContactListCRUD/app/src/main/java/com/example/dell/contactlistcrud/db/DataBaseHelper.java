package com.example.dell.contactlistcrud.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "ContactListDB" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    public DataBaseHelper(Context context)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE  TABLE Contact (contact_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, name TEXT, mobile_phone INTEGER, home_phone INTEGER);");
        db.execSQL("INSERT INTO Contact(name, mobile_phone, home_phone) VALUES('Pamela Cruz', 72288996, 4412232)");
        db.execSQL("INSERT INTO Contact(name, mobile_phone, home_phone) VALUES('Jose Revollo', 67450816, 4480751)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Contact");
    }
}
