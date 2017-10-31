/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */
//
package id.codinate.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import id.codinate.sqlite.model.Anggota;

public class DetailActivity extends AppCompatActivity {

    private Anggota anggota;
    private TextView txtName;
    private TextView txtType;
    private TextView txtPosisi;
    private TextView txtAlamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtName = (TextView) findViewById(R.id.txt_nama);
        txtType = (TextView) findViewById(R.id.txt_type);
        txtAlamat = (TextView) findViewById(R.id.txt_alamat);
        txtPosisi = (TextView) findViewById(R.id.txt_posisi);

        Intent intent = getIntent();
        anggota = (Anggota) intent.getSerializableExtra("anggota.detail");

        txtName.setText(anggota.getName());
        txtType.setText(anggota.stringType());
        txtPosisi.setText(anggota.getPosisi());
        txtAlamat.setText(anggota.getAlamat());
    }

}
