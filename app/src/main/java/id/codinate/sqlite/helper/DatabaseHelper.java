/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.codinate.sqlite.model.Anggota;

/**
 * Created by Gilang Ramadhan on 14/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "anggota.db";
    public static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
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

    public void insertTransaction(String name, int type, String posisi, String alamat){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Anggota.COL_NAME, name);
        values.put(Anggota.COL_TYPE, type);
        values.put(Anggota.COL_POSISI, posisi);
        values.put(Anggota.COL_ALAMAT, alamat);

        db.insert(Anggota.TABLE_NAME, null, values);
    }

    public List<Anggota> getTransactions(){
        db = getReadableDatabase();
        List<Anggota> anggotas = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from "+ Anggota.TABLE_NAME+
                " order by "+ Anggota._ID, null);

        Anggota newTrans;
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                newTrans = new Anggota(Long.toString(cursor.getLong(0)),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4));
                anggotas.add(newTrans);
            }
        }
        cursor.close();

        return anggotas;
    }

    public void deleteTransaction(Anggota anggota){
        db = getWritableDatabase();

        db.delete(Anggota.TABLE_NAME, Anggota._ID+" = ?",
                new String[]{anggota.getId()});
    }
}
