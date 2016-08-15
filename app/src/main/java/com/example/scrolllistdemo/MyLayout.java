package com.example.scrolllistdemo;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Lizhangfeng on 2016/8/1 0001.
 * Description:
 */
public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {//第一个
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {//第二个
        return super.onInterceptTouchEvent(ev);//返回false 向下传递给View的 dispatchTouchEvent
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//最后触发
        return super.onTouchEvent(event);
    }
}
