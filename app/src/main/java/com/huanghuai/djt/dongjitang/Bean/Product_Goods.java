package com.huanghuai.djt.dongjitang.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/4/17.
 */
@Entity
public class Product_Goods {
    /**
     * 商品id
     * 名字
     * 价格
     * 评论数
     * 标签
     * 选中的 商品 数量
     * 商品 详情
     * 说明
     * 评价
     * 分类(处方/非处方)
     * 分类二级分类
     */
    @Id
    private long id;
    private String name;
    private String price;
    private String comment;
    private int label;
    private int count;
    private String details;
    private String explain;
    private String evaluate;
    private boolean prescription;
    private String classification;
    public String getClassification() {
        return this.classification;
    }
    public void setClassification(String classification) {
        this.classification = classification;
    }
    public boolean getPrescription() {
        return this.prescription;
    }
    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }
    public String getEvaluate() {
        return this.evaluate;
    }
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
    public String getExplain() {
        return this.explain;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }
    public String getDetails() {
        return this.details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getLabel() {
        return this.label;
    }
    public void setLabel(int label) {
        this.label = label;
    }
    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 1533070493)
    public Product_Goods(long id, String name, String price, String comment,
            int label, int count, String details, String explain, String evaluate,
            boolean prescription, String classification) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.label = label;
        this.count = count;
        this.details = details;
        this.explain = explain;
        this.evaluate = evaluate;
        this.prescription = prescription;
        this.classification = classification;
    }
    @Generated(hash = 434009121)
    public Product_Goods() {
    }
}
