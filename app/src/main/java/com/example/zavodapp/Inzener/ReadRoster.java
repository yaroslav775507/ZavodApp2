package com.example.zavodapp.Inzener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zavodapp.Constant;
import com.example.zavodapp.Products;
import com.example.zavodapp.R;
import com.example.zavodapp.ReadActivityProduct;
import com.example.zavodapp.ShowActivityProduct;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadRoster extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Roster> listTemp;

    private DatabaseReference mDataBase;
    private String ROSTER_KEY = "Roster";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_roster);
        init();
        getDataFromDB();
        setOnClickItem();
    }
    private void init()
    {
        listView = findViewById(R.id.ListRoster);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(ROSTER_KEY);
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
                    Roster roster = ds.getValue(Roster.class);
                    assert roster != null;
                    listData.add(roster.ComplDetalls);
                    listTemp.add(roster);
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
                Roster roster = listTemp.get(position);
                Intent i = new Intent(ReadRoster.this, ShowRoster.class);
                i.putExtra(Constant.ROSTER_COMPL,roster.ComplDetalls);
                i.putExtra(Constant.ROSTER_1,roster.prod1);
                i.putExtra(Constant.ROSTER_2,roster.prod2);
                i.putExtra(Constant.ROSTER_3,roster.prod3);
                i.putExtra(Constant.ROSTER_4,roster.prod4);
                i.putExtra(Constant.ROSTER_5,roster.prod5);
                startActivity(i);
            }
        });
    }
}
