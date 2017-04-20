package com.huanghuai.djt.dongjitang.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import com.huanghuai.djt.dongjitang.Activity.MapnavigationActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */

public class JudgeApp {

    /**
     * 判断 手机上 是否 安装了 某个应用
     * @param context
     * @param packageName
     * @return
     */
    public  boolean isAvilible(Context context, String packageName){
        //获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        //从pinfo中将包名字逐一取出，压入pName list中
        if(packageInfos != null){
            for(int i = 0; i < packageInfos.size(); i++){
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }
    //跳转到高德地图
    public static  void jumpGaodeMap(Context context , String lat , String lon ){
        Intent intent = new Intent("android.intent.action.VIEW",android.net.Uri.parse("androidamap://navi?sourceApplication=快方配送&lat="+lat+"&lon="+lon+"&dev=0"));
        intent.setPackage("com.autonavi.minimap");
        context.startActivity(intent);

    }
    //跳转百度地图
    public void jumpBaiduMap(Context context)
    {
        Intent i1 = new Intent();
        i1.setData(Uri.parse("baidumap://map/geocoder?src=openApiDemo&address=河南省郑州市东济堂中医馆"));
        context.startActivity(i1);
    }
}
