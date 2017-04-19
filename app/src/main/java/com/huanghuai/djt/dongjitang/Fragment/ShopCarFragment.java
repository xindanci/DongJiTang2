package com.huanghuai.djt.dongjitang.Fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huanghuai.djt.dongjitang.Adpter.Online_Shop_Car_RecycleView_Adapter;
import com.huanghuai.djt.dongjitang.Bean.Product_Goods;
import com.huanghuai.djt.dongjitang.CustomUI.RecycleViewDivider;
import com.huanghuai.djt.dongjitang.Net.OnlineFragmentNet;
import com.huanghuai.djt.dongjitang.Net.ShopCarFragmentNet;
import com.huanghuai.djt.dongjitang.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ShopCarFragment extends BaseFragment{

    //商品信息
    private ArrayList<Product_Goods> list_product_goods=new ArrayList<>();
    private RecyclerView online_shop_goods__checkout_recycleview;
    private ShopCarFragmentNet shopCarFragmentNet;
    //adapter
    Online_Shop_Car_RecycleView_Adapter online_shop_car_recycleView_adapter;
    public ShopCarFragment(Context context)
    {
        this.mcontext=context;
    }

    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_shopcar_page,null);
        online_shop_goods__checkout_recycleview= (RecyclerView) view.findViewById(R.id.online_shop_goods__checkout_recycleview);
        online_shop_goods__checkout_recycleview.setLayoutManager(new LinearLayoutManager(mcontext));
        online_shop_goods__checkout_recycleview.setHasFixedSize(true);
        online_shop_goods__checkout_recycleview.addItemDecoration(new RecycleViewDivider(mcontext, 2));

        return view;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initListener() {
    }
    @Override
    protected void initDate() {
        if (shopCarFragmentNet == null) {
            //当前的页面的 联网工具
            shopCarFragmentNet = new ShopCarFragmentNet();
        }
        list_product_goods= shopCarFragmentNet.getListProductInfo();
        online_shop_car_recycleView_adapter=new Online_Shop_Car_RecycleView_Adapter(mcontext,list_product_goods,this);
        online_shop_goods__checkout_recycleview.setAdapter(online_shop_car_recycleView_adapter);
    }
    @Override
    public void getmContext() {
        mcontext=view.getContext();
    }
}
