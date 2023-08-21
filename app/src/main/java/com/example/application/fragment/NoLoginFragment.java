package com.example.application.fragment;

import android.os.Bundle;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.application.R;

public class NoLoginFragment extends Fragment {

    private static final String TAG="NoLoginFragment";
    protected View mView;
    protected Context mContext;

    protected AppCompatActivity mActivity; // 声明一个活动对象
    public NoLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_no_login, container, false);

        Toolbar tl_head = mView.findViewById(R.id.toolbar_head);
        tl_head.setTitle("CarPoolLink"); // 设置工具栏的标题文字


        mActivity=(AppCompatActivity)getActivity();
        mActivity.setSupportActionBar(tl_head); // 使用tl_head替换系统自带的ActionBar
        TextView no_login_text=mView.findViewById(R.id.no_login_text);

        return mView;
    }
}