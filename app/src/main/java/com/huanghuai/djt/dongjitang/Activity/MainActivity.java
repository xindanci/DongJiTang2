package com.huanghuai.djt.dongjitang.Activity;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;

import com.huanghuai.djt.dongjitang.Fragment.BaseFragment;
import com.huanghuai.djt.dongjitang.Fragment.ClassificationFragment;
import com.huanghuai.djt.dongjitang.Fragment.DiagnosisFragment;
import com.huanghuai.djt.dongjitang.Fragment.HomeFragment;
import com.huanghuai.djt.dongjitang.Fragment.OnlineFragment;
import com.huanghuai.djt.dongjitang.Fragment.PersonalFragment;
import com.huanghuai.djt.dongjitang.Fragment.ShopCarFragment;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView home, online, personal, diagnosis, classification, shopcar;
    private BaseFragment homeFragment, diagnosisFragment, onlineFragment, personalFragment,classificationFragment,shopcarFragment;
    private boolean isMoveD = false;

    /**
     * 处理页面跳转
     */
    @Override
    protected void activityGetActivity() {
        Intent intent = getIntent();

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        home = (ImageView) findViewById(R.id.iv_home);
        online = (ImageView) findViewById(R.id.iv_online);
        personal = (ImageView) findViewById(R.id.iv_personal);
        diagnosis = (ImageView) findViewById(R.id.iv_diagnosis);
        classification = (ImageView) findViewById(R.id.iv_classification);
        shopcar = (ImageView) findViewById(R.id.iv_shopcar);

    }

    @Override
    protected void initDate() {
        setDefaultFragment();
    }

    /**
     * 设置默认的 fragment
     */
    private void setDefaultFragment() {
        homeFragment = new HomeFragment(mcontext);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
    }
    @Override
    protected void initLitener() {
        home.setOnClickListener(this);
        online.setOnClickListener(this);
        personal.setOnClickListener(this);
        diagnosis.setOnClickListener(this);
        classification.setOnClickListener(this);
        shopcar.setOnClickListener(this);
    }
    @Override
    protected void delHandler(Message msg) {
    }
    @Override
    protected void addActivity() {
        activities.add(this);
    }

    /**
     * 按钮点击
     * @param view
     */
    @Override
    public void onClick(View view) {
        FragmentTransaction mtransaction = getSupportFragmentManager().beginTransaction();
        changeFragment(view, mtransaction);
    }
    //切换fragment
    private void changeFragment(View view, FragmentTransaction mtransaction) {
        hideFragments(mtransaction);
        switch (view.getId()) {
            case R.id.iv_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment(mcontext);
                    mtransaction.add(R.id.fragment_container, homeFragment);
                } else {
                    mtransaction.show(homeFragment);
                }
                //设置 点击时的状态
                changeImage(0);
                home.setSelected(true);
                break;
            case R.id.iv_diagnosis:
                ToastUtils.showInfo(mcontext, "医师诊治");
                if (diagnosisFragment == null) {
                    diagnosisFragment = new DiagnosisFragment(mcontext);
                    mtransaction.add(R.id.fragment_container, diagnosisFragment);
                } else {
                    Log.e("wo", "我被调用了");
                    mtransaction.show(diagnosisFragment);
                }
                changeImage(1);
                break;
            case R.id.iv_online:
                if (onlineFragment == null) {
                    onlineFragment = new OnlineFragment(mcontext);
                    mtransaction.add(R.id.fragment_container, onlineFragment);
                } else {
                    mtransaction.show(onlineFragment);
                }
                if (!isMoveD) {
                    isMoveD = true;
                } else {
                    isMoveD = false;
                }
                changeImage(2);
                break;
            case R.id.iv_personal:
                ToastUtils.showInfo(mcontext, "个人中心");
                if (personalFragment == null) {
                    personalFragment = new PersonalFragment(mcontext);
                    mtransaction.add(R.id.fragment_container, personalFragment);
                } else {
                    mtransaction.show(personalFragment);
                }
                changeImage(3);
                break;
            case R.id.iv_classification:
                ToastUtils.showInfo(mcontext,"分类");
                if (classificationFragment == null) {
                    classificationFragment = new ClassificationFragment(mcontext);
                    mtransaction.add(R.id.fragment_container, classificationFragment);
                } else {
                    mtransaction.show(classificationFragment);
                }
                changeImage(4);
                break;
            case R.id.iv_shopcar:
                ToastUtils.showInfo(mcontext,"购物车");
                if (shopcarFragment == null) {
                    shopcarFragment = new ShopCarFragment(mcontext);
                    mtransaction.add(R.id.fragment_container, shopcarFragment);
                } else {
                    mtransaction.show(shopcarFragment);
                }
                changeImage(5);
                break;
            default:
                break;
        }
        mtransaction.commit();//一定要记得提交事务
    }

    /**
     * 选择图片
     * @param i
     */
    private void changeImage(int i) {
        home.setSelected(false);
        diagnosis.setSelected(false);
        online.setSelected(false);
        personal.setSelected(false);
        classification.setSelected(false);
        shopcar.setSelected(false);
        switch (i) {
            case 0:
                home.setSelected(true);
                break;
            case 1:
                diagnosis.setSelected(true);
                break;
            case 2:
                online.setSelected(true);

                if (isMoveD) {
                    moveSlideBtn(1);
                } else {
                    moveSlideBtn(0);
                }

                break;
            case 3:
                personal.setSelected(true);
                if (isMoveD) {
                    moveSlideBtn(0);
                    isMoveD = false;
                }
                break;
            case 4:
                classification.setSelected(true);
                break;
            case 5:
                shopcar.setSelected(true);
                break;
            default:
                break;
        }
    }

    /**
     * 隐藏所有的 分类
     * @param mtransaction
     */
    private void hideFragments(FragmentTransaction mtransaction) {
        if (homeFragment != null)//不为空才隐藏,如果不判断第一次会有空指针异常
            mtransaction.hide(homeFragment);
        if (diagnosisFragment != null)
            mtransaction.hide(diagnosisFragment);
        if (onlineFragment != null)

            mtransaction.hide(onlineFragment);
        if (personalFragment != null)
            mtransaction.hide(personalFragment);
        if (shopcarFragment!=null) {
            mtransaction.hide(shopcarFragment);
        }
        if (classificationFragment!=null)
        {
            mtransaction.hide(classificationFragment);
        }
    }

    /**
     *
     * @param targetPosition
     * 购物车和 分类的显示
     */
    public void moveSlideBtn(int targetPosition) {
        if (targetPosition == 0) {
            //滑动回来
            home.setVisibility(View.VISIBLE);
            diagnosis.setVisibility(View.VISIBLE);
            shopcar.setVisibility(View.GONE);
            classification.setVisibility(View.GONE);
        } else {
            //滑动走
            home.setVisibility(View.GONE);
            diagnosis.setVisibility(View.GONE);
            classification.setVisibility(View.VISIBLE);
            shopcar.setVisibility(View.VISIBLE);
        }
    }
}
