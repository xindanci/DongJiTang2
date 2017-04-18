package com.huanghuai.djt.dongjitang.Net;

import com.huanghuai.djt.dongjitang.Bean.Product_Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */

public class OnlineFragmentNet {
    //商品信息
    private ArrayList<Product_Goods> list_product_goods=new ArrayList<>();
    //轮播图信息
    private List<String> imageUrls=new ArrayList<>();
    public List<String> getListDate()
    {
        imageUrls.add("http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg");
        imageUrls.add("http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg");
        imageUrls.add("http://pic18.nipic.com/20111215/577405_080531548148_2.jpg");
        imageUrls.add("http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg");
        imageUrls.add("http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg");

        return imageUrls;
    }
    public ArrayList<Product_Goods> getListProductInfo() {
        for (int i = 0; i < 10; i++) {
            Product_Goods product_goods=new Product_Goods();
            product_goods.setName("东阿胶"+i);
            list_product_goods.add(product_goods);
        }
        return list_product_goods;
    }
}
