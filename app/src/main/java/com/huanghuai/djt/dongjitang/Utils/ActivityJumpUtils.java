package com.huanghuai.djt.dongjitang.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ActivityJumpUtils {
    public static void JumpIntentActivity(Context context, Class<? extends Activity> classz)
    {
        Intent intent =new Intent();
        intent.setClass(context,classz);
        context.startActivity(intent);
    }
}
