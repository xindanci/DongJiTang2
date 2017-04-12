package com.huanghuai.djt.dongjitang.Activity;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huanghuai.djt.dongjitang.Fragment.BaseFragment;
import com.huanghuai.djt.dongjitang.Fragment.DiagnosisFragment;
import com.huanghuai.djt.dongjitang.Fragment.HomeFragment;
import com.huanghuai.djt.dongjitang.Fragment.OnlineFragment;
import com.huanghuai.djt.dongjitang.Fragment.PersonalFragment;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private TextView home,online,personal,diagnosis;
    private FrameLayout fragment_container;
    private BaseFragment homeFragment,diagnosisFragment,onlineFragment,personalFragment;
    private FragmentManager fragmentManager;

    //用于处理 页面跳转数据
    @Override
    protected void activityGetActivity() {
        Intent intent=getIntent();

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fragment_container= (FrameLayout) findViewById(R.id.fragment_container);
        home= (TextView) findViewById(R.id.tv_home);
        online= (TextView) findViewById(R.id.tv_online);
        personal= (TextView) findViewById(R.id.tv_personal);
        diagnosis= (TextView) findViewById(R.id.tv_diagnosis);
    }

    @Override
    protected void initDate() {
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        homeFragment=new HomeFragment(mcontext);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment).commit();
    }

    @Override
    protected void initLitener() {
        home.setOnClickListener(this);
        online.setOnClickListener(this);
        personal.setOnClickListener(this);
        diagnosis.setOnClickListener(this);
    }
    @Override
    protected void delHandler(Message msg) {

    }
    @Override
    protected void addActivity() {
        activities.add(this);
    }
    //按钮点击事件
    @Override
    public void onClick(View view) {
        FragmentTransaction mtransaction = getSupportFragmentManager().beginTransaction();

        changeFragment(view,mtransaction);

    }
    //切换fragment
    private void changeFragment(View view,FragmentTransaction mtransaction )
    {
        hideFragments(mtransaction);
        switch (view.getId())
        {
            case R.id.tv_home:
                if (homeFragment==null)
                {
                    homeFragment=new HomeFragment(mcontext);
                    mtransaction.add(R.id.fragment_container,homeFragment);
                }
                else
                {
                    mtransaction.show(homeFragment);
                }
                break;
            case R.id.tv_diagnosis:
                ToastUtils.showInfo(mcontext,"医师诊治");
                if (diagnosisFragment==null)
                {
                    diagnosisFragment=new DiagnosisFragment(mcontext);
                    mtransaction.add(R.id.fragment_container,diagnosisFragment);
                }
                else
                {
                    Log.e("wo","我被调用了");
                    mtransaction.show(diagnosisFragment);
                }
                break;
            case R.id.tv_online:
                ToastUtils.showInfo(mcontext,"在线商城");

                if (onlineFragment==null)
                {
                    onlineFragment=new OnlineFragment(mcontext);
                    mtransaction.add(R.id.fragment_container,onlineFragment);
                }
                else
                {
                    mtransaction.show(onlineFragment);
                }
                break;
            case R.id.tv_personal:
                ToastUtils.showInfo(mcontext,"个人中心");
                if (personalFragment==null)
                {
                    personalFragment=new PersonalFragment(mcontext);
                    mtransaction.add(R.id.fragment_container,personalFragment);
                }
                else
                {
                    mtransaction.show(personalFragment);
                }
                break;
            default:
                break;
        }
        mtransaction.commit();//一定要记得提交事务
    }
    //隐藏 所有的 fragment
    private void hideFragments(FragmentTransaction mtransaction){
        if (homeFragment != null)//不为空才隐藏,如果不判断第一次会有空指针异常

            mtransaction.hide(homeFragment);
        if (diagnosisFragment != null)
//            Log.e("wo","我被调用了");

            mtransaction.hide(diagnosisFragment);
        if (onlineFragment != null)

            mtransaction.hide(onlineFragment);
        if (personalFragment != null)

            mtransaction.hide(personalFragment);

    }

}
