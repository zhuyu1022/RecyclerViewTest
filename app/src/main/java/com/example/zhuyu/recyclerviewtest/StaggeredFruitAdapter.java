package com.example.zhuyu.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZHUYU on 2017/1/8 0008.
 * 单独为瀑布流创建的适配器
 * 适配器需继承自RecyclerView.Adapter，泛型为创建的内部类Viewholder
 */

public class StaggeredFruitAdapter extends RecyclerView.Adapter<StaggeredFruitAdapter.ViewHolder>{


    private List<Fruit> fruitlist;

    public StaggeredFruitAdapter(List<Fruit> fruitlist) {
        //通过构造函数获取数据源
        this.fruitlist = fruitlist;
    }
    /**
     * 内部类ViewHolder需要继承自RecyclerView.ViewHolder，
     * 完成item中每个子项的声明与初始化
     * 至于为什么定义成静态类，先不去管它
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textView= (TextView) itemView.findViewById(R.id.textView);
        }
    }
    /**
     * 用于创建ViewHolder实例
     * @param parent  RecyclerView所在的父视图
     * @param viewType
     * @return
     */
    @Override
    public StaggeredFruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将itemview布局文件加载进来
        View view =LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.staggered_fruit_item,parent,false);
        //返回ViewHolder实例
        return new StaggeredFruitAdapter.ViewHolder(view);
    }
    /**
     * 用于绑定数据，给每个RecyclerView子项的数据进行赋值
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(StaggeredFruitAdapter.ViewHolder holder, int position) {
        //得到当前子项的Fruit实例
        Fruit fruit=fruitlist.get(position);
        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getName());
    }

    /**
     * 告诉RecyclerView一共有多少子项
     * @return
     */
    @Override
    public int getItemCount() {
        return fruitlist.size();
    }

}
