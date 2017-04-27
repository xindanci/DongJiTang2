package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.huanghuai.djt.dongjitang.R;

public class Order_Payment extends BaseActivity implements View.OnClickListener {
    private Button immediatePayment;


    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_order__payment;
    }

    @Override
    protected void initView() {
        immediatePayment=(Button)findViewById(R.id.immediate_payment);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initLitener() {
        immediatePayment.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }
    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(mcontext,OrderInformation.class);
        startActivity(intent);
    }
}
