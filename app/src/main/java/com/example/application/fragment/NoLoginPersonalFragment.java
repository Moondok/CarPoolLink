package com.example.application.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.application.LoginActivity;
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

    private int option=0 ;//决定登录时选中的是乘客登录还是车主登录

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

        list.add(new PersonalCenterOption("个人信息",R.drawable.info1,10));

        list.add(new PersonalCenterOption("历史订单",R.drawable.history1,1));
        list.add(new PersonalCenterOption("设置",R.drawable.setting1,2));

        RecycleLinearAdapter adapter =new RecycleLinearAdapter(mActivity,list);
        non_login_linear.setAdapter(adapter);

        non_login_linear.addItemDecoration(new SpacesDecoration(2));  // 设置循环视图的空白装饰

        Button login_button=mView.findViewById(R.id.login_button);


        login_button.setOnClickListener(view->{

            final String items[] = {"我是乘客", "我是车主"};

            AlertDialog.Builder dialog_builder = new AlertDialog.Builder(mActivity);
            dialog_builder.setIcon(R.drawable.dialog1);//设置标题的图片
            dialog_builder.setTitle("单选列表对话框");//设置对话框的标题
            dialog_builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        option=which;
                        Toast.makeText(mActivity, items[which], Toast.LENGTH_SHORT).show();
                    }
                });
            dialog_builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        option=0;
                        dialog.dismiss();
                    }
                });
            dialog_builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println(which);
                        if (option == 0) {

                            Intent intent = new Intent(mActivity, LoginActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("type", which);

                            intent.putExtras(bundle);
                            startActivity(intent);
                            // Toast.makeText(mActivity, items[which], Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(mActivity, items[option], Toast.LENGTH_SHORT).show();}
                            dialog.dismiss();
                        }
                });
            dialog_builder.create().show();
        });


        return mView;
    }
}