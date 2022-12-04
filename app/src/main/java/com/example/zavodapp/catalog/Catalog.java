package com.example.zavodapp.catalog;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zavodapp.R;

public class Catalog extends AppCompatActivity {
    private ListView listView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_layout);
        ListView listView = findViewById(R.id.CatalogList);
// определяем строковый массив
        final String[] names = new String[] {
                "Vacuum cleaner", "Generator", "Bulgarian", "Bearings", "Wires",
                "Coils", "Oil pump", "Filter", "Drill"
        };
// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);

    }
}
