package test.demo.luocj.com.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import test.demo.luocj.com.myapplication.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ArrayList<String> title;
    private Context mContext;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initData();
        initView();
    }

    private void initData() {
        title = new ArrayList<>();
        title.add("xrecycleview");
        title.add("底部的dialog");
        title.add("ComplexRecyclerView");
        title.add("xrecycleview");
        title.add("xrecycleview");
        title.add("xrecycleview");
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        myAdapter = new MyAdapter(mContext, title);
        recyclerview.setAdapter(myAdapter);
    }
}
