package com.nzy.dome1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.nzy.dome1.R;

/**
 * Created by NZY on 2016/12/22.
 */

public class PlaneView extends View {
    public float currentX;
    public float currentY;
    Bitmap plane;
    public PlaneView(Context context) {
        super(context);
        //定义飞机图片
        plane= BitmapFactory.decodeResource(context.getResources(), R.drawable.b1);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint p=new Paint();
        //绘制飞机
        canvas.drawBitmap(plane,currentX,currentY,p);
    }
}
