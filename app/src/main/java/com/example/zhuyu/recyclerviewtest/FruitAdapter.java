package com.example.zhuyu.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7 0007.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
        private List<Fruit> fruitlist;

    public FruitAdapter(List<Fruit> fruitlist) {
        this.fruitlist = fruitlist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView= (ImageView) itemView.findViewById(R.id.imageView);
                textView= (TextView) itemView.findViewById(R.id.textView);
            }
        }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit=fruitlist.get(position);

        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitlist.size();
    }


}
