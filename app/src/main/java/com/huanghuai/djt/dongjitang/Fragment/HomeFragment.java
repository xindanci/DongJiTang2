package com.huanghuai.djt.dongjitang.Fragment;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huanghuai.djt.dongjitang.Activity.IdentificationActivity;
import com.huanghuai.djt.dongjitang.Activity.MapnavigationActivity;
import com.huanghuai.djt.dongjitang.Activity.NewsActivity;
import com.huanghuai.djt.dongjitang.Activity.SearchActivity;
import com.huanghuai.djt.dongjitang.Activity.SearchConsultation;
import com.huanghuai.djt.dongjitang.Bean.ADInfo;

import com.huanghuai.djt.dongjitang.CustomUI.ImageCycleView;
import com.huanghuai.djt.dongjitang.CustomUI.ImageCycleView.ImageCycleViewListener;
import com.huanghuai.djt.dongjitang.Net.HomeFragmentNet;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ActivityJumpUtils;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/10.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ic_iv_search, iv_home_bell;
    //免费咨询，找医师
    private LinearLayout search_doctor, search_consultation;
    //预约挂号，体质辨识,在线药房，地图导航
    private LinearLayout it_appointment_home,
            it_identification_home, it_onlinebooking_home, it_mapnavigation_home;
    private HomeFragmentNet homeFragmentNet;
    //轮播图连网 解析到的图片 地址2
    private String [] loopnetUrls;
    //轮播图组件
    private ImageCycleView cycleViewPager;
    //
    ImageCycleViewListener mAdCycleViewListener;

    //轮播图的对象集合
    private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();
    //获取homeFragemnt的联网所需要的数据
    public HomeFragment(Context context) {
        this.mcontext = context;
    }

    @Override
    protected void initView() {
        ic_iv_search = (ImageView) view.findViewById(R.id.ic_iv_search);
        iv_home_bell = (ImageView) view.findViewById(R.id.ic_home_bell);
        search_consultation = (LinearLayout) view.findViewById(R.id.search_consultation);
        search_doctor = (LinearLayout) view.findViewById(R.id.search_doctor);
        it_appointment_home= (LinearLayout) view.findViewById(R.id.it_appointment_home);
        it_identification_home= (LinearLayout) view.findViewById(R.id.it_identification_home);
        it_onlinebooking_home= (LinearLayout) view.findViewById(R.id.it_onlinebooking_home);
        it_mapnavigation_home= (LinearLayout) view.findViewById(R.id.it_mapnavigation_home);
        cycleViewPager= (ImageCycleView) view.findViewById(R.id.ad_view);
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
        getRcycleListener();
    }

    @Override
    protected void initDate() {
        if (homeFragmentNet==null) {
            homeFragmentNet=new HomeFragmentNet();
        }
        loopnetUrls= homeFragmentNet.getListDate();
        for(int i=0;i < loopnetUrls.length; i ++){
            ADInfo info = new ADInfo();
            info.setUrl(loopnetUrls[i]);
            //info.setContent("top-->" + i);
            infos.add(info);
        }
        cycleViewPager.setImageResources(infos, mAdCycleViewListener);
    }
    private void getRcycleListener()
    {
        mAdCycleViewListener = new ImageCycleViewListener() {

        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {
            ToastUtils.showInfo(mcontext,"----->"+position);
        }

        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            //ImageLoader.getInstance().displayImage(imageURL, imageView);// 使用ImageLoader对图片进行加装！
            Log.e("---------->",imageURL);
        }
    };
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
        cycleViewPager.startImageCycle();
    };

    @Override
    public void onPause() {
        super.onPause();
        cycleViewPager.pushImageCycle();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cycleViewPager.pushImageCycle();
    }
}
