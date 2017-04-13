package com.huanghuai.djt.dongjitang.Fragment;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.huanghuai.djt.dongjitang.Activity.NewsActivity;
import com.huanghuai.djt.dongjitang.Activity.SearchActivity;
import com.huanghuai.djt.dongjitang.Activity.SearchConsultation;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ActivityJumpUtils;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

/**
 * Created by Administrator on 2017/4/10.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private ImageView ic_iv_search,iv_home_bell;
    private LinearLayout search_doctor,search_consultation;

    public HomeFragment(Context context){
        this.mcontext=context;
    }
    @Override
    protected void initView() {
       ic_iv_search= (ImageView) view.findViewById(R.id.ic_iv_search);
        iv_home_bell= (ImageView) view.findViewById(R.id.ic_home_bell);
        search_consultation= (LinearLayout) view.findViewById(R.id.search_consultation);
        search_doctor= (LinearLayout) view.findViewById(R.id.search_doctor);
    }
    @Override
    protected void initListener() {
        ic_iv_search.setOnClickListener(this);
        iv_home_bell.setOnClickListener(this);
        search_consultation.setOnClickListener(this);
        search_doctor.setOnClickListener(this);
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void getmContext() {
        mcontext=view.getContext();
    }

    @Override
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
       view = getActivity().getLayoutInflater().inflate(R.layout.fragment_home_page,null);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ic_iv_search:
                ToastUtils.showInfo(mcontext,"我是搜索");
                ActivityJumpUtils.JumpIntentActivity(mcontext,SearchActivity.class);
                break;
            case R.id.ic_home_bell:
                ToastUtils.showInfo(mcontext,"我是消息");
                ActivityJumpUtils.JumpIntentActivity(mcontext,NewsActivity.class);
                break;
            case R.id.search_consultation:
                ToastUtils.showInfo(mcontext,"我是咨询");
                ActivityJumpUtils.JumpIntentActivity(mcontext, SearchConsultation.class);
                break;
            case R.id.search_doctor:
                ToastUtils.showInfo(mcontext,"我是找医生");
                ActivityJumpUtils.JumpIntentActivity(mcontext,SearchActivity.class);
                break;
            default:
                break;
        }
    }
}
