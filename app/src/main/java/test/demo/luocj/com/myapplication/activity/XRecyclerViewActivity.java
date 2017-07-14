package test.demo.luocj.com.myapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.adapter.XAdapter;

/**
 * Created by Administrator on 2017/6/18 0018.
 */

public class XRecyclerViewActivity extends AppCompatActivity {

    private XRecyclerView mRecyclerView;
    private XAdapter xAdapter;
    private ArrayList<String> strings;
    private Context mContext;
    private int refreshTime;
    private int times = 0;
    private String TAG = "TAG";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecyceview);
        mContext = this;
        initData();
        initView();
    }

    private void initData() {
        strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("tianmu" + i);
        }
    }

    private void initView() {
        mRecyclerView = (XRecyclerView) findViewById(R.id.xrecycleview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        xAdapter = new XAdapter(mContext, strings);


        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

//        mRecyclerView.getChildAt(0).setTag("123");
//        Log.i(TAG, "initView: " + mRecyclerView.getChildAt(0).getTag().toString());

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if (e.getAction() == 0) {

                    Log.i(TAG, "onInterceptTouchEvent: " + rv.getChildAt(0).getTag());
                    Log.i(TAG, "onInterceptTouchEvent: " + e.getAction());

                }
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.i(TAG, "onTouchEvent: " + e.toString());
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

//                refreshTime ++;
//                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
//                        listData.clear();
//                        for(int i = 0; i < 15 ;i++){
//                            listData.add("item" + i + "after " + refreshTime + " times of refresh");
//                        }
                        xAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 15; i++) {
                                strings.add("item" + (1 + strings.size()));
                            }
                            mRecyclerView.loadMoreComplete();
                            xAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 9; i++) {
                                strings.add("item" + (1 + strings.size()));
                            }
                            mRecyclerView.setNoMore(true);
                            xAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times++;
            }
        });

//        listData = new  ArrayList<String>();
//        mAdapter = new MyAdapter(listData);
        mRecyclerView.setAdapter(xAdapter);
        mRecyclerView.refresh();
    }
}
