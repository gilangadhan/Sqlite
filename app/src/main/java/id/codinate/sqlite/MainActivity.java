/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.sqlite;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import id.codinate.sqlite.helper.DatabaseHelper;
import id.codinate.sqlite.model.Anggota;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Anggota> transList = new ArrayList<>();
    ArrayAdapter adapter;
    ListView transactionList;


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
                Intent intent = new Intent(getBaseContext(), FormActivity.class);
                startActivity(intent);
            }
        });
        transactionList = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, transList);
        transactionList.setAdapter(adapter);
        transactionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),
                        DetailActivity.class);
                intent.putExtra("anggota.detail", transList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        transList = (ArrayList<Anggota>) dbHelper.getTransactions();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, transList);
        transactionList.setAdapter(adapter);
    }
}
