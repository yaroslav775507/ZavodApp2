package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityDetals extends AppCompatActivity {
    private EditText edMaterial, edSize, edUniqNum;
    private DatabaseReference mDataBase;
    private String DETAILS_KEY = "Details";


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_details);
        init();
    }
    private void init()
    {
        edMaterial = findViewById(R.id.edMaterial);
        edSize = findViewById(R.id.edSize);
        edUniqNum = findViewById(R.id.edUniqName);
        mDataBase = FirebaseDatabase.getInstance().getReference(DETAILS_KEY);
    }
    public void SaveClick(View view)
    {
        String id = mDataBase.getKey();
        String material = edMaterial.getText().toString();
        String size = edSize.getText().toString();
        String uniqnum = edUniqNum.getText().toString();
        Details newDetails = new Details (id,material,size,uniqnum);
        if(!TextUtils.isEmpty(material) && !TextUtils.isEmpty(size) && !TextUtils.isEmpty(uniqnum))
        {
            mDataBase.push().setValue(newDetails);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivityDetals.this, ReadActivityDetails.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }
    }
}
