package com.tugas.apptugas;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) { super(context, "apptugas", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE buku (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "judul TEXT," +
                "isbn TEXT," +
                "tahun TEXT," +
                "penerbit TEXT," +
                "kategori TEXT," +
                "jumlah TEXT," +
                "warna TEXT," +
                "kualitas TEXT," +
                "rangkuman TEXT)" ;
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
