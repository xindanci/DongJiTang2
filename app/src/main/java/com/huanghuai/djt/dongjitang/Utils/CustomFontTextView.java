package com.huanghuai.djt.dongjitang.Utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class CustomFontTextView extends TextView {
    public CustomFontTextView(Context context){
        super(context);
        init(context);
    }
    public CustomFontTextView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context);
    }
    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        init(context);
    }
    private void init(Context context){
        AssetManager assetMgr=context.getAssets();
        Typeface font=Typeface.createFromAsset(assetMgr,"txbdxkf.ttf");
        setTypeface(font);
        setEnabled(false);
    }
}
