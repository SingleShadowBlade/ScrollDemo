package com.example.scrolllistdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.scrolllistdemo.view.MyHScrollView;


/**
 * Created by Lizhangfeng on 2016/8/1 0001.
 * Description:
 */
public class MyAdapter extends BaseAdapter {

    private Context context;

    private MyHScrollView myHScorllView;

    public MyAdapter(Context context,MyHScrollView myHScorllView) {
        this.context = context;
        this.myHScorllView = myHScorllView;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHodler viewHodler = null;
        if (convertView == null) {
            viewHodler = new ViewHodler();
            convertView = View.inflate(context, R.layout.item_test, null);
            viewHodler.myHScorllView = (MyHScrollView) convertView.findViewById(R.id.myHScorllView);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }

        final ViewHodler finalViewHodler = viewHodler;

        myHScorllView.AddOnScrollChangedListener(new MyHScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                finalViewHodler.myHScorllView.smoothScrollTo(l,t);
            }
        });

        return convertView;
    }

    private class ViewHodler {
        MyHScrollView myHScorllView;
    }

}
