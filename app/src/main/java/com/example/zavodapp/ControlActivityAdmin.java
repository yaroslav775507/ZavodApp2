package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ControlActivityAdmin extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_layout_admin);

    }



    public void onClickWork(View view) {
        Intent i = new Intent(ControlActivityAdmin.this, MainActivityUser.class);
        startActivity(i);
    }

    public void onClickDetal(View view) {
        Intent i = new Intent(ControlActivityAdmin.this, MainActivityDetals.class);
        startActivity(i);
    }

    public void onClickIzdel(View view) {
        Intent i = new Intent(ControlActivityAdmin.this, MainActivityProduct.class);
        startActivity(i);
    }

    public void ManOrDetails(View view) {
        Intent i = new Intent(ControlActivityAdmin.this,MainManOrDetails.class);
        startActivity(i);
    }
}
