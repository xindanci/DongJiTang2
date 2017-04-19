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

    private ArrayList<Product_Goods> selectedList = new ArrayList<>();

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
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        //当前条目的 所对应的 数据对象
        Product_Goods product_goods = (Product_Goods) monline_goods_list.get(i);
        initListener(viewHolder, i);
        initBindDate(viewHolder, product_goods);
    }

    /**
     * 绑定数据
     */
    private void initBindDate(MyViewHolder myViewHolder, Product_Goods product_goods) {
        myViewHolder.shop_goods_name.setText(product_goods.getName());
        if (product_goods != null) {
            //默认进来数量
            if (product_goods.getCount() < 1) {
                myViewHolder.tv_count.setVisibility(View.INVISIBLE);
                myViewHolder.iv_remove.setVisibility(View.INVISIBLE);
//                monlineFragment.online_shop_goods_recycleView_adapter.notifyDataSetChanged();
            } else {
                myViewHolder.tv_count.setVisibility(View.VISIBLE);
                myViewHolder.iv_remove.setVisibility(View.VISIBLE);
                myViewHolder.tv_count.setText(String.valueOf(product_goods.getCount()));
//                monlineFragment.online_shop_goods_recycleView_adapter.notifyDataSetChanged();
            }
        } else {
            myViewHolder.tv_count.setVisibility(View.INVISIBLE);
            myViewHolder.iv_remove.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 处理holder中的item 数据的点击事件
     */
    private void initListener(final MyViewHolder viewHolder, final int i) {
        viewHolder.shop_goods_shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewHolder.shop_goods_shopping_cart.setVisibility(View.GONE);
                viewHolder.add_remove_control.setVisibility(View.VISIBLE);
                setAnimation(view);
            }
        });


        viewHolder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int product_id = ((Product_Goods) monline_goods_list.get(i)).getId();
                if (product_id < 1) {
                    viewHolder.iv_remove.setVisibility(View.VISIBLE);
                    viewHolder.tv_count.setVisibility(View.VISIBLE);
                }
                handlerCarNum(1, ((Product_Goods) monline_goods_list.get(i)), true);
//                monlineFragment.online_shop_goods_recycleView_adapter.notifyDataSetChanged();

                setAnimation(view);
            }
        });


        viewHolder.iv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int product_id = ((Product_Goods) monline_goods_list.get(i)).getId();
                if (product_id < 2) {
//                    viewHolder.iv_remove.setAnimation(getHiddenAnimation());
                    viewHolder.iv_remove.setVisibility(View.GONE);
                    viewHolder.tv_count.setVisibility(View.GONE);
                }
                handlerCarNum(0, ((Product_Goods) monline_goods_list.get(i)), true);
//                monlineFragment.online_shop_goods_recycleView_adapter.notifyDataSetChanged();
            }
        });

    }

    public void handlerCarNum(int type, Product_Goods goodsBean, boolean refreshGoodList) {
        if (type == 0) {
            if (goodsBean != null) {
                if (goodsBean.getCount() < 2) {
                    goodsBean.setCount(0);
                    selectedList.remove(goodsBean.getId());
//                    selectedList.remove()
                } else {
                    int i = goodsBean.getCount();
                    goodsBean.setCount(--i);
                }
            }
        } else if (type == 1) {

            if (goodsBean == null) {
                goodsBean.setCount(1);
                selectedList.add(goodsBean.getId(),goodsBean);
            } else {
                int i = goodsBean.getCount();
                goodsBean.setCount(++i);
            }
        }
//        mBaseFragment.update(refreshGoodList);
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
}



