package com.nzy.dome1.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

public class Activity01 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
        initToolBar("TextView",true);
    }
}
