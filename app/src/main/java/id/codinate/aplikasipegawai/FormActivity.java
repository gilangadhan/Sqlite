/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasipegawai;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import id.codinate.aplikasipegawai.helper.SandecHelper;

public class FormActivity extends AppCompatActivity {
    Spinner spnType;
    EditText edtName, edtPosisi, edtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
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
        spnType = (Spinner) findViewById(R.id.spn_type);
        edtName = (EditText) findViewById(R.id.edt_nama);
        edtPosisi = (EditText) findViewById(R.id.edt_posisi);
        edtAlamat = (EditText) findViewById(R.id.edt_alamat);
        String type [] = {"Laki Laki", "Perempuan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(adapter);
    }
    public  void TambahAnggota(View view){
        String name = edtName.getText().toString();
        int type = spnType.getSelectedItemPosition()+1;
        String posisi = edtPosisi.getText().toString();
        String alamat = edtAlamat.getText().toString();
        SandecHelper sandecHelper = new SandecHelper(this);
        sandecHelper.tambahAnggota(name, type, posisi, alamat);
        Toast.makeText(getApplicationContext(), "Anggota "
                + name + " Sukses ditambahkan", Toast.LENGTH_SHORT).show();
        finish();
    }
}
