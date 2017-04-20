package com.huanghuai.djt.dongjitang.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.JudgeApp;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

/**
 * Created by Administrator on 2017/4/13.
 */

public class MapnavigationActivity extends BaseActivity implements View.OnClickListener{
    private JudgeApp judgeApp;
    private LinearLayout mjudgeApp;
    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_mapnavigation;
    }

    @Override
    protected void initView() {
        mjudgeApp= (LinearLayout) findViewById(R.id.judge_app);
    }

    @Override
    protected void initDate() {
        judgeApp=new JudgeApp();
    }

    @Override
    protected void initLitener() {
        mjudgeApp.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }

    @Override
    public void onClick(View view) {

        showShareDialog();
    }

    private void showShareDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.map_diaglog_them, null);
        // 设置style 控制默认dialog带来的边距问题
        final Dialog dialog = new Dialog(this, R.style.common_dialog);
        dialog.setContentView(view);
        dialog.show();
        // 监听
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.map_gaode:
                        if (!judgeApp.isAvilible(MapnavigationActivity.this,"com.autonavi.minimap")) {
                            ToastUtils.showInfo(MapnavigationActivity.this,"小郎中温馨提示：高德地图，应用未安装。请前往应用市场下载高德地图APP");
                        }
                        else {
                            judgeApp.jumpGaodeMap(MapnavigationActivity.this,"34.7566330000","113.7440560000");
                        }
                        break;
                    case R.id.map_baidu:
                        if (!judgeApp.isAvilible(MapnavigationActivity.this,"com.baidu.BaiduMap")) {
                            ToastUtils.showInfo(MapnavigationActivity.this,"小郎中温馨提示：百度地图，应用未安装。请前往应用市场下载百度地图APP");
                        }
                        else {
                            judgeApp.jumpBaiduMap(MapnavigationActivity.this);
                        }
                        break;
                    default:
                        break;
                }
                dialog.dismiss();
            }
        };
        ImageView mapBaidu = (ImageView) view.findViewById(R.id.map_baidu);
        ImageView mapGaode = (ImageView) view.findViewById(R.id.map_gaode);
        mapBaidu.setOnClickListener(listener);
        mapGaode.setOnClickListener(listener);
    }

}
