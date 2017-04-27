package com.huanghuai.djt.dongjitang.Activity;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.huanghuai.djt.dongjitang.R;

import java.util.ArrayList;
import java.util.List;

public class AddPersion extends BaseActivity implements View.OnClickListener {
//    private Spinner spinnerProvince;
//    private Spinner spinnerDowntown;
//    private Spinner spinnerCounty;
//    private List<String> provinceList;
//    private List<String> downtownList;
//    private List<String> countyList;
//    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_add_persion;
    }

    @Override
    protected void initView() {
//        spinnerProvince=(Spinner)findViewById(R.id.spinner_province);
//        spinnerDowntown=(Spinner)findViewById(R.id.spinner_downtown);
//        spinnerCounty=(Spinner)findViewById(R.id.spinner_county);
    }

    @Override
    protected void initDate() {
//        provinceList=new ArrayList<>();
//        provinceList.add("河南");
//        provinceList.add("河南");
//        downtownList=new ArrayList<>();
//        downtownList.add("郑州");
//        downtownList.add("许昌");
//        downtownList.add("平顶山");
//        countyList=new ArrayList<>();
    }

    @Override
    protected void initLitener() {
//        spinnerProvince.setOnClickListener(this);
//        spinnerDowntown.setOnClickListener(this);
//        spinnerCounty.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }
    @Override
    public void onClick(View v) {

    }
}

