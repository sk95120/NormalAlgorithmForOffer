package com.example.vvapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView = null;
    private RecyclerView.Adapter mAdapter = null;
    private RecyclerView.LayoutManager mlayoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        initData();
        initView();
    }


    private void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.myRecycleView);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mAdapter = new MyRecycleAdapter(getData());
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 5; i++) {
            data.add(i + temp);
        }
        return data;
    }
}
