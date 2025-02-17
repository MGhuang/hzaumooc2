package com.feidian.george.hzaumooc.Adapter.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.feidian.george.hzaumooc.Bmob.Bean.MainValue;
import com.feidian.george.hzaumooc.Listener.Main.ItemOnClickListener;
import com.feidian.george.hzaumooc.Listener.Main.MoreOnClickListener;
import com.feidian.george.hzaumooc.R;
import com.feidian.george.hzaumooc.View.NoScrollListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/11.
 */
class ViewHolderList extends RecyclerView.ViewHolder{

    private ItemOnClickListener itemOnClickListener;
    private MoreOnClickListener moreOnClickListener;
    @Bind(R.id.main_rl_logo)
    ImageView logo;
    @Bind(R.id.main_rl_title)
    TextView title;
    @Bind(R.id.main_rl_list)
    NoScrollListView listView;

    public ViewHolderList(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void setListener(ArrayList<MainValue> list, Context context)
    {
        setItemOnClickListener(list,context);
        listView.setOnItemClickListener(itemOnClickListener);
    }
    private void setItemOnClickListener(ArrayList<MainValue> list, Context context)
    {
        if(itemOnClickListener == null)
        {
            itemOnClickListener = new ItemOnClickListener(list,context);
        }
        else
        {
            itemOnClickListener.setList(list);
        }
    }
}
