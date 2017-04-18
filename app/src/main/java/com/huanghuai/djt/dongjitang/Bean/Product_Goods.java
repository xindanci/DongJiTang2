package com.huanghuai.djt.dongjitang.Bean;

/**
 * Created by Administrator on 2017/4/17.
 */

public class Product_Goods {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 商品id
     * 名字
     * 价格
     * 评论数
     * 标签
     *
     */
    private int id;
    private String name;
    private String price;
    private String comment;
    private String label;

}
