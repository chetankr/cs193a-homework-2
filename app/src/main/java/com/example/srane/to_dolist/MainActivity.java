package com.example.srane.to_dolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    private ArrayList<String> tasks;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_format, R.id.text_location,  tasks );
        ListView list = (ListView) findViewById(R.id.LV);
        list.setOnItemLongClickListener(this);
    }

    public void addTask(View view) {
        EditText et = (EditText) findViewById(R.id.task);
        String task = et.getText().toString();
        tasks.add(task);

        ListView list = (ListView) findViewById(R.id.LV);
        list.setAdapter(adapter);

        et.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        tasks.remove(position);
        adapter.notifyDataSetChanged();
        return false;
    }
}
