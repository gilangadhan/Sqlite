/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasipegawai.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.codinate.aplikasipegawai.model.Anggota;

/**
 * Created by Gilang Ramadhan on 15/04/2017.
 */

public class SandecHelper extends SQLiteOpenHelper{
    public static final String DB_NAMA = "anggota.db";
    public static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    public SandecHelper(Context context) {
        super(context, DB_NAMA, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Anggota.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Anggota.SQL_DELETE);
        onCreate(db);
    }

    public void tambahAnggota (String nama, int type, String posisi, String alamat){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Anggota.COL_NAMA, nama);
        values.put(Anggota.COL_TYPE, type);
        values.put(Anggota.COL_POSISI, posisi);
        values.put(Anggota.COL_ALAMAT, alamat);
        db.insert(Anggota.TABLE_NAMA, null, values);
    }

    public List<Anggota> getAnggota(){
        db = getReadableDatabase();
        List<Anggota> anggotas = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from "+ Anggota.TABLE_NAMA +
        " order by "+ Anggota._ID, null);

        Anggota newAnggota;
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                //(String id, String nama, int type, String posisi, String alamat) {
                newAnggota = new Anggota(Long.toString(cursor.getLong(0)),
                        cursor.getString(1), cursor.getInt(2),
                        cursor.getString(3), cursor.getString(4));
                anggotas.add(newAnggota);
            }
        }
        cursor.close();
        return anggotas;
    }

    public void deleteAnggota (Anggota anggota) {
        db = getWritableDatabase();
        db.delete(Anggota.TABLE_NAMA, Anggota._ID+ " = ?",
                new String[]{anggota.getId()});
    }
}
