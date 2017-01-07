package com.example.zhuyu.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      private   RecyclerView recyclerView;
    List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        initlist();
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
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
