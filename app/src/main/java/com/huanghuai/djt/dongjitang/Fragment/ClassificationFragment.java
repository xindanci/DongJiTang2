package com.huanghuai.djt.dongjitang.Fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.Adpter.Online_Shop_Classification_Menu_Adapter;
import com.huanghuai.djt.dongjitang.Adpter.Online_Shop_Goods_RecycleView_Adapter;
import com.huanghuai.djt.dongjitang.Bean.Product_Goods;
import com.huanghuai.djt.dongjitang.CustomUI.RecycleViewDivider;
import com.huanghuai.djt.dongjitang.Net.ShopCarFragmentNet;
import com.huanghuai.djt.dongjitang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ClassificationFragment extends BaseFragment implements View.OnClickListener{
    //商品信息
    private ArrayList<Product_Goods> list_product_goods=new ArrayList<>();

    private Online_Shop_Classification_Menu_Adapter online_shop_classification_menu_adapter;
    //商品 分类的 button
    private Button online_shop_classification_bt_new_product;
    private RelativeLayout online_shop_classification_rl;
    //商品分类的 数据
    private List<String> goods_classification_group;
    private List<List<String>>goods_classification_child;
    //获取数据
    private ShopCarFragmentNet shopCarFragmentNet;
    //商品 信息
    private RecyclerView online_shop_goods_calssification_recycleview;
    //分类
    private ExpandableListView online_shop_calssification_expandleListView_menu;
    private Online_Shop_Goods_RecycleView_Adapter online_shop_goods_recycleView_adapter;
    //分类的 向上下图标
    private ImageView classification_show;
    //分类的 下边的 完成按钮
    private TextView check_classification_over;
    public ClassificationFragment(Context context)
    {
        this.mcontext=context;
    }
    @Override
    protected View getResourceView(LayoutInflater inflater, ViewGroup container) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_classification_page,null);
        return view;
    }

    @Override
    protected void initView() {
        //商品的展示
        online_shop_goods_calssification_recycleview= (RecyclerView) view.findViewById
                (R.id.online_shop_goods_calssification_recycleview);
        initRecycleView();
        //商品 分类的 展示
        online_shop_calssification_expandleListView_menu= (ExpandableListView) view.findViewById
                (R.id.online_shop_calssification_expandleListView_menu);
        //分类的按钮
        online_shop_classification_bt_new_product= (Button) view.
                findViewById(R.id.online_shop_classification_bt_new_product);
        online_shop_classification_rl= (RelativeLayout) view.findViewById(R.id.online_shop_classification_rl);
        classification_show= (ImageView) view.findViewById(R.id.classification_show);
        check_classification_over= (TextView) view.findViewById(R.id.check_classification_over);
        checkBtPress(0);
    }

    /**
     * 初始化 recycleView
     */
    private void initRecycleView()
    {
        online_shop_goods_calssification_recycleview.setLayoutManager(
                new LinearLayoutManager(mcontext));
        online_shop_goods_calssification_recycleview.setHasFixedSize(true);
        online_shop_goods_calssification_recycleview.addItemDecoration(
                new RecycleViewDivider(mcontext, 2));
    }

    @Override
    protected void initListener() {
        online_shop_classification_bt_new_product.setOnClickListener(this);
        online_shop_classification_rl.setOnClickListener(this);
        check_classification_over.setOnClickListener(this);
    }

    @Override
    protected void initDate() {
        list_product_goods.clear();

        if (shopCarFragmentNet == null) {
            //当前的页面的 联网工具
            shopCarFragmentNet = new ShopCarFragmentNet();
        }
        list_product_goods= shopCarFragmentNet.getListProductInfo();
        online_shop_goods_recycleView_adapter=new Online_Shop_Goods_RecycleView_Adapter
                (mcontext,list_product_goods,this);
        online_shop_goods_calssification_recycleview.setAdapter
                (online_shop_goods_recycleView_adapter);

        //分类的数据获取 与展示
        goods_classification_group=new ArrayList<>();
        goods_classification_child=new ArrayList<>();
        goods_classification_group=shopCarFragmentNet.getListClassificationGroup();
        goods_classification_child=shopCarFragmentNet.getListClassificationChild();
        online_shop_classification_menu_adapter=new Online_Shop_Classification_Menu_Adapter
                (goods_classification_group,goods_classification_child,mcontext);
        online_shop_calssification_expandleListView_menu.
                setAdapter(online_shop_classification_menu_adapter);

    }
    @Override
    public void getmContext() {
        mcontext=view.getContext();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.online_shop_classification_bt_new_product:
                checkBtPress(0);
                break;
            case R.id.online_shop_classification_rl:
                checkBtPress(1);
                break;
            case R.id.check_classification_over:
                checkBtPress(2);
            default:
                break;
        }
    }
    /**
     * 分类的按钮的检查
     */
    private void checkBtPress(int flag) {
        if(flag==0)
        {
            online_shop_classification_bt_new_product.setBackgroundResource(R.drawable.bt_press);
            online_shop_classification_rl.setBackgroundResource(R.drawable.bt_normal);
            online_shop_calssification_expandleListView_menu.setVisibility(View.GONE);
            classification_show.setBackgroundResource(R.mipmap.classification_up);
            check_classification_over.setVisibility(View.GONE);
        }
        else if(flag==1) {
            online_shop_classification_bt_new_product.setBackgroundResource(R.drawable.bt_normal);
            online_shop_classification_rl.setBackgroundResource(R.drawable.bt_press);
            online_shop_calssification_expandleListView_menu.setVisibility(View.VISIBLE);
            classification_show.setBackgroundResource(R.mipmap.classification_down);
            check_classification_over.setVisibility(View.VISIBLE);
        }
        else if(flag==2)
        {
            online_shop_classification_bt_new_product.setBackgroundResource(R.drawable.bt_normal);
            online_shop_classification_rl.setBackgroundResource(R.drawable.bt_press);
            online_shop_calssification_expandleListView_menu.setVisibility(View.GONE);
            check_classification_over.setVisibility(View.GONE);
            classification_show.setBackgroundResource(R.mipmap.classification_up);
        }
    }
}
