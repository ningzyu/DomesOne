package com.nzy.dome1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nzy.dome1.base.BaseActivity;
import com.nzy.dome1.ui.Activity0;
import com.nzy.dome1.ui.Activity01;
import com.nzy.dome1.ui.Activity02;
import com.nzy.dome1.ui.Activity03;
import com.nzy.dome1.ui.Activity04;
import com.nzy.dome1.ui.Activity05;
import com.nzy.dome1.ui.Activity06;
import com.nzy.dome1.ui.Activity07;
import com.nzy.dome1.ui.Activity08;
import com.nzy.dome1.ui.Activity09;
import com.nzy.dome1.ui.Activity10;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{
    private ListView lv;
    List<String> list=new ArrayList<>();
    List<Activity> list1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        initToolBar("学习总结汇总",true);
        ddd();
        myAdapter ada=new myAdapter();
        lv.setAdapter(ada);

    }

    private void ddd() {
        initData("通知栏",new Activity0());
        initData("TextView",new Activity01());
        initData("TextView",new Activity02());
        initData("关联联系人",new Activity03());
        initData("可展开的列表组件",new Activity04());
        initData("自动播放的图片库",new Activity05());
        initData("ProgressBar进度条",new Activity06());
        initData("拖动条",new Activity07());
        initData("数值选择器",new Activity08());
        initData("SD卡文件浏览器",new Activity09());
        initData("弹球游戏",new Activity10());

    }

    private void initData(String s,Activity a) {
        list1.add(a);
        list.add(s);
    }
    class myAdapter extends BaseAdapter{
        private LayoutInflater inflater;//布局填充器
        public myAdapter(){
            inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            if(view==null){//
                view=inflater.inflate(R.layout.main_item,null);
            }

            Button bt= (Button) view.findViewById(R.id.btn);
            bt.setText(list.get(i));
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this,list1.get(i).getClass()).putExtra("title",list.get(i)));
                }
            });
            return view;
        }
    }
}