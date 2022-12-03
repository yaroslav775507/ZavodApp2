package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowManOrDetails extends AppCompatActivity {
    private TextView tvWorker, tvInzjen, tvProd,tvDetals;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mod);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvWorker = findViewById(R.id.tvWorker);
        tvInzjen = findViewById(R.id.tvInzjen);
        tvProd = findViewById(R.id.tvProd);
        tvDetals = findViewById(R.id.tvDetals);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvWorker.setText(i.getStringExtra(Constant.MOR_INZJ));
            tvInzjen.setText(i.getStringExtra(Constant.MOR_WORKER));
            tvProd.setText(i.getStringExtra(Constant.MOR_DETAILS));
            tvDetals.setText(i.getStringExtra(Constant.MOR_PROD));
        }
    }
}
