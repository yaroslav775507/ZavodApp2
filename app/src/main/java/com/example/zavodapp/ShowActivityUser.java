package com.example.zavodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivityUser extends AppCompatActivity {
    private TextView tvFullname, tvJobtitle, tvExperience,tvEducation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvFullname = findViewById(R.id.tvFullname);
        tvJobtitle = findViewById(R.id.tvJobtitle);
        tvExperience = findViewById(R.id.tvExperience);
        tvEducation = findViewById(R.id.tvEducation);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvFullname.setText(i.getStringExtra(Constant.USER_FULLNAME));
            tvJobtitle.setText(i.getStringExtra(Constant.USER_JOBTITLE));
            tvExperience.setText(i.getStringExtra(Constant.USER_EXPERIENCE));
            tvEducation.setText(i.getStringExtra(Constant.USER_EDUCATION));
        }
    }
}
