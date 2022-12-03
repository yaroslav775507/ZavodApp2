package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityProduct extends AppCompatActivity {
    private EditText edScale, edNumpats,edIndivnum;
    private DatabaseReference mDataBase;
    private String PRODUCTS_KEY = "Products";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_prod);
        init();
    }
    private void init()
    {
        edScale = findViewById(R.id.edScale);
        edNumpats = findViewById(R.id.edNumpats);
        edIndivnum = findViewById(R.id.edIndivnum);
        mDataBase = FirebaseDatabase.getInstance().getReference(PRODUCTS_KEY);
    }

    public void SaveProd(View view)
    {
        String id = mDataBase.getKey();
        String scale = edScale.getText().toString();
        String numpats = edNumpats.getText().toString();
        String indivnumber = edIndivnum.getText().toString();
        Products newProducts = new Products(id,scale,numpats,indivnumber);
        if(!TextUtils.isEmpty(scale) && !TextUtils.isEmpty(numpats) && !TextUtils.isEmpty(indivnumber))
        {
            mDataBase.push().setValue(newProducts);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivityProduct.this, ReadActivityProduct.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }

    }
}
