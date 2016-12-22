package com.nzy.dome1.ui;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

public class Activity02 extends BaseActivity {
    Chronometer ch;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        initToolBar("计时器",true);
        Chronomet();
    }

    private void Chronomet() {
        //获取计时器组件
        ch= (Chronometer) findViewById(R.id.ch);
        start= (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch.setBase(SystemClock.elapsedRealtime());
                //启动
                ch.start();
                start.setEnabled(false);
            }
        });
        //为Chronometer绑定监听事件
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //如果从开始计时到现在超过了20秒
                if (SystemClock.elapsedRealtime()-ch.getBase()>20*1000){
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });
    }
}
