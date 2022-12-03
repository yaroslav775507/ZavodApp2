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

public class MainActivityUser extends AppCompatActivity {
        private EditText edFullName, edJobtitle, edExperience,edEducation;
        private DatabaseReference mDataBase;
        private String USER_KEY = "User";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            init();
        }
        private void init()
        {
            edFullName = findViewById(R.id.edFullname);
            edJobtitle = findViewById(R.id.edJobtitle);
            edExperience = findViewById(R.id.edExperience);
            edEducation = findViewById(R.id.edEducation);
            mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
        }

        public void onClickSave(View view)
        {
            String id = mDataBase.getKey();
            String fullname = edFullName.getText().toString();
            String jobtitle = edJobtitle.getText().toString();
            String experience = edExperience.getText().toString();
            String education = edEducation.getText().toString();
            User newUser = new User(id,fullname,jobtitle,experience,education);
            if(!TextUtils.isEmpty(fullname) && !TextUtils.isEmpty(jobtitle) && !TextUtils.isEmpty(experience)&& !TextUtils.isEmpty(education))
            {
                mDataBase.push().setValue(newUser);
                Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivityUser.this, ReadActivityUser.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
            }

        }


    }
