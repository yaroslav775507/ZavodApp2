package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivitiDetails extends AppCompatActivity {
    private TextView tvMaterial, tvSize, tvUniqnum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout_details);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvMaterial = findViewById(R.id.tvMaterial);
        tvSize = findViewById(R.id.tvSize);
        tvUniqnum = findViewById(R.id.tvUniqname);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvMaterial.setText(i.getStringExtra(Constant.DETAILS_MATERIAL));
            tvSize.setText(i.getStringExtra(Constant.DETAILS_SIZE));
            tvUniqnum.setText(i.getStringExtra(Constant.DETAILS_UNIQNUM));
        }
    }
}
