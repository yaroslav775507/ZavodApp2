package com.example.zavodapp.Inzener;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zavodapp.Details;
import com.example.zavodapp.R;
import com.example.zavodapp.ReadActivityDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainRoster extends AppCompatActivity {
    private EditText edComplDetalls,edprod1,edprod2,edprod3,edprod4,edprod5;
    private DatabaseReference mDataBase;
    private String ROSTER_KEY = "Roster";


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roaster_main);
        init();
    }
    private void init()
    {
        edComplDetalls = findViewById(R.id.edComplDetalls);
        edprod1 = findViewById(R.id.edprod1);
        edprod2 = findViewById(R.id.edprod2);
        edprod3 = findViewById(R.id.edprod3);
        edprod4 = findViewById(R.id.ededprod4);
        edprod5 = findViewById(R.id.edprod5);
        mDataBase = FirebaseDatabase.getInstance().getReference(ROSTER_KEY);
    }
    public void SaveRoaster(View view)
    {
        String id = mDataBase.getKey();
        String ComplDetalls = edComplDetalls.getText().toString();
        String prod1 = edprod1.getText().toString();
        String prod2 = edprod2.getText().toString();
        String prod3 = edprod3.getText().toString();
        String prod4 = edprod4.getText().toString();
        String prod5 = edprod5.getText().toString();
        Roster newRoster = new Roster (id,ComplDetalls,prod1,prod2,prod3,prod4,prod5);
        if(!TextUtils.isEmpty(ComplDetalls) && !TextUtils.isEmpty(prod1) && !TextUtils.isEmpty(prod2))
        {
            mDataBase.push().setValue(newRoster);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainRoster.this, ReadActivityDetails.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Минимум 2 детали", Toast.LENGTH_SHORT).show();
        }
    }
}
