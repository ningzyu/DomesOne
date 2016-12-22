package com.nzy.dome1.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;

import com.nzy.dome1.R;
import com.nzy.dome1.base.BaseActivity;

public class Activity07 extends BaseActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗口样式：启用显示进度的进度条
//        requestWindowFeature(Window.FEATURE_PROGRESS);
        //设置窗口特征：启用不显示进度的进度条
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_07);
        initToolBar(getIntent().getStringExtra("title"),true);
        iv= (ImageView) findViewById(R.id.a7_iv);
        click();
        getSeekBar();
        getrating();
    }

    private void click() {
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //不带进度
//                setProgressBarIndeterminateVisibility(true);
//                //带进度
//                setProgressBarVisibility(true);
//                //进度
//                setProgress(4500);
//            }
//        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //不带进度
//                setProgressBarIndeterminateVisibility(false);
//                //带进度
//                setProgressBarVisibility(false);
//            }
//        });
    }

    public void getSeekBar() {

        SeekBar seek= (SeekBar) findViewById(R.id.seek);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //动态改变透明度
                iv.setImageAlpha(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void getrating() {
        final RatingBar rating= (RatingBar) findViewById(R.id.rating);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                v=(iv.getImageAlpha()*5)/255;
                iv.setImageAlpha((int)(v * 255/5));
            }
        });
    }
}
