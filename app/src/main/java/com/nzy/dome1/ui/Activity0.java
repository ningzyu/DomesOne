package com.nzy.dome1.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;
import com.nzy.dome1.view.DarawView;

import java.util.Timer;
import java.util.TimerTask;

public class Activity0 extends BaseActivity {
    private int currentColor;
    final int [] colors={R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6};
    final int []names={R.id.a0_v01,R.id.a0_v02,R.id.a0_v03,R.id.a0_v04,R.id.a0_v05,R.id.a0_v06};
    TextView[] views=new TextView[names.length];
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //表明消息是从本程序发送的
            if (msg.what==0x123){
                for (int i=0;i<names.length;i++){
                    views[i].setBackgroundResource(colors[(i+currentColor)%names.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        initToolBar("学习总结汇总",false);
        Draw();
        cuee();
    }
    //迷魂灯
    private void cuee() {
        for (int i=0;i<names.length;i++){
            views[i]= (TextView) findViewById(names[i]);
        }
        //定义一个线程，周期性的改变currentColor变量值
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                //发送消息通知系统改变text View的背景
                handler.sendEmptyMessage(0x123);
            }
        },0,200);
    }


    //自定义可拖动的小球，就这一个方法，替代XML
    private void Draw() {
//        LinearLayout layout= (LinearLayout) findViewById(R.id.activity_0);
//        DarawView daraw=new DarawView(this);
//        //设置view的最小宽高
//        daraw.setMinimumWidth(300);
//        daraw.setMinimumHeight(500);
//        layout.addView(daraw);
    }
}
