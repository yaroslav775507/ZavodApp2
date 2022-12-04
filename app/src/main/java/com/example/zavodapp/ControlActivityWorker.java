package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zavodapp.Inzener.ReadRoster;

public class ControlActivityWorker extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_layout_worker);
    }
    public void workClick(View view) {
        Intent i = new Intent(ControlActivityWorker.this,ReadManOrDetails.class);
        startActivity(i);
        //список работы
    }

    public void CompleteClick(View view) {
        Intent i = new Intent(ControlActivityWorker.this,CompleteWorker.class);
        startActivity(i);
        //Сборка, пероход к классу CompleteWorker
    }

    public void PointClick(View view) {
        Intent i = new Intent(ControlActivityWorker.this, ReadRoster.class);
        startActivity(i);
   }
}
