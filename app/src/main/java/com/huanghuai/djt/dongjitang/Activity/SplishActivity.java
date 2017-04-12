package com.huanghuai.djt.dongjitang.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.huanghuai.djt.dongjitang.Adpter.ViewPagerAdapter;
import com.huanghuai.djt.dongjitang.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@TargetApi(Build.VERSION_CODES.M)
public class SplishActivity extends BaseActivity implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private ViewPager viewPager;
    //ViewPager的适配器
    private ViewPagerAdapter vpAdapter;
    //要加载显示的图片集合
    private List<View> views;
    // 底部小点图片
    private ImageView[] dots;
    // 记录当前选中位置
    private int currentIndex;
    //点的容器
    private LinearLayout ll;
    //
    private Button bt_login;
    @Override
    public int getContentView() {
        return R.layout.activity_splish;
    }

    @Override
    protected void activityGetActivity() {
        Intent intent=getIntent();
    }

    @Override
    protected void initView() {
        views = new ArrayList<View>();
        viewPager= (ViewPager) findViewById(R.id.viewpager);

        bt_login= (Button) findViewById(R.id.bt_login);
        LayoutInflater inflater = LayoutInflater.from(this);
        RelativeLayout guideFour = (RelativeLayout) inflater.inflate(R.layout.guide_four, null);
        RelativeLayout guideOne = (RelativeLayout) inflater.inflate(R.layout.guide_one, null);
        RelativeLayout guideTwo = (RelativeLayout) inflater.inflate(R.layout.guide_two, null);
        RelativeLayout guideThree = (RelativeLayout) inflater.inflate(R.layout.guide_three, null);
        views.add(guideOne);
        views.add(guideTwo);
        views.add(guideThree);
        views.add(guideFour);
        // 初始化底部小点
        initDots();
    }

    private void initDots() {
         ll = (LinearLayout) findViewById(R.id.ll);

        dots = new ImageView[views.size()];

        // 循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setBackgroundResource(R.mipmap.bai);
        }

        currentIndex = 0;
        dots[currentIndex].setBackgroundResource(R.mipmap.red);// 设置为红色，即选中状态
    }
    //设置选中
    private void setCurrentDot(int position) {
        currentIndex = position;

        if (position < 0 || position > views.size() - 1
                ) {
            return;
        }
        if (position==views.size()-1)
        {
            ll.setVisibility(View.GONE);
            bt_login.setVisibility(View.VISIBLE);

        }
        else
        {
            ll.setVisibility(View.VISIBLE);
            bt_login.setVisibility(View.GONE);
        }
        for (int i = 0; i < views.size(); i++) {
            dots[i].setBackgroundResource(R.mipmap.bai);
            if (currentIndex==i) {
                dots[currentIndex].setBackgroundResource(R.mipmap.red);
            }
        }
    }

    @Override
    protected void initDate() {
        vpAdapter=new ViewPagerAdapter(views,this);
        viewPager.setAdapter(vpAdapter);
    }

    @Override
    protected void initLitener() {
    viewPager.setOnPageChangeListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }

    @Override
    protected void addActivity() {
        activities.add(this);
    }


    //ViewPager的监听器

    /**
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     * 状态发生改变的时候调用
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 当页面选中的时候调用
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        setCurrentDot(position);
    }
    /**
    当页面状态 改变的 时候调用
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //button 的点击监听
    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(mcontext,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
