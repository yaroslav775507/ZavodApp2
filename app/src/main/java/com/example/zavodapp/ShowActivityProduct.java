package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivityProduct extends AppCompatActivity {
    private TextView tvScale, tvNumpats, tvIndivnum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout_details);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvScale = findViewById(R.id.tvScale);
        tvNumpats = findViewById(R.id.tvNumpats);
        tvIndivnum = findViewById(R.id.tvIndivnum);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvScale.setText(i.getStringExtra(Constant.PRODUCTS_SCALE));
            tvNumpats.setText(i.getStringExtra(Constant.PRODUCTS_NUMPATS));
            tvIndivnum.setText(i.getStringExtra(Constant.PRODUCTS_INDIVNUMNUM));
        }
    }
}
