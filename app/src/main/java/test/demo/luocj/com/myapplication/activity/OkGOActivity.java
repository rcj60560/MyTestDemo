package test.demo.luocj.com.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import test.demo.luocj.com.myapplication.Interface.OkGoInterface;
import test.demo.luocj.com.myapplication.OkGoUtil.OkGoUtil;
import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.bean.NewsBean;

/**
 * Created by luocj515 on 2017/7/12.
 * 项目名称：MyTestDemo
 * 类描述：
 * 创建人：hasee
 * 创建时间：2017/7/12 22:31
 * 修改备注：
 */

public class OkGOActivity extends AppCompatActivity {
    private String TAG = "TAG";
    private TextView result;
    private Adapter adapter;
    private RecyclerView recyclerview;
    private String url;
    private List<NewsBean.NewslistBean> newslist;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);
        result = (TextView) findViewById(R.id.tv_result);
        url = "http://api.tianapi.com/social/?key=861a794733dd2b057e415d822bef9586&num=30";
        initView();
        initData();
    }

    private void initData() {
        OkGo.<String>get(url).tag("okgo").cacheMode(CacheMode.DEFAULT).connTimeOut(5000)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        NewsBean newsBean = JSONObject.parseObject(s, NewsBean.class);
                        newslist = newsBean.getNewslist();
                        adapter.addDatas(newslist);
                        Log.i(TAG, "onSuccess: "+ newslist.size());
                    }

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OkGOActivity.this, LinearLayoutManager.VERTICAL, false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);

        adapter = new Adapter();
        recyclerview.setAdapter(adapter);
    }

    public void OkgoBtn(View view) {
        Log.i(TAG, "OkgoBtn: ");
//        String url = "http://api.tianapi.com/social/?key=861a794733dd2b057e415d822bef9586&num=10";
        String url = "http://api.tianapi.com/social/";
        HttpParams httpParams = new HttpParams();
        httpParams.put("key", "861a794733dd2b057e415d822bef9586");
        httpParams.put("num", 5);


        OkGoUtil okGoUtil = new OkGoUtil(OkGOActivity.this);
        okGoUtil.doNet(new OkGoInterface() {
            @Override
            public void onError(Call call, Response response, Exception e) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onAfter(String s, Exception e) {
                Log.i(TAG, "onAfter: ");
            }

            @Override
            public void onSuccess(String s, Call call, Response response) {
                Log.i(TAG, "onSuccess: " + s.toString());
            }

            @Override
            public void onStart(BaseRequest request) {
                Log.i(TAG, "onStart: ");
            }
        });


//        OkGo.get(url)
//                .cacheKey("OkGOActivity")
//                .params(httpParams)
////                .params("key", "861a794733dd2b057e415d822bef9586")
////                .params("num", 5)
//                .cacheMode(CacheMode.DEFAULT)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(String s, Call call, Response response) {
////
////                        NewsBean newsBean = JSONObject.parseObject(s, NewsBean.class);
////                        List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
////                        result.setText(newslist.get(0).toString());
//
//
//
//                    }
//                });

    }


    private class Adapter extends RecyclerView.Adapter<Holder> {

        private List<NewsBean.NewslistBean> newslistBeen = new ArrayList<>();

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            Holder holder = new Holder(LayoutInflater.from(OkGOActivity.this).inflate(R.layout.item_imageview, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            Glide.with(OkGOActivity.this).load(newslistBeen.get(position).getPicUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.imageview);
        }

        @Override
        public int getItemCount() {
            return newslistBeen.size();
        }

        public void addDatas(List<NewsBean.NewslistBean> newslist) {
            this.newslistBeen = newslist;
            notifyDataSetChanged();
        }
    }

    private class Holder extends RecyclerView.ViewHolder {
        public ImageView imageview;

        public Holder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
        }
    }
}
