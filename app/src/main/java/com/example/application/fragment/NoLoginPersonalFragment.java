package com.example.application.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.application.PersonalCenterOption;
import com.example.application.R;
import com.example.application.adapter.RecycleLinearAdapter;
import com.example.application.widget.SpacesDecoration;

import java.util.ArrayList;
import java.util.List;

public class NoLoginPersonalFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    protected View mView;
    protected AppCompatActivity mActivity;

    public NoLoginPersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_no_login_personal, container, false);
        mActivity = (AppCompatActivity) getActivity();
        RecyclerView non_login_linear= mView.findViewById(R.id.non_login_linear);
        LinearLayoutManager manager=new LinearLayoutManager(mActivity,RecyclerView.VERTICAL,false);

        non_login_linear.setLayoutManager(manager);

        List<PersonalCenterOption> list=new ArrayList<PersonalCenterOption>();

        list.add(new PersonalCenterOption("个人信息",R.drawable.info,0));

        list.add(new PersonalCenterOption("历史订单",R.drawable.history,1));
        list.add(new PersonalCenterOption("设置",R.drawable.setting,2));

        RecycleLinearAdapter adapter =new RecycleLinearAdapter(mActivity,list);
        non_login_linear.setAdapter(adapter);

        non_login_linear.addItemDecoration(new SpacesDecoration(1));  // 设置循环视图的空白装饰
        return mView;
    }
}