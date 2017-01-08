package com.example.zhuyu.recyclerviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
      private   RecyclerView recyclerView;
    List<Fruit> fruitList=new ArrayList<>();

    FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        initlist();//初始化水果数据
        Log.d("外部fruitlist",fruitList.hashCode()+"");
        adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);//设置适配器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置RecyclerView的默认布局方式
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置默认动画效果

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.verlistviewMenu:
                //设置垂直滚动
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.horlistviewMenu:
                //设置为水平滚动，第三个参数为是否反向排列滚动
                recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                break;
            case R.id.verGridViewMenu:
                //设置为网格布局垂直滚动，3列，不反向排列
                recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
                break;
            case R.id.horGridViewMenu:
                //设置为网格布局水平滚动，5行，不反向排列
                recyclerView.setLayoutManager(new GridLayoutManager(this,5,GridLayoutManager.HORIZONTAL,false));
                break;
            case R.id.StaggeredGridViewMenu:
                Intent intent=new Intent(MainActivity.this,StaggeredActivity.class);
                startActivity(intent);
                break;
            case R.id.addMenu:
                adapter.additem(1);
                break;
            case R.id.removeMenu:
                adapter.removeitem(1);
                break;

        }
        return super.onOptionsItemSelected(item);

    }
    //初始化水果数据
    private void initlist(){
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit("apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit cherry = new Fruit("cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit grape = new Fruit("grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit mango = new Fruit("mango", R.drawable.mango_pic);
            fruitList.add(mango);
            Fruit orange = new Fruit("orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit pear = new Fruit("pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit pineapple = new Fruit("pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
        }
    }

}
