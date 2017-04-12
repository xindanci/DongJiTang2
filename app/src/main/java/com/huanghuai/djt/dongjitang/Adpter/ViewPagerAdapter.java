package com.huanghuai.djt.dongjitang.Adpter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.huanghuai.djt.dongjitang.Activity.SplishActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class ViewPagerAdapter extends PagerAdapter{
    private List<View> views;
    private SplishActivity activity;
    public ViewPagerAdapter(List<View> views, SplishActivity activity)
    {
        this.views = views;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        if (views!=null) {
            return views.size();
        }
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position),0);
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
