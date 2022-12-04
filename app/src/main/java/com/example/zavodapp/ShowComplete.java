package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowComplete extends AppCompatActivity {
    private TextView ComplDetal, ComplProduct;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_complete);
        init();
        getIntentMain();
    }
    private void init()
    {
        ComplDetal = findViewById(R.id.ComplDetal);
        ComplProduct = findViewById(R.id.ComplProduct);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            ComplDetal.setText(i.getStringExtra(Constant.COMPLETE_DETAILS));
            ComplProduct.setText(i.getStringExtra(Constant.COMPLETE_PRODUCTS));
        }
    }
}
