package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Fitness_Tips extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private ListView listView;
    ArrayList<String> list=new ArrayList();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitness_tips_xml);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        list.add(getResources().getStringArray(R.array.food)[0]);
        list.add(getResources().getStringArray(R.array.food)[1]);
        list.add(getResources().getStringArray(R.array.food)[2]);
        listView = findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String str=parent.getItemAtPosition(pos).toString();
        if(pos==0){
            list.clear();
            list.add(getResources().getStringArray(R.array.food)[0]);
            list.add(getResources().getStringArray(R.array.food)[1]);
            list.add(getResources().getStringArray(R.array.food)[2]);
            arrayAdapter.notifyDataSetChanged();
        }
        if(pos==1){
            list.clear();
            list.add(getResources().getStringArray(R.array.exercise)[0]);
            list.add(getResources().getStringArray(R.array.exercise)[1]);
            list.add(getResources().getStringArray(R.array.exercise)[2]);
            arrayAdapter.notifyDataSetChanged();
        }
        if(pos==2){
            list.clear();
            list.add(getResources().getStringArray(R.array.yoga)[0]);
            list.add(getResources().getStringArray(R.array.yoga)[1]);
            list.add(getResources().getStringArray(R.array.yoga)[2]);
            arrayAdapter.notifyDataSetChanged();
        }
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
}