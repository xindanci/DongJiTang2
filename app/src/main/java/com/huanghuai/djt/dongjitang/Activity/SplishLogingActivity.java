package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;

import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.AnimationUtils;
import com.huanghuai.djt.dongjitang.Utils.ConstantUtil;
import com.huanghuai.djt.dongjitang.Utils.SPUtils;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;


/**
 * Created by Administrator on 2017/4/10.
 */
public class SplishLogingActivity extends BaseActivity {
    private ImageView splish_iv;
    private Animation.AnimationListener animationListener;
    private AlphaAnimation alphaAnimation;



    //初始化界面 布局文件
    @Override
    public int getContentView() {
        return R.layout.activity_splish_loging;
    }

    @Override
    protected void initView() {
        splish_iv = (ImageView) findViewById(R.id.sp_iv);
    }

    @Override
    protected void initDate() {
        alphaAnimation=AnimationUtils.getHiddenAlphaAnimation(ConstantUtil.ALAPHAANIMATION_DURITION,animationListener);
        //延时Loging的显示
        handler.sendEmptyMessageDelayed(ConstantUtil.HANDLER_SPLISH_LOGING,2000);
    }

    @Override
    protected void initLitener() {
        setAnimationListener();
    }
    //设置 动画监听器并开始执行Login图片动画
    private void setAnimationListener()
    {
        animationListener=new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (firstart)
                {
                    startSplish();
                    SPUtils.put(mcontext,"firstart",false);
                }
                else {
                    startMainActivity();
                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

    }
    /**
     跳转到主界面
     */
    private void startMainActivity() {
        Intent intent=new Intent();
        intent.setClass(SplishLogingActivity.this,MainActivity.class);
        SplishLogingActivity.this.startActivity(intent);
        finish();

    }

    /**
     * 开始执行闪屏操作
     */

    private void startSplish() {
        Intent intent=new Intent();
        intent.setClass(SplishLogingActivity.this,SplishActivity.class);
        SplishLogingActivity.this.startActivity(intent);
        finish();
    }

    /**
     * 处理Handler
     */

    @Override
    protected void delHandler(Message msg) {
        if (msg.what == ConstantUtil.HANDLER_SPLISH_LOGING) {
            //开始执行动画
            splish_iv.startAnimation(alphaAnimation);

        }
    }

    @Override
    protected void addActivity() {
        activities.add(this);
    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
