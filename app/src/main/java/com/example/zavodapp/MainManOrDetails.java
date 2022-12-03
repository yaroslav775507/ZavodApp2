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

public class MainManOrDetails extends AppCompatActivity {
    private EditText  edWorker,edInjenerr,edDetalss,edProduct;
    private DatabaseReference mDataBase;
    private String WORKLIST_KEY = "WorkList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_manordetails_layout);
        init();
    }
    private void init()
    {
        edWorker = findViewById(R.id.edWorker);
        edInjenerr = findViewById(R.id.edInjenerr);
        edDetalss = findViewById(R.id.edDetalss);
        edProduct = findViewById(R.id.edProduct);
        mDataBase = FirebaseDatabase.getInstance().getReference(WORKLIST_KEY);
    }

    public void SaveMod(View view)
    {
        String id = mDataBase.getKey();
        String work = edWorker.getText().toString();
        String injener = edInjenerr.getText().toString();
        String products = edProduct.getText().toString();
        String details = edDetalss.getText().toString();
        WorkList newWorkList = new WorkList(id,work,injener,products,details);
        if(!TextUtils.isEmpty(work) && !TextUtils.isEmpty(injener) && !TextUtils.isEmpty(products)&&!TextUtils.isEmpty(details))
        {
            mDataBase.push().setValue(newWorkList);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainManOrDetails.this, ReadManOrDetails.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }

    }
}
