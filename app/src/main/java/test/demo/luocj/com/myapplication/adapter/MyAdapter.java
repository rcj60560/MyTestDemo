package test.demo.luocj.com.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.activity.ButtonDialogActivity;
import test.demo.luocj.com.myapplication.activity.ComplexRecyclerView;
import test.demo.luocj.com.myapplication.activity.OkGOActivity;
import test.demo.luocj.com.myapplication.activity.RecyclerviewActivity;
import test.demo.luocj.com.myapplication.activity.XRecyclerViewActivity;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private static final String TAG = "TAG";
    private ArrayList<String> title;
    private Context mContext;
    LayoutInflater inflater;

    public MyAdapter(Context mContext, ArrayList<String> title) {
        this.mContext = mContext;
        this.title = title;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item_main, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.textView.setText(title.get(position));
        /*
        *
        *
        *
        * */
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext, XRecyclerViewActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, ButtonDialogActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, ComplexRecyclerView.class));
                        break;

                    case 3:
                        mContext.startActivity(new Intent(mContext, RecyclerviewActivity.class));
//                        mContext.startActivity(new Intent(mContext, TestActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext,OkGOActivity.class));


                    default:
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_des);
        }
    }
}
