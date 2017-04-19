package com.huanghuai.djt.dongjitang.Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huanghuai.djt.dongjitang.Bean.Product_Goods;
import com.huanghuai.djt.dongjitang.Fragment.ClassificationFragment;
import com.huanghuai.djt.dongjitang.Fragment.ShopCarFragment;
import com.huanghuai.djt.dongjitang.R;
import com.huanghuai.djt.dongjitang.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/4/17.
 * recycleView 的数据适配器
 */

public class Online_Shop_Classification_Menu_Adapter extends BaseExpandableListAdapter {

    private Context mcontext;
    private List<String> mgroup;
    private List<List<String>> mchild;

    /**
     * 初始化数据
     * @param group
     * @param child
     * @param context
     */
    public Online_Shop_Classification_Menu_Adapter(List<String> group,List<List<String>> child, Context context)
    {
        this.mchild=child;
        this.mcontext=context;
        this.mgroup=group;
    }

    /**
     * 获得数量
     * @return
     */
    @Override
    public int getGroupCount() {
        return mgroup.size();
    }


    @Override
    public int getChildrenCount(int i) {
        return mchild.size();
    }

    /**
     * 获得 父条目
     * @param i
     * @return
     */
    @Override
    public Object getGroup(int i) {
        return mgroup.get(i);
    }
    /**
     * 获得子条目
     * int groupPosition, int childPosition
     * @param i
     * @return
     */
    @Override
    public Object getChild(int i, int i1) {
        return mchild.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {

        return i;
    }

    /**
     *
     * @param i
     * @param i1
     * @return
     */
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null) {
            view=LayoutInflater.from(mcontext).inflate(R.layout.item_shop_car_classification_menu,null);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) view.findViewById(R.id.classification_tv_name);
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(mgroup.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null) {
            view=LayoutInflater.from(mcontext).inflate(R.layout.item_shop_car_classification_menu,null);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) view.findViewById(R.id.classification_tv_name);
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(mchild.get(i).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    class ViewHolder {
        TextView textView;
    }
}



