package com.huanghuai.djt.dongjitang.Fragment;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/4/10.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mcontext;
    protected View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getResourceView(inflater,container);
    }

    @Override
    public void onStart() {
        super.onStart();
        getmContext();
        initView();
        initListener();
        initDate();
    }
    protected abstract View getResourceView(LayoutInflater inflater, ViewGroup container);
    protected abstract void  initView();

    protected abstract void  initListener();

    protected abstract void  initDate();
    protected static BaseFragment getChildFragment(BaseFragment fragment)
    {
        //
       // Log.e("nihao1",fragment.getTag());
        return null;
    }



    public abstract void getmContext() ;
}
