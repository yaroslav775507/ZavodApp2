package com.example.zavodapp.Inzener;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zavodapp.Constant;
import com.example.zavodapp.R;

public class ShowRoster extends AppCompatActivity {
    private TextView tvComRoster,tv1, tv2, tv3, tv4, tv5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_roster);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvComRoster = findViewById(R.id.tvComRoster);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvComRoster.setText(i.getStringExtra(Constant.ROSTER_COMPL));
            tv1.setText(i.getStringExtra(Constant.ROSTER_1));
            tv2.setText(i.getStringExtra(Constant.ROSTER_2));
            tv3.setText(i.getStringExtra(Constant.ROSTER_3));
            tv4.setText(i.getStringExtra(Constant.ROSTER_4));
            tv5.setText(i.getStringExtra(Constant.ROSTER_5));
        }
    }
}
