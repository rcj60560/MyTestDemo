package test.demo.luocj.com.myapplication.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.bean.DataModel;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class TypeTwoHolder extends TypeAbsHolder{
    private ImageView avatar;
    private TextView name;
    private TextView content;

    public TypeTwoHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avartar);
        name = itemView.findViewById(R.id.typeone_name);
        content = itemView.findViewById(R.id.content);
    }

    @Override
    public void bindholder(DataModel dataModel) {
        avatar.setBackgroundColor(dataModel.avartarColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }
}
