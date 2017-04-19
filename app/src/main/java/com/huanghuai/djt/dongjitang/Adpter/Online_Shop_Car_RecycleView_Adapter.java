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
import com.huanghuai.djt.dongjitang.Fragment.OnlineFragment;
import com.huanghuai.djt.dongjitang.Fragment.ShopCarFragment;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 * recycleView 的数据适配器
 */

public class Online_Shop_Car_RecycleView_Adapter extends RecyclerView.Adapter<Online_Shop_Car_RecycleView_Adapter.MyViewHolder> {

    private List monline_goods_list;
    private Context mcontext;
    private ShopCarFragment mshopCarFragment;

    private ArrayList<Product_Goods> selectedList = new ArrayList<>();

    /**
     * 构造方法初始化
     *
     * @param context
     * @param online_goods_list
     */
    public Online_Shop_Car_RecycleView_Adapter(Context context, List<Product_Goods> online_goods_list, ShopCarFragment shopCarFragment) {
        this.mcontext = context;
        this.monline_goods_list = online_goods_list;
        this.mshopCarFragment = shopCarFragment;
    }

    /**
     * 创建holder
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.item_online_shopcar_goods, viewGroup, false));
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
        myViewHolder.shop_car_name.setText(product_goods.getName());

    }

    /**
     * 处理holder中的item 数据的点击事件
     */
    private void initListener(final MyViewHolder viewHolder, final int i) {
        viewHolder.shop_car_iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showInfo(mcontext,"添加");
            }
        });
        viewHolder.shop_car_iv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showInfo(mcontext,"删除");
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
     * 创建holder
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //对应 商品的 图片信息,商品标签，加入购物车
        ImageView shop_car_icon, shop_car_Label, shop_car_iv_add, shop_car_iv_remove;
        //商品的名字，评论，价格
        TextView shop_car_name, shop_car_price,  shop_car_tv_count;
        public MyViewHolder(View itemView) {
            super(itemView);
            shop_car_name = (TextView) itemView.findViewById(R.id.shop_car_name);
            shop_car_iv_add = (ImageView) itemView.findViewById(R.id.shop_car_iv_add);
            shop_car_iv_remove = (ImageView) itemView.findViewById(R.id.shop_car_iv_remove);
            shop_car_tv_count = (TextView) itemView.findViewById(R.id.shop_car_tv_count);
        }
    }
}



