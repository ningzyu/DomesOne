package com.nzy.dome1.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.nzy.dome1.MainActivity;
import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;
import com.nzy.dome1.entity.Fujian;
import com.nzy.dome1.util.Utils;
import com.nzy.dome1.view.SlideBars;

import java.util.ArrayList;
import java.util.List;


public class Activity10 extends BaseActivity {
    private TextView float_letter;
    private ListView lv;
    private SlideBars mSlideBar;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);
        initToolBar(getIntent().getStringExtra("title"),true);
        mSlideBar= (SlideBars) findViewById(R.id.slideBar);
        float_letter= (TextView) findViewById(R.id.float_letter);
        lv= (ListView) findViewById(R.id.a10_lv);
        initData();
        myAdapter ada=new myAdapter();
        lv.setAdapter(ada);
        mSlideBar.setOnTouchLetterChangeListenner(new SlideBars.OnTouchLetterChangeListenner() {
            @Override
            public void onTouchLetterChange(boolean isTouched, String s) {

                float_letter.setText(s);
                if (isTouched) {
                    float_letter.setVisibility(View.VISIBLE);
                } else {
                    float_letter.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            float_letter.setVisibility(View.GONE);
                        }
                    }, 100);
                }
                int position = list.indexOf(s);
                lv.setSelection(position);
            }
        });
    }

    private void initData() {
        String[] s={"啊","不","从","的","额","发","个","和","都","就","看","来","没","你","哦","怕","去","日","是","他","有","v","为","下","也","在"};
        for (int i=0;i<s.length;i++){
            for (int j=0;j<20;j++){
                list.add(s[i]);
            }
        }
    }
    class myAdapter extends BaseAdapter {
        private LayoutInflater inflater;//布局填充器
        public myAdapter(){
            inflater=(LayoutInflater) Activity10.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                view=inflater.inflate(R.layout.list_item,null);
            }
            TextView bt= (TextView) view.findViewById(R.id.a10_tv);
            bt.setText(list.get(i));

            return view;
        }
    }

}
