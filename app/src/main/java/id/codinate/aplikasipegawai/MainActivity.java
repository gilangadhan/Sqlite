/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasipegawai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import id.codinate.aplikasipegawai.helper.SandecHelper;
import id.codinate.aplikasipegawai.model.Anggota;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Anggota> ListAnggota = new ArrayList<>();
    ArrayAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pindah ke form activity
                Intent intent = new Intent(getBaseContext(), FormActivity.class);
                startActivity(intent);
            }
        });
        listView = (ListView) findViewById(R.id.listView); //deklarasi list view
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListAnggota);
        listView.setAdapter(adapter);
        //new ONIntemClick ..... di enter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("anggota.detail", ListAnggota.get(position));
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        SandecHelper dbHelper = new SandecHelper(this);
        ListAnggota = (ArrayList<Anggota>) dbHelper.getAnggota();
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, ListAnggota);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
