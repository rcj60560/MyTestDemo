package test.demo.luocj.com.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import test.demo.luocj.com.myapplication.bean.DataModel;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public abstract class TypeAbsHolder extends RecyclerView.ViewHolder {
    public TypeAbsHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindholder(DataModel dataModel);
}
