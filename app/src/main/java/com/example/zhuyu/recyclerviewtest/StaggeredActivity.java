package com.example.zhuyu.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaggeredActivity extends AppCompatActivity {
    private RecyclerView staggeredrecyclerView;
    List<Fruit> staggeredfruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);
        staggeredrecyclerView= (RecyclerView) findViewById(R.id.staggeredrecyclerView);
        //瀑布流需要重新设置设配器，初始化fruitlist等操作
        initStaggeredlist();
        StaggeredFruitAdapter Staggeredadapter=new StaggeredFruitAdapter(staggeredfruitList);
        staggeredrecyclerView.setAdapter(Staggeredadapter);
        //设置为瀑布流迟滞布局，3列
        staggeredrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
    }
    //单独为瀑布流初始化的水果数据
    private void initStaggeredlist(){
        staggeredfruitList.clear();
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit(getRandomLengthName("apple"), R.drawable.apple_pic);
            staggeredfruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("banana"), R.drawable.banana_pic);
            staggeredfruitList.add(banana);
            Fruit cherry = new Fruit(getRandomLengthName("cherry"), R.drawable.cherry_pic);
            staggeredfruitList.add(cherry);
            Fruit grape = new Fruit(getRandomLengthName("grape"), R.drawable.grape_pic);
            staggeredfruitList.add(grape);
            Fruit mango = new Fruit(getRandomLengthName("mango"), R.drawable.mango_pic);
            staggeredfruitList.add(mango);
            Fruit orange = new Fruit(getRandomLengthName("orange"), R.drawable.orange_pic);
            staggeredfruitList.add(orange);
            Fruit pear = new Fruit(getRandomLengthName("pear"), R.drawable.pear_pic);
            staggeredfruitList.add(pear);
            Fruit pineapple = new Fruit(getRandomLengthName("pineapple"), R.drawable.pineapple_pic);
            staggeredfruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("strawberry"), R.drawable.strawberry_pic);
            staggeredfruitList.add(strawberry);
            Fruit watermelon = new Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon_pic);
            staggeredfruitList.add(watermelon);
        }

    }

    /**
     * 将传入的字符串随机增加复制后返回
     * @param name
     * @return
     */
    private  String getRandomLengthName(String name){
        Random random=new Random();
        StringBuilder builder =new StringBuilder();
        int length=random.nextInt(40)+1;
        for (int i = 0; i <length ; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
