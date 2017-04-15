/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.sqlite.model;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Gilang Ramadhan on 14/04/2017.
 */

public class Anggota implements Serializable, BaseColumns {
    private String id;
    private String name;
    private int type;
    private String posisi;
    private String alamat;

    public Anggota(String id, String name, int type, String posisi, String alamat) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.posisi = posisi;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String stringType(){
        if (this.type == 1)
            return "Laki Laki";
        else
            return "Perempuan";
    }

    @Override
    public String toString() {
        return this.name+" Sebagai "+this.posisi;
    }

    public static final String TABLE_NAME = "anggota";
    public static final String COL_NAME = "name";
    public static final String COL_TYPE = "type";
    public static final String COL_POSISI= "posisi";
    public static final String COL_ALAMAT = "alamat";

    public static final String SQL_CREATE = "create table anggota " +
            "(_id integer primary key autoincrement, "+
            "name text, type integer, posisi text, alamat text)";
    public static final String SQL_DELETE = "drop table if exists anggota";
}
