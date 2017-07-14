package test.demo.luocj.com.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import test.demo.luocj.com.myapplication.R;

/**
 * Created by Administrator on 2017/6/18 0018.
 */

public class XAdapter extends RecyclerView.Adapter<XAdapter.Holder> {
    private ArrayList<String> strings;
    private Context mContext;

    public XAdapter(Context mContext, ArrayList<String> strings) {
        this.strings = strings;
        this.mContext = mContext;
    }

    @Override
    public XAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_xadapter, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final XAdapter.Holder holder, int position) {
        holder.textView.setText(strings.get(position));
        holder.itemView.setFocusable(true);
        holder.itemView.setTag(position);
        holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    Log.i("", "onFocusChange: "+view.getTag().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }
}
