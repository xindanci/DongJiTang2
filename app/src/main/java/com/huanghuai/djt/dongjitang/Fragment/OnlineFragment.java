package com.huanghuai.djt.dongjitang.Fragment;


import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.huanghuai.djt.dongjitang.Adpter.Online_Shop_Goods_RecycleView_Adapter;
import com.huanghuai.djt.dongjitang.Application.MyApplication;
import com.huanghuai.djt.dongjitang.Bean.ADInfo;
import com.huanghuai.djt.dongjitang.Bean.Product_Goods;
import com.huanghuai.djt.dongjitang.CustomUI.FullLinearLayout;
import com.huanghuai.djt.dongjitang.CustomUI.RecycleViewDivider;
import com.huanghuai.djt.dongjitang.CustomUI.ShopCarAnimation;
import com.huanghuai.djt.dongjitang.CustomUI.SimpleCycleViewPager;
import com.huanghuai.djt.dongjitang.Gen.Product_GoodsDao;
import com.huanghuai.djt.dongjitang.Net.OnlineFragmentNet;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class OnlineFragment extends BaseFragment {
    //商品信息的集合对象
    private List<Product_Goods> list_product_goods = new ArrayList<>();
    //轮播图组件
    private SimpleCycleViewPager simpleCycleViewPager;
    //设置商品的种类的数据展示
    private RecyclerView online_shop_goods_recycleview;
    //设置 recycleView的adapter
    public Online_Shop_Goods_RecycleView_Adapter online_shop_goods_recycleView_adapter;
    //在线商城界面的 的联网
    private OnlineFragmentNet onlineFragmentNet;
    //轮播图连网 解析到的图片 地址
    private List<String> loopnetUrls;
    //商品的个数
    private TextView bv_nunm;
    //商品的数据库
    private Product_GoodsDao product_goodsDao;
    //轮播图的对象集合
    private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();
    //获得 底部导航栏的 购物车 imageView 用于处理购物车动画的结束位置
    private ImageView mimageViewShopingCar;
    //获得 fragment的管理类
    private FragmentActivity mfragmentActivity;

    //选中的 商品的 集合
    private List<Product_Goods> selectedList = new ArrayList<>();
    public OnlineFragment(Context context) {
        //上下文 代码运行的 环境
        this.mcontext = context;
    }
    @Override
    protected void initView() {
        Fresco.initialize(mcontext);
        online_shop_goods_recycleview= (RecyclerView) view.findViewById(R.id.online_shop_goods_recycleview);
        //recycleView设置 数据填充和 滑动冲突解决
        online_shop_goods_recycleview.setLayoutManager(new FullLinearLayout(mcontext, 2));
        online_shop_goods_recycleview.addItemDecoration(new RecycleViewDivider(mcontext, 2));
        online_shop_goods_recycleview.setHasFixedSize(true);
        //轮播图
        simpleCycleViewPager = (SimpleCycleViewPager) view.findViewById(R.id.mySimapleCycleViewPager);
        //获得fragmentActivity的管理类
        mfragmentActivity=getActivity();
        //底部导航购物车ImageView
        mimageViewShopingCar= (ImageView) mfragmentActivity.findViewById(R.id.iv_shopcar);
        //创建动画类对象
        shopCarAnimation=new ShopCarAnimation(mcontext,mfragmentActivity,mimageViewShopingCar);
        bv_nunm= (TextView) mfragmentActivity.findViewById(R.id.bv_nunm);
        product_goodsDao= MyApplication.getApplication().getDaoSession().getProduct_GoodsDao();

    }
    /**
     * 初始化 选中的 商品和联网的 数据 进行匹配 更新获取到的 商品的 选择的 商品数量
     */
    private void initAdapterData() {
        for (int i = 0; i < list_product_goods.size(); i++) {
            for (int j = 0; j < selectedList.size(); j++) {
                if (selectedList.get(j).getId()==list_product_goods.get(i).getId())
                {
                    list_product_goods.get(i).setCount(selectedList.get(j).getCount());
                }
            }
        }
        online_shop_goods_recycleView_adapter.notifyDataSetChanged();
    }

    /**
     * 获取 数据库中的 已经选择的 商品的 集合
     */
    private void initSelect() {
        selectedList=product_goodsDao.loadAll();
        setBv_number();
    }
    @Override
    protected void initListener() {
        online_shop_goods_recycleView_adapter.setAddAndRemoveOnlcick(new Online_Shop_Goods_RecycleView_Adapter.AddAndRemove() {
            @Override
            public void add(int i) {
                Product_Goods product_goods=list_product_goods.get(i);
                product_goods.setCount(product_goods.getCount()+1);
                insertOrUpdate(i);
                online_shop_goods_recycleView_adapter.notifyDataSetChanged();
                setBv_number();
            }

            @Override
            public void remove(int i) {
                int count=list_product_goods.get(i).getCount();
                if (count==0)
                {
                    bv_nunm.setVisibility(View.GONE);
                    online_shop_goods_recycleView_adapter.notifyDataSetChanged();
                    return;
                }

                list_product_goods.get(i).setCount(list_product_goods.get(i).getCount()-1);
                insertOrUpdate(i);
                online_shop_goods_recycleView_adapter.notifyDataSetChanged();
                setBv_number();
            }

        });
    }
    @Override
    protected void initDate() {
        if (onlineFragmentNet == null) {
            //当前的页面的 联网工具
            onlineFragmentNet = new OnlineFragmentNet();
        }
        topRollIconImag();
        recycleViewProductInfo();
        initSelect();
        //初始话 数据更新
        initAdapterData();
    }

    @Override
    public void getmContext() {
        mcontext = view.getContext();
    }

    @Override
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_online, null);
        return view;
    }
    /**
     * 轮播图的 数据 获取 和展示
     */
    public void topRollIconImag() {
        infos.clear();
        loopnetUrls = onlineFragmentNet.getListDate();
        simpleCycleViewPager.setDatasource(loopnetUrls);
    }

    /**
     * recycleView的 商品信息的 获取和展示
     */
    public void recycleViewProductInfo() {
        list_product_goods.clear();
        list_product_goods = onlineFragmentNet.getListProductInfo();
        online_shop_goods_recycleView_adapter = new Online_Shop_Goods_RecycleView_Adapter(mcontext, list_product_goods,this);
        online_shop_goods_recycleview.setAdapter(online_shop_goods_recycleView_adapter);
    }
    public void insertOrUpdate(int i)
    {
        product_goodsDao.insertOrReplace(list_product_goods.get(i));
    }
    //初始化 底部购物车数量

    private void setBv_number()
    {
        int zoom_number=0;
        for (int i = 0; i < selectedList.size(); i++) {
            zoom_number+=selectedList.get(i).getCount();
        }
        if (zoom_number==0) {
            bv_nunm.setVisibility(View.GONE);
        }
        else {
            bv_nunm.setVisibility(View.VISIBLE);
//            bv_nunm.setText(zoom_number+"");
        }
        ToastUtils.showInfo(mcontext,"--"+zoom_number);
    }

}

