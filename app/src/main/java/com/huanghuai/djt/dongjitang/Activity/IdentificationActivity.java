package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;


/**
 * Created by Administrator on 2017/4/13.
 */

public class IdentificationActivity extends BaseActivity implements View.OnClickListener{
    private int score;
    private float translateScore;
    private int phScore;
    private int qxScore;
    private int yxScore;
    private int yyxScore;
    private int tsScore;
    private int srScore;
    private int xyScore;
    private int qyScore;
    private int tbScore;
    private int i=1;
    private int never=0;
    private int seldom=0;
    private int sometime=0;
    private int usually=0;
    private int often=0;

    private int questionLength;

    String[] questionArray ={"一、您精力充沛吗？","二、您容易疲惫吗？","三、您说话声音低弱无力吗？","四、您感到闷闷不乐、情绪低沉吗？",
            "五、您比一般人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电风扇等）吗？","六、您能适应外界自然和社会环境变化吗？",
            "七、您容易失眠吗？","八、您容易忘事（健忘）吗？","一、您容易疲乏吗？","二、您容易气短（呼吸急促、接不上气）吗？","三、您容易心慌吗？","四、您容易头晕或站起来是眩晕吗？",
            "五、您比别人容易感冒吗？","六、您喜欢安静，懒得说话吗？","七、您说话声音低弱无力吗？","八、您活动量稍大就容易出虚汗吗？","一、您手脚发凉吗？","二、您胃脘，背部或腰膝部冷吗？","三、您感到怕冷、衣服比别人穿的多吗？","四、您冬天更怕冷，夏天不喜欢吹电扇、空调吗？",
            "五、您比别人容易感冒吗？","六、您吃（喝）凉的东西会感到不舒服或怕吃（喝）凉的吗？","七、您受凉或吃（喝）凉的东西后，容易腹泻、拉肚子吗","一、您搞到手脚心发热吗？","二、您感觉身体、脸上发热吗？","三、您皮肤或口唇干吗？","四、您口唇的颜色比一般人红吗？",
            "五、您容易便秘或大便干燥吗？","六？您面部两颧潮红或偏红吗？","七，您也感到眼睛干涩吗？","八、您感到口干咽燥、总想喝水吗？","一、您感到胸闷或腹部胀满吗？","二、您感到身体沉重不轻松或不爽快吗？","三、您腹部肥满松软吗？","四、您有两额部优质分泌多的现象吗？",
            "五、您上眼睑比别人肿（上眼睑有轻微隆起的现象）吗？","六、您嘴里有黏黏的感觉吗？","七、您平时痰多，特别是感觉到咽喉部总有痰堵着吗？","八、您舌苔厚腻或舌苔厚厚的感觉吗？","一、您面部或鼻部有油腻感或者油光发亮吗？","二、您脸上容易生痤疮或者皮肤容易生疮疖吗？","三、您感到口苦或嘴里有异味吗？","四、您大便粘滞不爽、有解不尽的感觉吗？",
            "五、您小便时尿道有发热感、尿色浓深吗？","六、您带下色黄（白带颜色发黄）吗？","七、您阴囊潮湿吗？","一、您皮肤在不知不觉中会出现青紫瘀斑（皮下出血）吗？","二、您的两颧部有细微血丝吗？","三、您身体上有哪里疼痛吗？","四、您面色晦暗或容易出血褐斑吗？",
            "五、您会出现黑眼圈吗？","六、您容易忘事吗？","七、您口唇颜色偏黯吗？","一、您感到闷闷不乐、情绪低沉吗？","二、您精神紧张、焦虑不安吗？","三、你多愁善感、感情脆弱吗？","四、您容易感到害怕或受到惊吓吗？",
            "五、您无缘无故叹气吗？","六、您咽喉部有异物感，且吐之不出。咽之不下吗？","一、您没有感冒会打喷嚏吗？","二、您没有干嘛也会鼻塞、流鼻涕吗？","三、您有因季节变化、温度变化或异味等原因出现咳嗽的现象吗？","四、您容易过敏（药物、食品、气味、花粉、季节交替时、气候变化等）吗？",
            "五、您的皮肤因过敏出现过紫癜（紫色於点、瘀斑）吗","六、您的皮肤一抓就红，并出现抓痕吗？"};

    private Button mbutton1;
    private Button mbutton2;
    private Button mbutton3;
    private Button mbutton4;
    private Button mbutton5;
    private ViewPager viewPager;
    @Override
    protected void addActivity() {

    }

    @Override
    protected void activityGetActivity() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_identification;
    }

    @Override
    protected void initView() {
        mbutton1=(Button)findViewById(R.id.button1);
        mbutton2=(Button)findViewById(R.id.button2);
        mbutton3=(Button)findViewById(R.id.button3);
        mbutton4=(Button)findViewById(R.id.button4);
        mbutton5=(Button)findViewById(R.id.button5);

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initLitener() {
        mbutton1.setOnClickListener(this);
        mbutton2.setOnClickListener(this);
        mbutton3.setOnClickListener(this);
        mbutton4.setOnClickListener(this);
        mbutton5.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }
    @Override
    public void onClick(View v){
        if(i==65){
            Intent intent=new Intent();
            intent.setClass(mcontext,EvaluateResultActivaty.class);
            intent.putExtra("phScore",phScore);
            intent.putExtra("qxScore",qxScore);
            intent.putExtra("yxScore",yxScore);
            intent.putExtra("yyxScore",yyxScore);
            intent.putExtra("tsScore",tsScore);
            intent.putExtra("srScore",srScore);
            intent.putExtra("xyScore",xyScore);
            intent.putExtra("qyScore",qyScore);
            intent.putExtra("tbScore",tbScore);
            startActivity(intent);
            finish();
        }

        switch (v.getId()) {
            case R.id.button1:
                mbutton1.setEnabled(false);
                mbutton2.setEnabled(false);
                mbutton3.setEnabled(false);
                mbutton4.setEnabled(false);
                mbutton5.setEnabled(false);
                never=never+1;
                ToastUtils.showInfo(mcontext,never+"never");
                mbutton1.setBackgroundResource(R.mipmap.never1);
                ToastUtils.showInfo(mcontext, "按钮一被调用了");
                changeQuestion();

                break;
            case R.id.button2:
                mbutton2.setEnabled(false);
                mbutton1.setEnabled(false);
                mbutton3.setEnabled(false);
                mbutton4.setEnabled(false);
                mbutton5.setEnabled(false);
                seldom=seldom+1;
                ToastUtils.showInfo(mcontext,seldom+"seldom");
                mbutton2.setBackgroundResource(R.mipmap.seldom1);
                //ToastUtils.showInfo(mcontext, "按钮二被调用了");
                changeQuestion();
                break;
            case R.id.button3:
                mbutton1.setEnabled(false);
                mbutton2.setEnabled(false);
                mbutton3.setEnabled(false);
                mbutton4.setEnabled(false);
                mbutton5.setEnabled(false);
                sometime=sometime+1;
                ToastUtils.showInfo(mcontext,sometime+"sometime");
                mbutton3.setBackgroundResource(R.mipmap.sometime1);
                //ToastUtils.showInfo(mcontext, "按钮三被调用了");
                changeQuestion();
                break;
            case R.id.button4:
                mbutton1.setEnabled(false);
                mbutton2.setEnabled(false);
                mbutton3.setEnabled(false);
                mbutton4.setEnabled(false);
                mbutton5.setEnabled(false);
                often=often+1;
                ToastUtils.showInfo(mcontext,often+"often");
                mbutton4.setBackgroundResource(R.mipmap.often1);
                //ToastUtils.showInfo(mcontext, "按钮四被调用了");
                changeQuestion();
                break;
            case R.id.button5:
                mbutton1.setEnabled(false);
                mbutton2.setEnabled(false);
                mbutton3.setEnabled(false);
                mbutton4.setEnabled(false);
                mbutton5.setEnabled(false);
                usually=usually+1;
                ToastUtils.showInfo(mcontext,usually+"usually");
                mbutton5.setBackgroundResource(R.mipmap.usually1);
                //ToastUtils.showInfo(mcontext, "按钮五被调用了");
                changeQuestion();
                break;
            default:
                break;
        }
    }
    public void changeQuestion(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(100);
                final TextView question=(TextView)findViewById(R.id.question);
                //ToastUtils.showInfo(mcontext, "换问题方法被调用了");
                if(i<9){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=8;
                            phScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+phScore);
                            String xxx=questionArray[i-1];
                            if(xxx.startsWith("一")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                }else if(i<17&&i>8){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            question.setText(questionArray[i]);
                            i++;
                            questionLength=8;
                            qxScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+qxScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<24&&i>16){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=7;
                            yxScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+yxScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<32&&i>23){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=8;
                            yyxScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+ yyxScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<40&&i>31){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=8;
                            tsScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+tsScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<47&&i>39){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=7;
                            srScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+srScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<54&&i>46){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=7;
                            xyScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+xyScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<60&&i>53){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=6;
                            qyScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+qyScore);
                            String xxx=questionArray[i];
                            if(xxx.startsWith("二")){
                                initScore();
                            }
                            setDefault();
                        }
                    });
                } else if(i<65&&i>59){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            question.setText(questionArray[i]);
                            i++;
                            questionLength=6;
                            tbScore=theScore(questionLength);
                            Log.d(IdentificationActivity.ACTIVITY_SERVICE,"转化分是："+tbScore);
                            setDefault();
                        }
                    });
                }
            }
        }).start();
    }

    public void setDefault(){
        mbutton1.setBackgroundResource(R.mipmap.never);
        mbutton2.setBackgroundResource(R.mipmap.seldom);
        mbutton3.setBackgroundResource(R.mipmap.sometime);
        mbutton4.setBackgroundResource(R.mipmap.often);
        mbutton5.setBackgroundResource(R.mipmap.usually);
        mbutton1.setEnabled(true);
        mbutton2.setEnabled(true);
        mbutton3.setEnabled(true);
        mbutton4.setEnabled(true);
        mbutton5.setEnabled(true);
    }
    private int theScore(int questionLength){
        score=never*1+seldom*2+sometime*3+often*4+usually*5;
        translateScore=(float) (score-questionLength)/(questionLength*4);
        return (int)(translateScore*100);
    }
    private void initScore(){
        score=0;
        usually=0;
        never=0;
        seldom=0;
        sometime=0;
        often=0;
    }
}
