package com.example.toolslist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillInfoActivity extends AppCompatActivity {

    private ImageView imageViewId;
    private TextView textViewTitle;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_info);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        imageViewId = findViewById(R.id.imageView);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);

        Intent intent = getIntent();
        if (intent.hasExtra("resId")&& intent.hasExtra("title")&&intent.hasExtra("info")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId",-1);
            imageViewId.setImageResource(resId);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
        }else {
            Intent backToCategory = new Intent(this,DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}