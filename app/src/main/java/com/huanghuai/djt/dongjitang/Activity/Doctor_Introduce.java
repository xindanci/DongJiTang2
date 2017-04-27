package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huanghuai.djt.dongjitang.R;

public class Doctor_Introduce extends BaseActivity implements View.OnClickListener{
    private Button orderRegister;

    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_doctor__introduce;
    }

    @Override
    protected void initView() {
        orderRegister=(Button)findViewById(R.id.order_register_1);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initLitener() {
        orderRegister.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(mcontext,OrderRegister.class);
        startActivity(intent);
    }
}
