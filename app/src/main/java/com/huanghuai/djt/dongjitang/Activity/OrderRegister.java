package com.huanghuai.djt.dongjitang.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.Adpter.MyDateAdapter;
import com.huanghuai.djt.dongjitang.Bean.MyDate;
import com.huanghuai.djt.dongjitang.R;

import java.util.ArrayList;
import java.util.List;

public class OrderRegister extends BaseActivity implements View.OnClickListener{
    private List<MyDate> myDateList=new ArrayList<>();
    private Button popWindows;
    private TextView serviceProtocol;
    private CheckBox isAgree;
    private Button addPersion;
    Activity activity=OrderRegister.this;

    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_order_register;
    }

    @Override
    protected void initView() {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        MyDateAdapter adapter=new MyDateAdapter(myDateList);
        recyclerView.setAdapter(adapter);
        popWindows=(Button)findViewById(R.id.pop_windows);
        serviceProtocol=(TextView)findViewById(R.id.service_protocol);
        isAgree=(CheckBox)findViewById(R.id.check_is_agree);
        addPersion=(Button)findViewById(R.id.add_persion_bt);

    }

    @Override
    protected void initDate() {
        MyDate myDate1=new MyDate("专家20元","4月6日","周一");
        MyDate myDate2=new MyDate("专家20元","4月7日","周二");
        MyDate myDate3=new MyDate("专家20元","4月8日","周三");
        MyDate myDate4=new MyDate("专家20元","4月9日","周四");
        MyDate myDate5=new MyDate("专家20元","4月10日","周五");
        MyDate myDate6=new MyDate("专家20元","4月11日","周六");
        MyDate myDate7=new MyDate("专家20元","4月12日","周日");
        myDateList.add(myDate1);
        myDateList.add(myDate2);
        myDateList.add(myDate3);
        myDateList.add(myDate4);
        myDateList.add(myDate5);
        myDateList.add(myDate6);
        myDateList.add(myDate7);
    }

    @Override
    protected void initLitener() {
        serviceProtocol.setOnClickListener(this);
        popWindows.setOnClickListener(this);
        popWindows.setEnabled(false);
        isAgree.setOnClickListener(this);
        isAgree.setChecked(false);
        addPersion.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.service_protocol:
                while (activity.getParent()!=null){
                    activity=activity.getParent();
                }
                new AlertDialog.Builder(activity).setTitle("东济堂小郎中预约挂号、取号须知")
                        .setCancelable(false)
                        .setMessage("一、预约挂号范围：1.可预约一周以内的医生号源（含当天），支持24小时服务（注：春节七天等法定假日除外）。2.黄甡大夫，李郑生大夫，臧云彩大夫，李昱金大夫必须提前一天预约。" +
                                "二、预约实名制：微信预约挂号均采取实名制预约，请您如实提供就诊人员的真实姓名、手机号码等基本信息。" +
                                "三、预约取号：1、预约成功后，请患者于就诊当日到挂号收费窗口取号，取号时首先核对与预约登记实名信息一致的本人有效证件和预约识别码，如验证不符将不能取号。2、预约取号时间：上午就诊患者于就诊当日10:30以前取号；下午就诊患者于就诊当日15:30以前取号。过时未取号者，预约作废。" +
                                "四、医生停诊：如遇特殊情况医生停诊，给您造成的不便敬请谅解。医生临时停诊，东济堂工作人员将会用电话或短信方式及时通知您，请配合更改就诊日期或更换其他医生或退费处理，请您保持电话畅通。" +
                                "五、爽约处理：如预约成功后患者未能按时就诊视为爽约。挂号费用恕不退还")
                        .setPositiveButton("我已阅读",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).show();
                break;
            case R.id.pop_windows:
                Intent intent1=new Intent();
                intent1.setClass(mcontext,Order_Payment.class);
                startActivity(intent1);
                break;
            case R.id.check_is_agree:
                popWindows.setBackgroundResource(R.mipmap.immediate_order);
                popWindows.setEnabled(true);
                break;
            case R.id.add_persion_bt:
                Intent intent=new Intent();
                intent.setClass(mcontext,AddPersion.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
