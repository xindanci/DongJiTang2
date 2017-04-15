package com.huanghuai.djt.dongjitang.Fragment;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.huanghuai.djt.dongjitang.Activity.IdentificationActivity;
import com.huanghuai.djt.dongjitang.Activity.MapnavigationActivity;
import com.huanghuai.djt.dongjitang.Activity.NewsActivity;
import com.huanghuai.djt.dongjitang.Activity.SearchActivity;
import com.huanghuai.djt.dongjitang.Activity.SearchConsultation;
import com.huanghuai.djt.dongjitang.Bean.ADInfo;
import com.huanghuai.djt.dongjitang.CustomUI.SimpleCycleViewPager;
import com.huanghuai.djt.dongjitang.Net.HomeFragmentNet;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ActivityJumpUtils;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private SimpleCycleViewPager simpleCycleViewPager;
    private ImageView ic_iv_search, iv_home_bell;
    //免费咨询，找医师
    private LinearLayout search_doctor, search_consultation;
    //预约挂号，体质辨识,在线药房，地图导航
    private LinearLayout it_appointment_home,
            it_identification_home, it_onlinebooking_home, it_mapnavigation_home;
    private HomeFragmentNet homeFragmentNet;
    //轮播图连网 解析到的图片 地址2
    private List<String> loopnetUrls;
    private ScrollView bordy_scrollview;



    //轮播图的对象集合
    private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();
    //获取homeFragemnt的联网所需要的数据
    public HomeFragment(Context context) {
        this.mcontext = context;
    }

    @Override
    protected void initView() {
        Fresco.initialize(mcontext);
        ic_iv_search = (ImageView) view.findViewById(R.id.ic_iv_search);
        iv_home_bell = (ImageView) view.findViewById(R.id.ic_home_bell);
        search_consultation = (LinearLayout) view.findViewById(R.id.search_consultation);
        search_doctor = (LinearLayout) view.findViewById(R.id.search_doctor);
        it_appointment_home= (LinearLayout) view.findViewById(R.id.it_appointment_home);
        it_identification_home= (LinearLayout) view.findViewById(R.id.it_identification_home);
        it_onlinebooking_home= (LinearLayout) view.findViewById(R.id.it_onlinebooking_home);
        it_mapnavigation_home= (LinearLayout) view.findViewById(R.id.it_mapnavigation_home);
        simpleCycleViewPager= (SimpleCycleViewPager) view.findViewById(R.id.mySimapleCycleViewPager);
//        bordy_scrollview= (ScrollView) view.findViewById(R.id.bord_scrollview);
    }

    @Override
    protected void initListener() {
        ic_iv_search.setOnClickListener(this);
        iv_home_bell.setOnClickListener(this);
        search_consultation.setOnClickListener(this);
        search_doctor.setOnClickListener(this);
        it_mapnavigation_home.setOnClickListener(this);
        it_onlinebooking_home.setOnClickListener(this);
        it_identification_home.setOnClickListener(this);
        it_appointment_home.setOnClickListener(this);

    }

    @Override
    protected void initDate() {
        infos.clear();
        if (homeFragmentNet==null) {
            homeFragmentNet=new HomeFragmentNet();
        }
        loopnetUrls= homeFragmentNet.getListDate();
        simpleCycleViewPager.setDatasource(loopnetUrls);
//        bordy_scrollview.setVerticalScrollBarEnabled(false);

    }



    @Override
    public void getmContext() {
        mcontext = view.getContext();
    }

    @Override
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_home_page, null);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ic_iv_search:
                ToastUtils.showInfo(mcontext, "我是搜索");
                ActivityJumpUtils.JumpIntentActivity(mcontext, SearchActivity.class);
                break;
            case R.id.ic_home_bell:
                ToastUtils.showInfo(mcontext, "我是消息");
                ActivityJumpUtils.JumpIntentActivity(mcontext, NewsActivity.class);
                break;
            case R.id.search_consultation:
                ToastUtils.showInfo(mcontext, "我是咨询");
                ActivityJumpUtils.JumpIntentActivity(mcontext, SearchConsultation.class);
                break;
            case R.id.search_doctor:
                ToastUtils.showInfo(mcontext, "我是找医生");
                ActivityJumpUtils.JumpIntentActivity(mcontext, SearchActivity.class);
                break;
            case R.id.it_appointment_home:
                //预约挂号
                ToastUtils.showInfo(mcontext,"预约挂号");
                getFragmentManager()
                        .beginTransaction()
                                     .addToBackStack(null)  //将当前fragment加入到返回栈中
                                   .replace(R.id.fragment_container, new DiagnosisFragment(mcontext)).commit();
                break;
            case R.id.it_identification_home:
                //体质辨识
                ToastUtils.showInfo(mcontext,"体质辨识");
                ActivityJumpUtils.JumpIntentActivity(mcontext, IdentificationActivity.class);
                break;
            case R.id.it_onlinebooking_home:
                //在线药房
                ToastUtils.showInfo(mcontext,"在线药房");
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.fragment_container, new OnlineFragment(mcontext)).commit();
                break;
            case R.id.it_mapnavigation_home:
                //地图导航
                ToastUtils.showInfo(mcontext,"地图导航");
                ActivityJumpUtils.JumpIntentActivity(mcontext, MapnavigationActivity.class);
                break;
            default:
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("获取焦点","huoqujiaodian");
    };

    @Override
    public void onPause() {
        super.onPause();

        Log.e("失去焦点","shiqujiaodian");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e("销毁","销毁");
    }
}
