package test.demo.luocj.com.myapplication.adapter;

import android.content.Context;
import android.media.MediaDataSource;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.bean.DataModel;
import test.demo.luocj.com.myapplication.holder.TypeAbsHolder;
import test.demo.luocj.com.myapplication.holder.TypeOneHolder;
import test.demo.luocj.com.myapplication.holder.TypeThreeHolder;
import test.demo.luocj.com.myapplication.holder.TypeTwoHolder;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private LayoutInflater layoutInflater;

    private List<DataModel> list = new ArrayList<>();

    public DemoAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> list) {
        this.list.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPR_ONE:
                return new TypeOneHolder(layoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModel.TYPR_TWO:
                return new TypeTwoHolder(layoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModel.TYPR_THREE:
                return new TypeThreeHolder(layoutInflater.inflate(R.layout.item_type_three, parent, false));
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
//        ((TypeAbsHolder) holder).bindholder(list.get(position));
        switch (itemViewType) {
            case DataModel.TYPR_ONE:
                ((TypeOneHolder) holder).bindholder(list.get(position));
                break;
            case DataModel.TYPR_TWO:
                ((TypeTwoHolder) holder).bindholder(list.get(position));
                break;
            case DataModel.TYPR_THREE:
                ((TypeThreeHolder) holder).bindholder(list.get(position));
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type;
    }
}
