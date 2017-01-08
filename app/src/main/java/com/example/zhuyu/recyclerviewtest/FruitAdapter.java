package com.example.zhuyu.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuyu on 2017/1/7 0007.
 * 适配器需继承自RecyclerView.Adapter，泛型为创建的内部类Viewholder
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruitlist=new ArrayList<>();

    public FruitAdapter(List<Fruit> fruitlist) {
        //通过构造函数获取数据源
        this.fruitlist.addAll(fruitlist) ;
       // this.fruitlist=fruitlist;//这种形式是引用传递，外部list的修改会影响内部list
    }

    /**
     * 内部类ViewHolder需要继承自RecyclerView.ViewHolder，
     * 完成item中每个子项的声明与初始化
     * 纠结了半天是定义成static还是public，为了能访问成员变量fruitlist，还是用public来修饰吧
     */
    public  class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private TextView textView;
            public ViewHolder(final View itemView) {
                super(itemView);
                imageView= (ImageView) itemView.findViewById(R.id.imageView);
                textView= (TextView) itemView.findViewById(R.id.textView);
                //第一行代码书中将监听器放在了onCreateViewHolder（）方法中，放在这里也是可以得
                //RecyclerView的一个强大之处就是可以非常方便地实现子项和子项中的控件的点击事件
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position=getAdapterPosition();
                        Fruit fruit=fruitlist.get(position);
                        Toast.makeText(itemView.getContext(), "你点击了图片"+fruit.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(itemView.getContext(), "你点击了整个item", Toast.LENGTH_SHORT).show();
                    }
                });
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(itemView.getContext(), "你长按了整个item", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }
        }
    /**
     * 用于创建ViewHolder实例
     * @param parent  RecyclerView所在的父视图
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将itemview布局文件加载进来
        View view =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        //返回ViewHolder实例
        return new ViewHolder(view);
    }
    /**
     * 用于绑定数据，给每个RecyclerView子项的数据进行赋值
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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



    public void additem(int position){
       fruitlist.add(position,new Fruit("new Fruit",R.drawable.apple_pic));
        notifyItemInserted(position);


    }
    public void removeitem(int position){
        fruitlist.remove(position);
        notifyItemRemoved(position);

    }

}
