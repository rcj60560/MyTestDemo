package test.demo.luocj.com.myapplication.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.bean.DataModel;
import test.demo.luocj.com.myapplication.widget.ShareDialog;
import test.demo.luocj.com.myapplication.widget.bottomdialog.BaseBottomDialog;
import test.demo.luocj.com.myapplication.widget.bottomdialog.BottomDialog;

/**
 * Created by luocj515 on 2017/7/2.
 * 项目名称：MyTestDemo
 * 类描述：
 * 创建人：hasee
 * 创建时间：2017/7/2 10:13
 * 修改备注：
 */

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private String TAG = "TAG";
    private RecyclerviewAdapter recyclerviewAdapter;
    private ArrayList<DataModel> dataModels;
    private BaseBottomDialog bottomDialog;
    private ShareDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initData() {
        dataModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DataModel dataModel = new DataModel();
            dataModel.type = (int) ((Math.random() * 2) + 1);
            dataModel.content = "content :" + i;
            dataModels.add(dataModel);
            Log.i(TAG, "initData: " + dataModels.get(i).type);
        }
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerviewActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter();
        recyclerview.setAdapter(recyclerviewAdapter);

    }

    private class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Holder> {
        @Override
        public RecyclerviewAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = null;
            switch (viewType) {
                case 1:
                    view = LayoutInflater.from(RecyclerviewActivity.this).inflate(R.layout.item_one_layout, parent, false);
                    return new Holder(view);
                case 2:
                    view = LayoutInflater.from(RecyclerviewActivity.this).inflate(R.layout.item_two_layout, parent, false);
                    return new Holder(view);
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerviewAdapter.Holder holder, final int position) {
            switch (getItemViewType(position)) {
                case 1:
                    holder.tvOne.setText(dataModels.get(position).content);
                    holder.tvOne.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.i(TAG, "onBindViewHolder: " + position);
                            bottomDialog = BottomDialog.create(getSupportFragmentManager())
                                    .setViewListener(new BottomDialog.ViewListener() {
                                        @Override
                                        public void bindView(View v) {
                                            onClickView(v);
                                        }
                                    })
                                    .setLayoutRes(R.layout.dialog_layout)
                                    .setDimAmount(0.9f)
                                    .setTag("BottomDialog")
                                    .setCancelOutside(true)
                                    .show();
                        }
                    });
                    break;
                case 2:
                    holder.tvTwo.setText(dataModels.get(position).content);
                    holder.tvTwo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.i(TAG, "onClick: " + position);
                            dialog = new ShareDialog(RecyclerviewActivity.this, false);
                            dialog.setShareTitle("慕课网");
                            dialog.setShareTitleUrl("http://www.imooc.com");
                            dialog.setShareText("慕课网");
                            dialog.setShareSite("imooc");
                            dialog.setShareSiteUrl("http://www.imooc.com");
                            dialog.setImagePhoto(Environment.getExternalStorageDirectory() + "/test2.jpg");
                            dialog.show();
                        }
                    });
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return dataModels.size();
        }

        @Override
        public int getItemViewType(int position) {
            return dataModels.get(position).type;
        }


        public class Holder extends RecyclerView.ViewHolder {
            public TextView tvOne;
            public TextView tvTwo;
            public ImageView iv;

            public Holder(View itemView) {
                super(itemView);
                tvOne = itemView.findViewById(R.id.tv_one);
                tvTwo = itemView.findViewById(R.id.tv_typetwo);
                iv = itemView.findViewById(R.id.iv_type_two);

            }
        }
    }

    private void onClickView(View v) {
        v.findViewById(R.id.iv_weixin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RecyclerviewActivity.this, "weixin", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
