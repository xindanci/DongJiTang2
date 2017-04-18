package com.huanghuai.djt.dongjitang.Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.Bean.Product_Goods;
import com.huanghuai.djt.dongjitang.Fragment.HomeFragment;
import com.huanghuai.djt.dongjitang.Fragment.OnlineFragment;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 * recycleView 的数据适配器
 */

public class Online_Shop_Goods_RecycleView_Adapter extends RecyclerView.Adapter<Online_Shop_Goods_RecycleView_Adapter.MyViewHolder> implements View.OnClickListener{

    private List monline_goods_list;
    private Context mcontext;

    OnlineFragment monlineFragment;


    /**
     * 构造方法初始化
     * @param context
     * @param online_goods_list
     */
    public Online_Shop_Goods_RecycleView_Adapter (Context context, List<Product_Goods> online_goods_list,OnlineFragment onlineFragment)
    {
        this.mcontext=context;
        this.monline_goods_list=online_goods_list;
        this.monlineFragment=onlineFragment;
    }
    /**
     * 创建holder
     */

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.item_online_shop_goods, viewGroup, false));
        return holder;
    }

    /**
     *绑定holder 绑定数据
     * @param myViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        //当前条目的 所对应的 数据对象
        Product_Goods product_goods= (Product_Goods) monline_goods_list.get(i);
        initListener(myViewHolder,i);
        initBindDate(myViewHolder,product_goods);


    }
    /**
     * 绑定数据
     */
    private void initBindDate(MyViewHolder myViewHolder, Product_Goods product_goods) {
        myViewHolder.shop_goods_name.setText(product_goods.getName());

    }
    /**
     * 处理holder中的 数据的点击事件
     */
    private void initListener(MyViewHolder myViewHolder, int i) {
        myViewHolder.shop_goods_shopping_cart.setOnClickListener(this);
        myViewHolder.shop_goods_name.setOnClickListener(this);
    }

    /**
     * 获取数据的总个数
     * @return
     */
    @Override
    public int getItemCount() {
        return monline_goods_list.size();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.shop_goods_shopping_cart:
                ToastUtils.showInfo(mcontext,"购物车被点击了");
                //设置动画 开始位置
                setAnimation(view);
                PropertyValuesHolder scaleX= PropertyValuesHolder.ofFloat("scaleX", 0.0f,1.0f);
                PropertyValuesHolder scaley=PropertyValuesHolder.ofFloat("scaleY", 0.0f,1.0f);
                //values 属性集:A set of PropertyValuesHolder objects whose values will be animated between over time.
                ObjectAnimator objectAnimator= ObjectAnimator.ofPropertyValuesHolder(()v, scaleX,scaley);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            case R.id.shop_goods_name:
                ToastUtils.showInfo(mcontext,"商品名字被点击了");
                break;
            default:
                break;
        }
    }
    /**
     * 点击 添加进购物车的时候 的要执行 抛物线动画
     * 初始化动画条件
     */
    private void setAnimation(View view)
    {
        int[] startLocation = new int[2];// 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
        view.getLocationInWindow(startLocation);// 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
        ImageView ball = new ImageView(mcontext);
        ball.setImageResource(R.mipmap.number);
        monlineFragment.setAnim(ball, startLocation);// 开始执行动画
    }

    /**
     * 创建holder
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //对应 商品的 图片信息,商品标签，加入购物车
        ImageView shop_goods_icon,shop_goods_Label,shop_goods_shopping_cart;
        //商品的名字，评论，价格
        TextView shop_goods_name,shop_goods_price,shop_goods_comment;
        public MyViewHolder(View itemView) {
            super(itemView);
            shop_goods_name= (TextView) itemView.findViewById(R.id.shop_goods_name);
            shop_goods_shopping_cart= (ImageView) itemView.findViewById(R.id.shop_goods_shopping_cart);
        }
    }
}
