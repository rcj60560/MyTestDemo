package test.demo.luocj.com.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.adapter.DemoAdapter;
import test.demo.luocj.com.myapplication.bean.DataModel;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class ComplexRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerview;

    private DemoAdapter demoAdapter;

    int colors[] = {android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_red_dark};
    private ArrayList<DataModel> list;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexrecylerview);
        initData();
        initView();
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview_complex);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ComplexRecyclerView.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(linearLayoutManager);

        demoAdapter = new DemoAdapter(ComplexRecyclerView.this);
        recyclerview.setAdapter(demoAdapter);
        demoAdapter.addList(list);
        demoAdapter.notifyDataSetChanged();

    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DataModel data = new DataModel();
            int type = (int) ((Math.random() * 3) + 1);
            data.type = type;
            data.avartarColor = colors[type - 1];
            data.name = "name :" + i;
            data.content = "content" + i;
            data.contentColor = colors[(type + 1) % 3];
            list.add(data);
        }
    }
}
