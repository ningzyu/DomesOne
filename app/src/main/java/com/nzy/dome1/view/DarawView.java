package com.nzy.dome1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by NZY on 2016/12/19.
 */

public class DarawView extends View {
    public float currentX=40;
    public float currentY=50;
    //定义并创建画笔
    Paint p=new Paint();
    public DarawView(Context context) {
        super(context);
    }

    public DarawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    //该方法负责在该控件的指定位置绘制一个小球
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        p.setColor(Color.BLUE);
        canvas.drawCircle(currentX,currentY,15,p);
    }
    //为该组件的触碰事件重写事件处理方法

    @Override//触摸屏事件
    public boolean onTouchEvent(MotionEvent event) {
        currentX=event.getX();
        currentY=event.getY();
        //通知当前组件重绘自己
        invalidate();
        //返回true表明该处理方法已处理该事件
        return true;

    }
}
