
package com.nzy.dome1.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SearchView;
import android.widget.Toast;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

public class Activity08 extends BaseActivity {
    NumberPicker np1,np2;
    int min=25,max=75;

    private SearchView sv;
    private ListView lv;
    //集合
    private String [] s={"aaaaaaaaaa","bbbbbbb","cccccccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_08);
        initToolBar(getIntent().getStringExtra("title"),true);
        getnp();
        showsv();
    }

    private void showsv() {
        lv= (ListView) findViewById(R.id.a8_lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s));
        //lsitview启用过滤
        lv.setTextFilterEnabled(true);
        sv= (SearchView) findViewById(R.id.sv);
        //设置是否自动缩小为图标
        sv.setIconifiedByDefault(false);
        //师傅显示搜索按钮
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //如果sv长度不为0
                if (TextUtils.isEmpty(s)){
                    //清除listview的过滤
                    lv.clearTextFilter();
                }else{
                    //使用输入的内容对列表项进行过滤
                    lv.setFilterText(s);
                }
                return true;
            }

            @Override//单击按钮时激发
            public boolean onQueryTextChange(String s) {
                //实际应用中应该在该方法中执行实际查询
                //此处土司
                Toast.makeText(Activity08.this,"是"+s,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void getnp() {
        np1= (NumberPicker) findViewById(R.id.np1);
        np1.setMinValue(10);
        np1.setMaxValue(50);
        np1.setValue(min);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override//当值改变时触发该方法
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                min=i1;
                showprice();
            }
        });
        np2= (NumberPicker) findViewById(R.id.np2);
        np2.setMinValue(60);
        np2.setMaxValue(100);
        np2.setValue(max);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override//当值改变时触发该方法
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                max=i1;
                showprice();
            }
        });
    }

    private void showprice() {
        Toast.makeText(this,"最低"+min+"最高"+max,Toast.LENGTH_SHORT).show();
    }
}
