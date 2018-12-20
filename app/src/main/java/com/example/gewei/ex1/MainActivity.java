package com.example.gewei.ex1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0=(Button)findViewById(R.id.btn_set);
        button0.setOnClickListener(new View.OnClickListener() {//button0响应
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,SetTime.class);//(上下文，目标活动)
                startActivityForResult(intent1,1);//(intent,请求码判断数据来源)
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("MainActivity", returnedData);
                }
                break;
            default:
        }
    }
}
