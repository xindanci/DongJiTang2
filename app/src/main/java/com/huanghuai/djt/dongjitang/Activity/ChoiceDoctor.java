package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.GridView;


import com.huanghuai.djt.dongjitang.Adpter.DoctorAdapter;
import com.huanghuai.djt.dongjitang.Bean.Doctor;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;


public class ChoiceDoctor extends BaseActivity implements View.OnClickListener {

    private List<Doctor> doctorList=new ArrayList<>();
    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {
        Intent intent=getIntent();
        String str1=intent.getStringExtra("1");
        String str2=intent.getStringExtra("2");
        String str3=intent.getStringExtra("3");
        String str4=intent.getStringExtra("4");
        String str5=intent.getStringExtra("5");
        String str6=intent.getStringExtra("6");
        String str7=intent.getStringExtra("7");
        String str8=intent.getStringExtra("8");
        String str9=intent.getStringExtra("9");
        String str10=intent.getStringExtra("10");
        String str11=intent.getStringExtra("11");
        String str12=intent.getStringExtra("12");
        if(str1!=null){
            ToastUtils.showInfo(mcontext,str1);
        }else if(str2!=null){
            ToastUtils.showInfo(mcontext,str2);
        }
        else if(str3!=null){
            ToastUtils.showInfo(mcontext,str3);
        }
        else if(str4!=null){
            ToastUtils.showInfo(mcontext,str4);
        }
        else if(str5!=null){
            ToastUtils.showInfo(mcontext,str5);
        }
        else if(str6!=null){
            ToastUtils.showInfo(mcontext,str6);
        }
        else if(str7!=null){
            ToastUtils.showInfo(mcontext,str7);
        }
        else if(str8!=null){
            ToastUtils.showInfo(mcontext,str8);
        }
        else if(str9!=null){
            ToastUtils.showInfo(mcontext,str9);
        }
        else if(str10!=null){
            ToastUtils.showInfo(mcontext,str10);
        }
        else if(str11!=null){
            ToastUtils.showInfo(mcontext,str11);
        }
        else if(str12!=null){
            ToastUtils.showInfo(mcontext,str12);
        }

    }

    @Override
    public int getContentView() {
            return R.layout.activity_choice_doctor;
    }

    @Override
    protected void initView() {
        DoctorAdapter adapter=new DoctorAdapter(ChoiceDoctor.this,R.layout.product_doctor,doctorList);
        GridView gridView=(GridView)findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void initDate() {
        Doctor doctor1=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor2=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor3=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor4=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor5=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor6=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor7=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor8=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor9=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor10=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor11=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        Doctor doctor12=new Doctor("预约（剩余8张)",R.mipmap.doctor_number1);
        doctorList.add(doctor1);
        doctorList.add(doctor2);
        doctorList.add(doctor3);
        doctorList.add(doctor4);
        doctorList.add(doctor5);
        doctorList.add(doctor6);
        doctorList.add(doctor7);
        doctorList.add(doctor8);
        doctorList.add(doctor9);
        doctorList.add(doctor10);
        doctorList.add(doctor11);
        doctorList.add(doctor12);


    }

    @Override
    protected void initLitener() {

    }

    @Override
    protected void delHandler(Message msg) {

    }
    @Override
    public void onClick(View v) {

    }
}
