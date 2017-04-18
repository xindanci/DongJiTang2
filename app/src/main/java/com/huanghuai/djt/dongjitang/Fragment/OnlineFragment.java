package com.huanghuai.djt.dongjitang.Fragment;


import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.huanghuai.djt.dongjitang.Adpter.Online_Shop_Goods_RecycleView_Adapter;
import com.huanghuai.djt.dongjitang.Bean.ADInfo;
import com.huanghuai.djt.dongjitang.Bean.Product_Goods;
import com.huanghuai.djt.dongjitang.CustomUI.FullLinearLayout;
import com.huanghuai.djt.dongjitang.CustomUI.RecycleViewDivider;
import com.huanghuai.djt.dongjitang.CustomUI.ShopCarAnimation;
import com.huanghuai.djt.dongjitang.CustomUI.SimpleCycleViewPager;
import com.huanghuai.djt.dongjitang.Net.OnlineFragmentNet;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class OnlineFragment extends BaseFragment {
    //商品信息的集合对象
    private List<Product_Goods> list_product_goods = new ArrayList<>();
    //轮播图组件
    private SimpleCycleViewPager simpleCycleViewPager;
    //设置商品的种类的数据展示
    private RecyclerView online_shop_goods_recycleview;
    //设置 recycleView的adapter
    private Online_Shop_Goods_RecycleView_Adapter online_shop_goods_recycleView_adapter;
    //在线商城界面的 的联网
    private OnlineFragmentNet onlineFragmentNet;
    //轮播图连网 解析到的图片 地址
    private List<String> loopnetUrls;
    //购物车动画类
    ShopCarAnimation shopCarAnimation;
    //轮播图的对象集合
    private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();
    //获得 底部导航栏的 购物车 imageView 用于处理购物车动画的结束位置
    private ImageView mimageViewShopingCar;
    //获得 fragment的管理类
    private FragmentActivity mfragmentActivity;

    public OnlineFragment(Context context) {
        //上下文 代码运行的 环境
        this.mcontext = context;
    }
    @Override
    protected void initView() {
        Fresco.initialize(mcontext);
        online_shop_goods_recycleview= (RecyclerView) view.findViewById(R.id.online_shop_goods_recycleview);
        //recycleView设置 数据填充和 滑动冲突解决
        online_shop_goods_recycleview.setLayoutManager(new FullLinearLayout(mcontext, 2));
        online_shop_goods_recycleview.addItemDecoration(new RecycleViewDivider(mcontext, 2));
        online_shop_goods_recycleview.setHasFixedSize(true);
        //轮播图
        simpleCycleViewPager = (SimpleCycleViewPager) view.findViewById(R.id.mySimapleCycleViewPager);
        //获得fragmentActivity的管理类
        mfragmentActivity=getActivity();
        //底部导航购物车ImageView
        mimageViewShopingCar= (ImageView) mfragmentActivity.findViewById(R.id.iv_shopcar);
        //创建动画类对象
        shopCarAnimation=new ShopCarAnimation(mcontext,mfragmentActivity,mimageViewShopingCar);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void initDate() {
        if (onlineFragmentNet == null) {
            //当前的页面的 联网工具
            onlineFragmentNet = new OnlineFragmentNet();
        }
        topRollIconImag();
        recycleViewProductInfo();
    }

    @Override
    public void getmContext() {
        mcontext = view.getContext();
    }

    @Override
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_online, null);
        return view;
    }
    /**
     * 轮播图的 数据 获取 和展示
     */
    public void topRollIconImag() {
        infos.clear();
        loopnetUrls = onlineFragmentNet.getListDate();
        simpleCycleViewPager.setDatasource(loopnetUrls);

    }

    /**
     * recycleView的 商品信息的 获取和展示
     */
    public void recycleViewProductInfo() {
        list_product_goods.clear();
        list_product_goods = onlineFragmentNet.getListProductInfo();
        online_shop_goods_recycleView_adapter = new Online_Shop_Goods_RecycleView_Adapter(mcontext, list_product_goods,this);
        online_shop_goods_recycleview.setAdapter(online_shop_goods_recycleView_adapter);
    }

    /**
     * 设置动画 结束位置 并启动动画
     * @param v
     * @param startLocation
     */
    public void setAnim(final View v, int[] startLocation)
    {
        shopCarAnimation.setAnim(v,startLocation);
    }
}

