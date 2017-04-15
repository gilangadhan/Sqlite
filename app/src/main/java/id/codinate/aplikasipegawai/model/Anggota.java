/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasipegawai.model;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Gilang Ramadhan on 15/04/2017.
 */

public class Anggota implements Serializable, BaseColumns {
    private String id, nama, posisi, alamat;
    private int type;

    public Anggota(String id, String nama, int type, String posisi, String alamat) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.alamat = alamat;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // cek untuk type == 1 maka hasilnya laki laki(type adalah jenis kelamin)
    public String stringType() {
        if (this.type == 1)
            return "Laki Laki";
        else
            return "Perempuan";
    }

    @Override
    public String toString() {
        return this.nama + " Sebagai " + this.posisi;
    }

    public static final String TABLE_NAMA = "anggota";
    public static final String COL_NAMA = "nama";
    public static final String COL_TYPE = "type";
    public static final String COL_POSISI = "posisi";
    public static final String COL_ALAMAT = "alamat";

    public static final String SQL_CREATE = "create table anggota " +
            "(_id integer primary key autoincrement, " +
            "nama text, type integer, posisi text, alamat text)";

    public static final String SQL_DELETE = "drob table if exists anggota";

}
