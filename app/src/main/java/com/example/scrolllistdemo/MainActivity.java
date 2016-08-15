package com.example.scrolllistdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

import com.example.scrolllistdemo.view.MyHScrollView;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private MyHScrollView myHScorllView;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        myHScorllView = (MyHScrollView) findViewById(R.id.myHScorllView);

        listView.setAdapter(new MyAdapter(this, myHScorllView));

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //当在列头 和 listView控件上touch时，将这个touch的事件分发给 ScrollView
                myHScorllView.onTouchEvent(motionEvent);
                return false;
            }
        });

        myHScorllView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {//最先触发的
//        return super.dispatchTouchEvent(ev);//返回false 向下传递触摸事件  返回true 不向下传递触摸事件
//    }

}
