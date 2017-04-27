package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener{
    String strBtnSelected = "unInit";
    private Button nextstep;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button tempbutton=button1;
    private RadioGroup grp1;
    private RadioGroup grp2;
    private RadioGroup grp3;
    private RadioGroup grp4;




    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        button1=(RadioButton)findViewById(R.id.button1);
        button2=(RadioButton)findViewById(R.id.button2);
        button3=(RadioButton)findViewById(R.id.button3);
        button4=(RadioButton)findViewById(R.id.button4);
        button5=(RadioButton)findViewById(R.id.button5);
        button6=(RadioButton)findViewById(R.id.button6);
        button7=(RadioButton)findViewById(R.id.button7);
        button8=(RadioButton)findViewById(R.id.button8);
        button9=(RadioButton)findViewById(R.id.button9);
        button10=(RadioButton)findViewById(R.id.button10);
        button11=(RadioButton)findViewById(R.id.button11);
        button12=(RadioButton)findViewById(R.id.button12);
        grp1 = (RadioGroup) findViewById(R.id.group1);
        grp2 = (RadioGroup) findViewById(R.id.group2);
        grp3 = (RadioGroup) findViewById(R.id.group3);
        grp4 = (RadioGroup) findViewById(R.id.group4);
        nextstep=(Button)findViewById(R.id.nest_step);

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initLitener() {
        button1.setOnClickListener(btnListener1);
        button2.setOnClickListener(btnListener2);
        button3.setOnClickListener(btnListener3);
        button4.setOnClickListener(btnListener4);
        button5.setOnClickListener(btnListener5);
        button6.setOnClickListener(btnListener6);
        button7.setOnClickListener(btnListener7);
        button8.setOnClickListener(btnListener8);
        button9.setOnClickListener(btnListener9);
        button10.setOnClickListener(btnListener10);
        button11.setOnClickListener(btnListener11);
        button12.setOnClickListener(btnListener12);
        nextstep.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }
    public class BtnSelected implements View.OnClickListener {
        public BtnSelected(String str) {
            bntID = str;
        }

        final public String bntID;

        @Override
        public void onClick(View arg0) {
            strBtnSelected = bntID;
            if (bntID.equals("1") || bntID.equals("2") || bntID.equals("3")) {
                if (bntID=="1"){
                    String text1=button1.getText().toString();
                    ToastUtils.showInfo(mcontext,text1);
                    tempbutton=button1;
                ToastUtils.showInfo(mcontext,text1);
                }else if(bntID=="2"){
                    String text2=button2.getText().toString();
                ToastUtils.showInfo(mcontext,text2);
                    tempbutton=button2;
                }else if(bntID=="3"){
                    String text3=button3.getText().toString();
                ToastUtils.showInfo(mcontext,text3);
                    tempbutton=button3;
                }
                grp2.clearCheck();
                grp3.clearCheck();
                grp4.clearCheck();
            } else if (bntID.equals("4") || bntID.equals("5") || bntID.equals("6")) {
                if (bntID=="4"){
                    String text4=button4.getText().toString();
                    ToastUtils.showInfo(mcontext,text4);
                    tempbutton=button4;
                }else if(bntID=="5"){
                    String text5=button5.getText().toString();
                    ToastUtils.showInfo(mcontext,text5);
                    tempbutton=button5;
                }else if(bntID=="6"){
                    String text6=button6.getText().toString();
                    ToastUtils.showInfo(mcontext,text6);
                    tempbutton=button6;
                }
                grp1.clearCheck();
                grp3.clearCheck();
                grp4.clearCheck();
            }else if (bntID.equals("7") || bntID.equals("8") || bntID.equals("9")) {
                if (bntID=="7"){
                    String text7=button7.getText().toString();
                    ToastUtils.showInfo(mcontext,text7);
                    tempbutton=button7;
                }else if(bntID=="8"){
                    String text8=button8.getText().toString();
                    ToastUtils.showInfo(mcontext,text8);
                    tempbutton=button8;
                }else if(bntID=="9"){
                    String text9=button9.getText().toString();
                    ToastUtils.showInfo(mcontext,text9);
                    tempbutton=button9;
                }
                grp1.clearCheck();
                grp2.clearCheck();
                grp4.clearCheck();
            }else if (bntID.equals("10") || bntID.equals("11") || bntID.equals("12")) {
                if (bntID=="10"){
                    String text10=button10.getText().toString();
                    ToastUtils.showInfo(mcontext,text10);
                    tempbutton=button10;
                }else if(bntID=="11"){
                    String text11=button11.getText().toString();
                    ToastUtils.showInfo(mcontext,text11);
                    tempbutton=button11;
                }else if(bntID=="12"){
                    String text12=button12.getText().toString();
                    ToastUtils.showInfo(mcontext,text12);
                    tempbutton=button12;
                }
                grp1.clearCheck();
                grp2.clearCheck();
                grp3.clearCheck();
            }
        }
    }

    BtnSelected btnListener1 = new BtnSelected("1");
    BtnSelected btnListener2 = new BtnSelected("2");
    BtnSelected btnListener3 = new BtnSelected("3");
    BtnSelected btnListener4 = new BtnSelected("4");
    BtnSelected btnListener5 = new BtnSelected("5");
    BtnSelected btnListener6 = new BtnSelected("6");
    BtnSelected btnListener7 = new BtnSelected("7");
    BtnSelected btnListener8 = new BtnSelected("8");
    BtnSelected btnListener9 = new BtnSelected("9");
    BtnSelected btnListener10 = new BtnSelected("10");
    BtnSelected btnListener11 = new BtnSelected("11");
    BtnSelected btnListener12 = new BtnSelected("12");
    public void nextChoice(){
        if(tempbutton.getText().toString().equals("儿童科")){
            String text1=button1.getText().toString();
            Intent intent1=new Intent();
            intent1.setClass(mcontext,ChoiceDoctor.class);
            intent1.putExtra("1",text1);
            startActivity(intent1);
        }else if(tempbutton.getText().toString().equals("女子科")){
            String text2=button2.getText().toString();
            Intent intent2=new Intent();
            intent2.setClass(mcontext,ChoiceDoctor.class);
            intent2.putExtra("2",text2);
            ToastUtils.showInfo(mcontext,"我选择的是女子科");
            startActivity(intent2);
        }else if(tempbutton.getText().toString().equals("内科")){
            String text3=button3.getText().toString();
            Intent intent3=new Intent();
            intent3.setClass(mcontext,ChoiceDoctor.class);
            intent3.putExtra("3",text3);
            startActivity(intent3);
        }else if(tempbutton.getText().toString().equals("内分泌科")){
            String text4=button4.getText().toString();
            Intent intent4=new Intent();
            intent4.setClass(mcontext,ChoiceDoctor.class);
            intent4.putExtra("4",text4);
            startActivity(intent4);
        }else if(tempbutton.getText().toString().equals("心血管科")){
            String text5=button5.getText().toString();
            Intent intent5=new Intent();
            intent5.setClass(mcontext,ChoiceDoctor.class);
            intent5.putExtra("5",text5);
            startActivity(intent5);
        }else if(tempbutton.getText().toString().equals("皮肤科")){
            String text6=button6.getText().toString();
            Intent intent6=new Intent();
            intent6.setClass(mcontext,ChoiceDoctor.class);
            intent6.putExtra("6",text6);
            startActivity(intent6);
        }else if(tempbutton.getText().toString().equals("治未科")){
            String text7=button7.getText().toString();
            Intent intent7=new Intent();
            intent7.setClass(mcontext,ChoiceDoctor.class);
            intent7.putExtra("7",text7);
            startActivity(intent7);
        }else if(tempbutton.getText().toString().equals("风湿科")){
            String text8=button8.getText().toString();
            Intent intent8=new Intent();
            intent8.setClass(mcontext,ChoiceDoctor.class);
            intent8.putExtra("8",text8);
            startActivity(intent8);
        }else if(tempbutton.getText().toString().equals("针推科")){
            String text9=button9.getText().toString();
            Intent intent9=new Intent();
            intent9.setClass(mcontext,ChoiceDoctor.class);
            intent9.putExtra("9",text9);
            startActivity(intent9);
        }else if(tempbutton.getText().toString().equals("耳鼻喉科")){
            String text10=button10.getText().toString();
            Intent intent10=new Intent();
            intent10.setClass(mcontext,ChoiceDoctor.class);
            intent10.putExtra("10",text10);
            startActivity(intent10);
        }else if(tempbutton.getText().toString().equals("肿瘤科")){
            String text11=button11.getText().toString();
            Intent intent11=new Intent();
            intent11.setClass(mcontext,ChoiceDoctor.class);
            intent11.putExtra("11",text11);
            startActivity(intent11);
        }else if(tempbutton.getText().toString().equals("脾胃科")){
            String text12=button12.getText().toString();
            Intent intent12=new Intent();
            intent12.setClass(mcontext,ChoiceDoctor.class);
            intent12.putExtra("12",text12);
            startActivity(intent12);
        }else {

        }
    }
    @Override
    public void onClick(View v) {
        if(tempbutton==null){
            ToastUtils.showInfo(mcontext,"请选择医师");
        }else {
            nextChoice();
        }
    }

}
