package com.example.toolslist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;
    ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        listViewDrills = findViewById(R.id.listViewDrills);
        drills = new ArrayList<>();
        drills.add(new Drill(getString(R.string.makita_drill_title),getString(R.string.makita_drill_info),R.drawable.makita));
        drills.add(new Drill(getString(R.string.dewalt_drill_title),getString(R.string.dewalt_drill_info),R.drawable.dewalt));
        drills.add(new Drill(getString(R.string.matrix_drill_title),getString(R.string.matrix_drill_info),R.drawable.matrix));
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,drills);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),DrillInfoActivity.class);
                intent.putExtra("title",drills.get(i).getTitle());
                intent.putExtra("info",drills.get(i).getInfo());
                intent.putExtra("resId",drills.get(i).getResId());
                startActivity(intent);
            }
        });
    }
}