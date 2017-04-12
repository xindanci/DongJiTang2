package com.huanghuai.djt.dongjitang.Utils;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ToastUtils {
    private static Toast toast;
    public static void showInfo(Context context,String str)
    {
        //判断队列中是否包含已经显示的Toast
        if (toast == null) {
            toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        }else{
            toast.setText(str);
        }
        toast.show();
    }


}
