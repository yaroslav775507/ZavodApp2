package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChoissActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_layout);

    }
    public void adminClick(View view) {
        Intent i = new Intent(ChoissActivity.this, ControlActivityAdmin.class);
        startActivity(i);
    }

//    public void inzenerClick(View view) {
//
//    }
//
        public void workClick(View view) {
            Intent i = new Intent(ChoissActivity.this, ControlActivityWorker.class);
            startActivity(i);
    }
}
