package com.example.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;

public class MainApplication extends Application {
    private static MainApplication mApp;

    //public HashMap<String ,String> mInfoMap =new HashMap<String, String>();
    public Boolean isLogin=false;//登陆状态
    public Integer type=0; //decide passenger or driver
    public String userName=""; //用户名
    public String password="";//密码
    public String phoneNum="";//手机号

    public static MainApplication getInstance(){
        return mApp;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mApp=this;
        SharedPreferences shared=getSharedPreferences("share_login",MODE_PRIVATE);
        Boolean isAutoLogin=shared.getBoolean("isAutoLogin",false);
        if(isAutoLogin) {
            this.isLogin = true;// if autoLogin is true , we set login state is true
            this.type = shared.getInt("type", 0);
            this.userName = shared.getString("userName", "");
            this.password = shared.getString("password", "");
            this.phoneNum = shared.getString("phoneNum", "");
        }
        //Toast.makeText(mApp, "", Toast.LENGTH_SHORT).show();
    }

}
