package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar tl_head = findViewById(R.id.toolbar_head);
        tl_head.setTitle("登录页"); // 设置工具栏的标题文字

        setSupportActionBar(tl_head); 
    }
}