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

public class ReadManOrDetails extends AppCompatActivity {
    private ListView listMod;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<WorkList> listTemp;

    private DatabaseReference mDataBase;
    private String  WORKLIST_KEY = "WorkList";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_mod);
        init();
        getDataFromDB();
        setOnClickItem();
    }
    private void init()
    {
        listMod = findViewById(R.id.ListMod);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listData);
        listMod.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference( WORKLIST_KEY);
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
                    WorkList workList = ds.getValue(WorkList.class);
                    assert workList != null;
                    listData.add(workList.Inzjener);
                    listTemp.add(workList);
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
        listMod.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WorkList workList = listTemp.get(position);
                Intent i = new Intent(ReadManOrDetails.this, ShowManOrDetails.class);
                i.putExtra(Constant.MOR_INZJ,workList.Inzjener);
                i.putExtra(Constant.MOR_WORKER,workList.Worker);
                i.putExtra(Constant.MOR_DETAILS,workList.details);
                i.putExtra(Constant.MOR_PROD,workList.products);
                startActivity(i);
            }
        });
    }
}
