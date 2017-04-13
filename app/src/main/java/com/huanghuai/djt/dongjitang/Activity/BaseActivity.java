package com.huanghuai.djt.dongjitang.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.huanghuai.djt.dongjitang.Utils.SPUtils;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/4/10.
 */
public abstract class BaseActivity extends FragmentActivity {
    //全局上下文
    protected Context mcontext;
    protected boolean firstart;
    protected static ArrayList<Activity> activities=new ArrayList<>();

    //私有化数据 提供接口
   protected Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            delHandler(msg);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        activityGetActivity();
        mcontext= getApplicationContext();
        firstart=isFirstart();
        initView();
        initLitener();
        initDate();
        addActivity();

    }

    //把当前 activity添加到集合中去
    protected abstract void addActivity();
    //页面跳转的时候需要使用
    protected abstract void activityGetActivity();

    protected Handler getHandler()
    {
        return handler;
    }
    //初始化要要显示的UI
    public abstract int getContentView() ;
    //初始化ui
    protected abstract void initView() ;
    //初始化数据
    protected abstract void initDate() ;
    //初始化监听
    protected abstract void initLitener() ;
    //初始化Handler的业务处理
    protected abstract void delHandler(Message msg);

    //获取是否是第一次启动
    private boolean isFirstart()
    {
        boolean firstart= (boolean) SPUtils.get(mcontext,"firstart",true);
        Log.e("sda","dsaadsada");
        return firstart;
    }
    //销毁当前页面
    protected static void removeActivity(Activity activity)
    {
        activities.remove(activity);
    }
    //销毁所有界面
    protected static void removeAll()
    {
        for(Activity activity:activities)
        {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }


}
