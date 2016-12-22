package com.nzy.dome1.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity05 extends BaseActivity implements View.OnClickListener{
    private int [] img={R.drawable.s1,R.drawable.s2
            ,R.drawable.h1,R.drawable.h4,R.drawable.h9,R.drawable.t1
            ,R.drawable.h2,R.drawable.h5,R.drawable.h8,R.drawable.h10
            ,R.drawable.h3,R.drawable.h6,R.drawable.h7,R.drawable.h11,
            R.drawable.s4,R.drawable.s4};
    private AdapterViewFlipper flipper;
    private StackView stacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        initToolBar(getIntent().getStringExtra("title"),true);
        initView();
        getflipper();
        getstack();

    }

    private void initView() {
        flipper= (AdapterViewFlipper) findViewById(R.id.flipper);
        stacks= (StackView) findViewById(R.id.stack);
        findViewById(R.id.prev).setOnClickListener(this);
        findViewById(R.id.auto).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.prev:
                flipper.showPrevious();//上一个
                flipper.stopFlipping();//停止自动

                stacks.showPrevious();
                break;
            case R.id.auto:
                flipper.startFlipping();//自动
                break;
            case R.id.next:
                flipper.showNext();//下一个
                flipper.stopFlipping();//停止自动

                stacks.showNext();
                break;
        }
    }

    public void getflipper() {
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return img.length;
            }

            @Override
            public Object getItem(int i) {
                return img[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView iv=new ImageView(Activity05.this);
                iv.setImageResource(img[i]);
                //设置缩放类型
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //设置布局参数
                iv.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                ));
                return iv;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void getstack() {
        List<Map<String,Object>> list=new ArrayList<>();
        for (int i=0;i<img.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",img[i]);
            list.add(map);
        }
        SimpleAdapter sim=new SimpleAdapter(this,list,
                R.layout.a5_item,new String[]{"img"},new int[]{R.id.iv_a5_item});
        stacks.setAdapter(sim);
    }

}
