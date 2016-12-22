
package com.nzy.dome1.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

public class Activity04 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04);
        //创建一个对象
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
            int[]logos=new int[]{
                    R.drawable.t1,
                    R.drawable.t2,
                    R.drawable.t3,
            };
            private String[] armTypes={
                    "天","地","人"
            };
            private  String[][] arms={
                    {"天","地","玄","黄"},{"宇","宙","洪","荒"},{"金","木","水","火"}
            };

            @Override//获取指定组位置，指定子列表项处的子列表项数据
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }
            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }
            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }
            private TextView getTextView(){
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(Activity04.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }
            //该方法决定每个子选项的外观
            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView tv=getTextView();
                tv.setText(getChild(i,i1).toString());
                return tv;
            }
            //获取指定组位置处的组数据
            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }
            @Override
            public int getGroupCount() {
                return armTypes.length;
            }
            @Override
            public long getGroupId(int i) {
                return i;
            }
            //该方法决定每个组选项的外观
            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout li=new LinearLayout(Activity04.this);
                li.setOrientation(0);
                ImageView logo=new ImageView(Activity04.this);
                logo.setImageResource(logos[i]);
                li.addView(logo);
                TextView tv=getTextView();
                tv.setText(getGroup(i).toString());
                li.addView(tv);
                return li;
            }
            @Override
            public boolean hasStableIds() {
                return true;
            }
            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
        };
        ExpandableListView ex= (ExpandableListView) findViewById(R.id.ex);
        ex.setAdapter(adapter);
    }
}
