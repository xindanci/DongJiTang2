package com.huanghuai.djt.dongjitang.Adpter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.Bean.Product_Goods;

import com.huanghuai.djt.dongjitang.Fragment.BaseFragment;
import com.huanghuai.djt.dongjitang.Fragment.OnlineFragment;

import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 * recycleView 的数据适配器
 */

public class Online_Shop_Goods_RecycleView_Adapter extends RecyclerView.Adapter<Online_Shop_Goods_RecycleView_Adapter.MyViewHolder> {

    private List monline_goods_list;
    private Context mcontext;
    private BaseFragment mBaseFragment;
//    private ArrayList<Product_Goods> selectedList = new ArrayList<>();

    /**
     * 构造方法初始化
     *
     * @param context
     * @param online_goods_list
     */
    public Online_Shop_Goods_RecycleView_Adapter(Context context, List<Product_Goods> online_goods_list, BaseFragment baseFragment) {
        this.mcontext = context;
        this.monline_goods_list = online_goods_list;
        this.mBaseFragment = baseFragment;

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
     * 绑定holder 绑定数据
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int i) {
        //当前条目的 所对应的 数据对象
        Product_Goods product_goods = (Product_Goods) monline_goods_list.get(i);
        viewHolder.shop_goods_name.setText(((Product_Goods) monline_goods_list.get(i)).getName());
        //设置添加进购物车的逻辑
//        setShopCarShow(product_goods,viewHolder,i);
        if (product_goods.getCount()<1) {
            viewHolder.shop_goods_shopping_cart.setVisibility(View.VISIBLE);
            viewHolder.iv_add.setVisibility(View.GONE);
            viewHolder.tv_count.setVisibility(View.GONE);
            viewHolder.iv_remove.setVisibility(View.GONE);
        }
        else {
            viewHolder.shop_goods_shopping_cart.setVisibility(View.GONE);
            viewHolder.iv_add.setVisibility(View.VISIBLE);
            viewHolder.tv_count.setVisibility(View.VISIBLE);
            viewHolder.iv_remove.setVisibility(View.VISIBLE);
            viewHolder.tv_count.setText(product_goods.getCount());
            ToastUtils.showInfo(mcontext,"aaaa"+product_goods.getCount());
//            ToastUtils.showInfo(mcontext,product_goods.getCount()+"");
        }
        viewHolder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 监听回调
                 */
                maddAndRemoveOnlcick.add(i);
                setAnimation(view);
            }
        });
        viewHolder.iv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 监听回调
                 */
                maddAndRemoveOnlcick.remove(i);
            }
        });
        /**
         * 设置 添加进购物车的 按钮的 事件 监听
         */
        viewHolder.shop_goods_shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maddAndRemoveOnlcick.add(i);
                setAnimation(view);
            }
        });

    }

    /**
     * 获取数据的总个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return monline_goods_list.size();
    }

    /**
     * 点击 添加进购物车的时候 的要执行 抛物线动画
     * 初始化动画条件
     */
    private void setAnimation(View view) {
        int[] startLocation = new int[2];// 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
        view.getLocationInWindow(startLocation);// 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
        ImageView ball = new ImageView(mcontext);
        ball.setImageResource(R.mipmap.number);
        mBaseFragment.setAnim(ball, startLocation);// 开始执行动画
    }

    /**
     * 创建holder
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //对应 商品的 图片信息,商品标签，加入购物车
        ImageView shop_goods_icon, shop_goods_Label, shop_goods_shopping_cart, iv_add, iv_remove;
        //商品的名字，评论，价格
        TextView shop_goods_name, shop_goods_price, shop_goods_comment, tv_count;
        RelativeLayout add_remove_control;

        public MyViewHolder(View itemView) {
            super(itemView);
            shop_goods_name = (TextView) itemView.findViewById(R.id.shop_goods_name);
            shop_goods_shopping_cart = (ImageView) itemView.findViewById(R.id.shop_goods_shopping_cart);

            add_remove_control = (RelativeLayout) itemView.findViewById(R.id.add_remove_control);

            iv_add = (ImageView) itemView.findViewById(R.id.iv_add);

            iv_remove = (ImageView) itemView.findViewById(R.id.iv_remove);

            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
    /**
     * 使用 监听回调
     *
     */
    private  AddAndRemove maddAndRemoveOnlcick;
    public  interface AddAndRemove{
        public void add(int i);
        public void remove(int i);


    }
    public void setAddAndRemoveOnlcick(AddAndRemove addAndRemoveOnlcick)
    {
        this.maddAndRemoveOnlcick=addAndRemoveOnlcick;
    }


}



