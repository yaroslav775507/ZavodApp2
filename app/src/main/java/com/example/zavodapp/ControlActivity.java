package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ControlActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_layout);

    }



    public void onClickWork(View view) {
        Intent i = new Intent(ControlActivity.this, MainActivityUser.class);
        startActivity(i);
    }

    public void onClickDetal(View view) {
        Intent i = new Intent(ControlActivity.this, MainActivityDetals.class);
        startActivity(i);
    }

    public void onClickIzdel(View view) {
        Intent i = new Intent(ControlActivity.this, MainActivityProduct.class);
        startActivity(i);
    }
}
