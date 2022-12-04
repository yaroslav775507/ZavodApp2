package com.example.zavodapp.Inzener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zavodapp.R;
import com.example.zavodapp.ReadComlete;
import com.example.zavodapp.catalog.Catalog;

public class ControlActivityInzener extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_inzener);
    }
    //Составленеи спика деталей для сборки изделия/последовательность
    public void onList(View view) {
        Intent i = new Intent(ControlActivityInzener.this ,MainRoster.class);
        startActivity(i);
    }
    //Слежение за процессом сборки
    public void onLook(View view) {
        Intent i = new Intent(ControlActivityInzener.this , ReadComlete.class);
        startActivity(i);
    }

    public void CatalogClick(View view) {
        Intent i = new Intent(ControlActivityInzener.this , Catalog.class);
        startActivity(i);
    }
}
