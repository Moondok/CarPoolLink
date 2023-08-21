package com.example.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.application.PersonalCenterOption;
import com.example.application.R;

import java.util.List;

public class RecycleLinearAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final static String TAG="RecyclerLinearAdapter";
    private Context mContext; //上下文对象
    private List<PersonalCenterOption> mOptionList;

    public RecycleLinearAdapter(Context context, List<PersonalCenterOption> optionList){
        mContext=context;
        mOptionList=optionList;
    }

    public int getItemCount(){
        return mOptionList.size();
    }

    //创建视图所有者
    public ViewHolder onCreateViewHolder(ViewGroup vg,int viewType){
        View v= LayoutInflater.from(mContext).inflate(R.layout.personal_option_linear,vg,false);
        return new ItemHolder(v) ;
    }

    public void onBindViewHolder(ViewHolder vh, final int position) {
        ItemHolder holder = (ItemHolder) vh;
        holder.iv_pic.setImageResource(mOptionList.get(position).logoRoute);
        holder.tv_name.setText(mOptionList.get(position).optionName);
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView iv_pic;
        public TextView tv_name;

        public ItemHolder(View v){
            super(v);
            iv_pic=v.findViewById(R.id.iv_pic);
            tv_name=v.findViewById(R.id.tv_name);
        }

    }
}
