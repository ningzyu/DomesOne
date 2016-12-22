package com.nzy.dome1.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

public class Activity06 extends BaseActivity {
    //模拟长度为100
    private int [] data=new int[100];
    int hasData=0;
    //记录完成度
    int status=0;
    ProgressBar bar,bar2;
    //跟新进度的handler
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //表明消息是本程序发送
            if(msg.what==0){
                bar.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_06);
        initToolBar(getIntent().getStringExtra("title"),true);
        bar= (ProgressBar) findViewById(R.id.bar);
        bar2= (ProgressBar) findViewById(R.id.bar2);
        //启动线程执行任务
        new Thread(){
            @Override
            public void run() {
                while (status<100){
                    //获取耗时操作的百分比
                    status=dowork();
                    //发送消息
                    handler.sendEmptyMessage(0);
                }
            }
        }.start();
    }

    private int dowork() {
        //为数组元素赋值
        data[hasData++]=(int)(Math.random()*100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
