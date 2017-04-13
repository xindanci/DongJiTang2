package com.huanghuai.djt.dongjitang.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huanghuai.djt.dongjitang.R;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ShopCarFragment extends BaseFragment{

    public ShopCarFragment(Context context)
    {
        this.mcontext=context;
    }

    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_shopcar_page,null);
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

    }

    @Override
    public void getmContext() {
        mcontext=view.getContext();
    }
}
