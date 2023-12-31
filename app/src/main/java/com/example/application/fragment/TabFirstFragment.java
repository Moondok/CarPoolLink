package com.example.application.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.application.LocationActivity;
import com.example.application.R;

public class TabFirstFragment extends Fragment {
    private static final String TAG = "TabFirstFragment";
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_tab_first.xml生成视图对象
        mView = inflater.inflate(R.layout.fragment_tab_first, container, false);
        TextView tv_first = mView.findViewById(R.id.tv_first);
        tv_first.setText("我是首页页面");

        Button main_button=mView.findViewById(R.id.main_button);
        main_button.setOnClickListener(view->{
            Intent intent= new Intent(getActivity(), LocationActivity.class);
            startActivity(intent);
        });

        return mView;
    }

}