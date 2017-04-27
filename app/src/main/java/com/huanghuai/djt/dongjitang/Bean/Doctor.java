package com.huanghuai.djt.dongjitang.Bean;

/**
 * Created by Administrator on 2017/4/25 0025.
 */

public class Doctor {
    private String name;
    private int imageId;
    public Doctor(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public int getImageId() {
        return imageId;
    }
    public String getName() {
        return name;
    }

}
