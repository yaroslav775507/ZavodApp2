package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompleteWorker extends AppCompatActivity {
    private EditText Details, Product;
    private DatabaseReference mDataBase;
    private String COMPLETE_KEY = "Complete";
    private Switch aSwitch;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_worker);
        init();
    }
    private void init()
    {
        Details = findViewById(R.id.Details);
        Product = findViewById(R.id.Product);
        mDataBase = FirebaseDatabase.getInstance().getReference(COMPLETE_KEY);
        aSwitch =(Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getBaseContext(),"Нажмите на кнопку чтобы сохранить",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(),"Подтвердите сборку",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void SaveButt(View view)
    {
        String id = mDataBase.getKey();
        String details = Details.getText().toString();
        String product = Product.getText().toString();
        Complete newComplete = new Complete (id,details,product);
        if(!TextUtils.isEmpty(details) && !TextUtils.isEmpty(product))
        {
            mDataBase.push().setValue(newComplete);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }
    }
}
