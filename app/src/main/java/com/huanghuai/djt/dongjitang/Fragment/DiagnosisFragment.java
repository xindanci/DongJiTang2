package com.huanghuai.djt.dongjitang.Fragment;


import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.huanghuai.djt.dongjitang.Activity.BaseActivity;
import com.huanghuai.djt.dongjitang.R;

/**
 * Created by Administrator on 2017/4/10.
 */
public class DiagnosisFragment extends BaseFragment implements View.OnClickListener{
    public DiagnosisFragment(Context context) {
        this.mcontext = context;
    }


    @Override
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_hysician_diagnosis, null);
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
            mcontext = view.getContext();
    }
    @Override
    public void onClick(View v) {

    }
}

