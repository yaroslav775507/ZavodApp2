package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadComlete extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Complete> listTemp;
    private DatabaseReference mDataBase;
    private String  COMPLETE_KEY = "Complete";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_complete);
        init();
        getDataFromDB();
        setOnClickItem();
    }
    private void init()
    {
        listView = findViewById(R.id.compllist);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(COMPLETE_KEY);
    }
    private void getDataFromDB()
    {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(listData.size() > 0)listData.clear();
                if(listTemp.size() > 0)listTemp.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Complete complete = ds.getValue(Complete.class);
                    assert complete != null;
                    listData.add(complete.product);
                    listTemp.add(complete);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDataBase.addValueEventListener(vListener);
    }
    private void setOnClickItem()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Complete complete = listTemp.get(position);
                Intent i = new Intent(ReadComlete.this, ShowComplete.class);
                i.putExtra(Constant.COMPLETE_DETAILS,complete.details);
                i.putExtra(Constant.COMPLETE_PRODUCTS,complete.product);
                startActivity(i);
            }
        });
    }
}
