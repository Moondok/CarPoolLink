package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.example.application.TabPagerActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 关联layout文件夹中对应的xml文件

//        button=findViewById(R.id.button);
//        button.setOnClickListener(view->{
//            button.setText("changed!");
//        });

        button2=findViewById((R.id.button));
        button2.setOnClickListener(view->{
            Intent intent =new Intent(this, TabPagerActivity.class);

            startActivity(intent);

        });

        if(MainApplication.getInstance().isLogin==false){
            Toast.makeText(this, "您尚未登录", Toast.LENGTH_SHORT).show();
        }

    }
}