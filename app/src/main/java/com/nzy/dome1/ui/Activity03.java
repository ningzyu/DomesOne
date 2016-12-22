package com.nzy.dome1.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.nzy.dome1.R;

public class Activity03 extends AppCompatActivity {
    QuickContactBadge badge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_03);
        badge= (QuickContactBadge) findViewById(R.id.badge);
        badge.assignContactFromPhone("15383612393",false);
    }
}
