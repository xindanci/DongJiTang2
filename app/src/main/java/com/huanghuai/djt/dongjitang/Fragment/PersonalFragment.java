package com.huanghuai.djt.dongjitang.Fragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huanghuai.djt.dongjitang.R;

/**
 * Created by Administrator on 2017/4/10.
 */
public class PersonalFragment extends BaseFragment{
    private Context mcontext;
    public PersonalFragment(Context context){
        this.mcontext=context;
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
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_personal_center, container,false);
    }
}
