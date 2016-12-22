package com.nzy.dome1.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Activity09 extends BaseActivity {
    ListView lv;
    TextView tv;
    File path;
    File[] files;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_09);
        initView();
    }

    private void initView() {
        lv= (ListView) findViewById(R.id.list);
        tv= (TextView) findViewById(R.id.path);
        //获取系统的SD卡目录
        File root=new File("/mnt/sdcard/");
        //如果Sd卡存在
        if (root.exists()){
            path=root;
            files=root.listFiles();
            //使用当前目录下的全部文件、文件夹来填充列表
            inflateListview(files);
        }
        //列表项点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //用户单击了文件，直接返回，不做处理
                if (files[i].isFile()) return;
                //获取单机的文件夹下所有文件
                File[] tmp=files[i].listFiles();
                if (tmp==null||tmp.length==0){
                    Toast.makeText(Activity09.this,"",Toast.LENGTH_SHORT).show();
                }else {
                    //获取点击的列表项对应的文件夹，设为当前父文件夹
                    path=files[i];
                    //保存当前父文件夹内全部文件和文件夹
                    files=tmp;
                    //再次更新列表
                    inflateListview(files);
                }

            }
        });
        Button btn= (Button) findViewById(R.id.parent);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!path.getCanonicalPath().equals("/mnt/sdcard/")){
                        //获取上级目录
                        path=path.getParentFile();
                        //列出当前目录下所有文件
                        files=path.listFiles();
                        //更新列表
                        inflateListview(files);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void inflateListview(File[] files) {
        //创建集合
        List<Map<String,Object>> list=new ArrayList<>();
        for (int i=0;i<files.length;i++){
            Map<String,Object> map=new HashMap<>();
            //判断是否文件夹，赋值图标
            if (files[i].isDirectory()){
                map.put("icon",R.drawable.b1);
            }else {
                map.put("icon",R.drawable.b2);
            }
            map.put("name",files[i].getName());
            list.add(map);
        }
        SimpleAdapter sim=new SimpleAdapter(this,list,R.layout.a9_item,
                new String[]{"icon","name"},new int[]{R.id.iv_file,R.id.tv_file});
        lv.setAdapter(sim);
        try {
            tv.setText("当前路径为:"+path.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
