package com.feidian.george.hzaumooc.Adapter.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.feidian.george.hzaumooc.Bmob.Bean.MainValue;
import com.feidian.george.hzaumooc.Interface.Main.GetValued;
import com.feidian.george.hzaumooc.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/14.
 */
public class ListAdapter extends BaseAdapter{
    private List<?> list;
    private Context context;
    private LayoutInflater layoutInflater;
    public ListAdapter(Context context, List<?> arrayList)
    {
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
        list=arrayList;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if( convertView == null )
        {
            convertView = layoutInflater.inflate(R.layout.a_main_r_listview_item , parent ,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(((GetValued)list.get(position)).getValued_class_Image()).error(R.mipmap.ic_launcher).into(holder.cover);
        holder.author.setText(((GetValued)list.get(position)).getValued_class_teacher());
        holder.name.setText(((GetValued)list.get(position)).getValued_class_name());
        return convertView;
    }
    class ViewHolder {

        @Bind(R.id.main_rl_item_image)
        ImageView cover;
        @Bind(R.id.main_rl_item_class_name)
        TextView name;
        @Bind(R.id.main_rl_item_author) TextView author;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
