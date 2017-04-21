package com.huanghuai.djt.dongjitang.Activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

public class EvaluateResultActivaty extends BaseActivity implements View.OnClickListener{
    private int phScore;
    private int qxScore;
    private int yxScore;
    private int yyxScore;
    private int tsScore;
    private int srScore;
    private int xyScore;
    private int qyScore;
    private int tbScore;
    private int max=0;
    private TextView allproperty;
    private TextView bodyproperty;
    private TextView habitproperty;
    private TextView psychicproperty;
    private TextView incidencetendency;
    private TextView suitability;
    private ImageView imageView;
    private Button endReview;


    @Override
    protected void addActivity() {
    }

    @Override
    protected void activityGetActivity() {

        Intent intent=getIntent();
        phScore=intent.getIntExtra("phScore",phScore);
        qxScore=intent.getIntExtra("qxScore",qxScore);
        yxScore=intent.getIntExtra("yxScore",yxScore);
        yyxScore=intent.getIntExtra("yyxScore",yyxScore);
        tsScore=intent.getIntExtra("tsScore",tsScore);
        srScore=intent.getIntExtra("srScore",srScore);
        xyScore=intent.getIntExtra("xyScore",xyScore);
        qyScore=intent.getIntExtra("qyScore",qyScore);
        tbScore=intent.getIntExtra("tbScore",tbScore);
        //Log.d(EvaluateResultActivaty.ACTIVITY_SERVICE,"我是传递过来的分数"+phScore);
//        ToastUtils.showInfo(mcontext,"我是传递过来的分数"+phScore);
        int []array={phScore,qxScore,yxScore,yyxScore,tsScore,srScore,xyScore,qyScore,tbScore};
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_evaluate_result;
    }

    @Override
    protected void initView() {
        endReview=(Button)findViewById(R.id.end_review);
        imageView=(ImageView)findViewById(R.id.property_bg);
        allproperty=(TextView)findViewById(R.id.all_property);
        bodyproperty=(TextView)findViewById(R.id.body_property);
        habitproperty=(TextView)findViewById(R.id.habit_property);
        psychicproperty=(TextView)findViewById(R.id.psychic_property);
        incidencetendency=(TextView)findViewById(R.id.incidence_tendency);
        suitability=(TextView)findViewById(R.id.suit_ability);
        judgeResult();
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initLitener() {
        endReview.setOnClickListener(this);
    }

    @Override
    protected void delHandler(Message msg) {

    }
    private void judgeResult(){
//        getMax();
        if(phScore>=60&&qxScore<=40&&yxScore<=40&&yyxScore<=40&&tsScore<=40&&srScore<=40&&xyScore<=40&&qyScore<=40&&tbScore<=40){
            ToastUtils.showInfo(mcontext,"平和质，我是传递过来的分数"+phScore);
        }else if (max>=30&&max==qxScore){
            ToastUtils.showInfo(mcontext,"气虚质，我是传递过来的分数"+qxScore);
            imageView.setImageResource(R.mipmap.qx_bg);
            allproperty.setText("【总体特征】元气不足，以疲乏、气短、自汗等气虚表现为主要特征。");
            bodyproperty.setText("【形态特征】肌肉松软不实");
            habitproperty.setText("【常见表现】平素语音低弱，气短懒言，容易疲乏，精神不振，易出汗，舌淡红，舌边有齿痕，脉弱。");
            psychicproperty.setText("【心理特征】性格内向，不惜冒险。");
            incidencetendency.setText("【发病倾向】易患感冒、内脏下垂等病；病后康复缓慢。");
            suitability.setText("【对外界环境适应能力】不耐受风、寒、暑、湿邪。");
        }else if (max==yxScore&&max>=30){
            ToastUtils.showInfo(mcontext,"阳虚质，我是传递过来的分数"+yxScore);
            imageView.setImageResource(R.mipmap.yx_bg);
            allproperty.setText("【总体特征】阳气不足，以畏寒怕冷、手足不温等虚寒表现为主要特征。");
            bodyproperty.setText("【形态特征】肌肉松软不实");
            habitproperty.setText("【常见表现】平素畏冷，手足不温，喜热饮食，精神不振，舌淡胖嫩，脉沉迟。");
            psychicproperty.setText("【心理特征】性格多沉静、内向。");
            incidencetendency.setText("【发病倾向】易患痰饮、肿胀、泄泻等病；感邪易从寒化。");
            suitability.setText("【对外界环境适应能力】耐夏不耐冬；易感风、寒、湿邪。");
        }else if (max==yyxScore&&max>=30){
            ToastUtils.showInfo(mcontext,"阴虚质，我是传递过来的分数"+yyxScore);
            imageView.setImageResource(R.mipmap.yyx_bg);
            allproperty.setText("【总体特征】阴液亏少，以口燥咽干、手足心热等虚热表现为主要特征。");
            bodyproperty.setText("【形态特征】体型偏瘦。");
            habitproperty.setText("【常见表现】手足心热，口燥咽干，鼻微干，喜冷饮，大便干燥，舌红少津，脉细数。");
            psychicproperty.setText("【心理特征】性情急躁，外向好动，活泼。");
            incidencetendency.setText("【发病倾向】易患虚劳、失精、不寐等病；感邪易从热化。");
            suitability.setText("【对外界环境适应能力】耐冬不耐夏；不耐受暑、热、燥邪。");
        }else if (max==tsScore&&max>=30){
            ToastUtils.showInfo(mcontext,"痰湿质，我是传递过来的分数"+tsScore);
            imageView.setImageResource(R.mipmap.ts_bg);
            allproperty.setText("【总体特征】痰湿凝聚，以形体肥胖、腹部肥满、口黏苔腻等痰湿表现为主要特征。");
            bodyproperty.setText("【形态特征】体型肥胖，腹部肥满松软。");
            habitproperty.setText("【常见表现】面部皮肤油脂较多，多汗且黏，胸闷，痰多，口黏腻或甜，喜食肥甘、甜腻，苔腻，脉滑。");
            psychicproperty.setText("【心理特征】性格偏温和、稳重，多善于忍耐。");
            incidencetendency.setText("【发病倾向】易患消渴、中风、胸痹等病。");
            suitability.setText("【对外界环境适应能力】对梅雨季节及湿重环境适应能力差。");
        }else if (max==srScore&&max>=30){
            ToastUtils.showInfo(mcontext,"湿热质，我是传递过来的分数"+srScore);
            imageView.setImageResource(R.mipmap.sr_bg);
            allproperty.setText("【总体特征】湿热内蕴，以面垢油光、口苦、苔黄腻等湿热表现为主要特征。");
            bodyproperty.setText("【形态特征】形体中等或偏瘦。");
            habitproperty.setText("【常见表现】面垢油光，易生痤疮，口苦口干，身重困倦，大便黏滞不畅或燥结，小便短黄，男性易阴囊潮湿，女性易带下增多，舌质偏红，苔黄腻，脉滑数。");
            psychicproperty.setText("【心理特征】容易心烦急躁。");
            incidencetendency.setText("【发病倾向】易患疮疖、黄疸、热淋等病");
            suitability.setText("【对外界环境适应能力】对夏末秋初湿热气候，湿重或气温偏高环境较难适应。");
        }else if (max==xyScore&&max>=30){
            ToastUtils.showInfo(mcontext,"血於质，我是传递过来的分数"+xyScore);
            imageView.setImageResource(R.mipmap.xy_bg);
            allproperty.setText("【总体特征】血行不畅，以肤色晦黯、舌质紫黯等血瘀表现为主要特征。");
            bodyproperty.setText("【形态特征】胖瘦均见");
            habitproperty.setText("【常见表现】肤色晦黯，色素沉着，容易出现瘀斑，口唇暗淡，舌黯或有瘀点，舌下络脉紫黯或增粗，脉涩");
            psychicproperty.setText("【心理特征】易烦，健忘。");
            incidencetendency.setText("【发病倾向】易患癥瘕及痛证，血证等。");
            suitability.setText("【对外界环境适应能力】不耐受寒邪。");
        }else if (max==qyScore&&max>=30){
            ToastUtils.showInfo(mcontext,"气郁质，我是传递过来的分数"+qyScore);
            imageView.setImageResource(R.mipmap.qy_bg);
            allproperty.setText("【总体特征】气机郁滞，以神情抑郁，忧虑脆弱等气郁表现为主要特征。");
            bodyproperty.setText("【形态特征】形体瘦者为多。");
            habitproperty.setText("【常见表现】神情抑郁，情感脆弱，烦闷不乐，舌淡红，苔薄白，脉弦。");
            psychicproperty.setText("【心理特征】性格内向不稳定、敏感多虑。");
            incidencetendency.setText("【发病倾向】易患脏躁、梅核气、百合病及郁证等。");
            suitability.setText("【对外界环境适应能力】对精神刺激适应能力较差；不适应阴雨天气。");
        }else if (max==tbScore){
            ToastUtils.showInfo(mcontext,"特禀质，我是传递过来的分数"+tbScore);
            imageView.setImageResource(R.mipmap.tb_bg);
            allproperty.setText("【总体特征】先天失常，以生理缺陷、过敏反应等为主要特征。");
            bodyproperty.setText("【形态特征】过敏体质者一般无特殊；先天禀赋异常者或有畸形，或有生理缺陷。");
            habitproperty.setText("【常见表现】过敏体质者常见哮喘、风团、咽痒、鼻塞、喷嚏等；患遗传性疾病者有垂直遗传、先天性、家族性特征；患胎传性疾病者具有母体影响胎儿个体生长发育及相关疾病特征。");
            psychicproperty.setText("【心理特征】随禀质不同情况各异。");
            incidencetendency.setText("【发病倾向】过敏体质者易患哮喘、荨麻疹、花粉症及药物过敏等。");
            suitability.setText("【对外界环境适应能力】适应能力差，如过敏体质者对易致过敏季节适应能力差。");
        }else if(max<30){
            ToastUtils.showInfo(mcontext,"平和质，我是传递过来的分数"+phScore);
            allproperty.setText("【总体特征】");
            bodyproperty.setText("【形态特征】");
            habitproperty.setText("【常见表现】");
            psychicproperty.setText("【心理特征】");
            incidencetendency.setText("【发病倾向】");
            suitability.setText("【对外界环境适应能力】");
        }
    }
    public void onClick(View v){
        Intent intent=new Intent();
        intent.setClass(mcontext,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
