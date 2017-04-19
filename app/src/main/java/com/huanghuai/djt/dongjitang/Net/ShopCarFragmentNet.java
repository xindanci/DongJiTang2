package com.huanghuai.djt.dongjitang.Net;

import com.huanghuai.djt.dongjitang.Bean.Product_Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */

public class ShopCarFragmentNet {

    //商品信息
    private ArrayList<Product_Goods> list_product_goods=new ArrayList<>();
    //分类信息
    private ArrayList<String> list_classification_group=new ArrayList<>();
    private ArrayList<List<String>> list_classification_child=new ArrayList<>();
    public ArrayList<Product_Goods> getListProductInfo() {
        for (int i = 1; i < 10; i++) {
            Product_Goods product_goods=new Product_Goods();
            product_goods.setId(i);
            product_goods.setName("东阿胶"+i);
            product_goods.setCount(0);
            list_product_goods.add(product_goods);
        }
        return list_product_goods;
    }
    //获取 商品 分类的
    public ArrayList<String> getListClassificationGroup() {
        for (int i = 1; i < 4; i++) {
            list_classification_group.add("感冒");
        }

        return list_classification_group;
    }
    //获取 商品 分类的二级分类
    public List<List<String>> getListClassificationChild() {
        List<String> list = new ArrayList<String>();
        addInfo(new String[]{"朝阳","海淀","东城区","西城区"});
        addInfo( new String[]{"邯郸","石家庄","邢台"});
        addInfo( new String[]{"广州","深圳","珠海"});
        return list_classification_child;
    }
    private void addInfo(String[] c) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < c.length; i++) {
            list.add(c[i]);
        }
        list_classification_child.add(list);
    }

}
