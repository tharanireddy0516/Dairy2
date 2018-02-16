package com.example.tharani.mydairy;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NoteLIstActivity extends AppCompatActivity {
    ListView listView;
    DBhelper helper;
    List<Dairy>dairyList;
    DBDairyAdpter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.lv);
        dairyList = new ArrayList <>();
        helper = new DBhelper(NoteLIstActivity.this);
        dairyList = helper.getlist();
       adapter = new DBDairyAdpter(this,R.layout.view_dairy_item,dairyList);
       listView.setAdapter(adapter);


    }

}
