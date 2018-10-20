package com.tugas.apptugas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BukuDataSource {
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;

    public BukuDataSource (Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    public void bukaDatabase(){ sqLiteDatabase=databaseHelper.getWritableDatabase();}
    public void tutupDatabase(){ sqLiteDatabase=databaseHelper.getReadableDatabase();}

    public boolean addBuku (Buku buku){
        ContentValues contentValues = new ContentValues();
        contentValues.put("judul", buku.getJudul());
        contentValues.put("isbn", buku.getIsbn());
        contentValues.put("tahun", buku.getTahun());
        contentValues.put("penerbit", buku.getPenerbit());
        contentValues.put("kategori", buku.getKategori());
        contentValues.put("jumlah", buku.getJumlah());
        contentValues.put("warna", buku.getWarna());
        contentValues.put("kualitas", buku.getKualitas());
        contentValues.put("rangkuman", buku.getRangkuman());

        long cekStatus=sqLiteDatabase.insert("buku", null,contentValues);
        return cekStatus >0;

    }

    private Buku ubahKePojo(Cursor cursor){
        Buku buku = new Buku();

        buku.setId(cursor.getLong(0));
        buku.setJudul(cursor.getString(1));
        buku.setIsbn(cursor.getString(2));
        buku.setTahun(cursor.getString(3));
        buku.setPenerbit(cursor.getString(4));
        buku.setKategori(cursor.getString(5));
        buku.setJumlah(cursor.getString(6));
        buku.setWarna(cursor.getString(7));
        buku.setKualitas(cursor.getString(8));
        buku.setRangkuman(cursor.getString(9));

        return buku;


    }

    public List<Buku> getAllBuku(){
        String query="SELECT * FROM buku";
        Cursor cursor =sqLiteDatabase.rawQuery(query,null);
        cursor.moveToFirst();

        List<Buku> bukuList = new ArrayList<>();

        while(!cursor.isAfterLast()){
            Buku buku=ubahKePojo(cursor);
            bukuList.add(buku);
            cursor.moveToNext();

        }
       return bukuList;
    }

    public Buku getBuku(long idBuku) {
        String query="SELECT * FROM buku WHERE id="+idBuku;
        Cursor cursor=sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();
        Buku buku=ubahKePojo(cursor);

        return buku;
    }
}
