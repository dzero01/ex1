package com.example.gewei.ex1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.Activity;

import java.util.Calendar;

public class SetTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Button button1=(Button)findViewById(R.id.btn1);//获取按钮btn1
        button1.setOnClickListener(new View.OnClickListener() {//btn1响应
            @RequiresApi(api = Build.VERSION_CODES.N)//获取api
            @Override
            public void onClick(View v) {
                Calendar calender1 = Calendar.getInstance();//初始化日期
                new DatePickerDialog(SetTime.this, new DatePickerDialog.OnDateSetListener() {//创建日期选择对话框
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(SetTime.this, year + "年" + month + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
                    }
                }
                        //设置初始日期
                        , calender1.get(Calendar.YEAR)
                        , calender1.get(Calendar.MONTH)
                        , calender1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });/////////////////////////////////////////////////////////////////////////////////////////
        Button button2=(Button)findViewById(R.id.btn2);//获取按钮btn2
        button2.setOnClickListener(new View.OnClickListener() {//btn1响应
            @RequiresApi(api = Build.VERSION_CODES.N)//获取api
            @Override
            public void onClick(View v) {
                Calendar calendar2 = Calendar.getInstance();//初始化时间
                new TimePickerDialog(SetTime.this, new TimePickerDialog.OnTimeSetListener() {//创建时间选择对话框
                    @Override
                    public void onTimeSet(TimePicker view,int hourOfDay,int minute) {
                        Toast.makeText(SetTime.this, hourOfDay + "时" + minute+ "分", Toast.LENGTH_SHORT).show();
                    }
                }
                        //设置初始时间
                        , calendar2.get(Calendar.HOUR_OF_DAY)
                        , calendar2.get(Calendar.MINUTE)
                        , true).show();//24小时制
            }
        });
        Button button3=(Button)findViewById(R.id.btn3);//取消按钮
        button3.setOnClickListener(new View.OnClickListener() {//btn2响应
            @RequiresApi(api = Build.VERSION_CODES.N)//获取api
            @Override
            public void onClick(View v) {
                Toast.makeText(SetTime.this,"取消",Toast.LENGTH_SHORT).show();
            }
        });
        Button button4=(Button)findViewById(R.id.btn4);//确定按钮
        button4.setOnClickListener(new View.OnClickListener() {//btn2响应
            @RequiresApi(api = Build.VERSION_CODES.N)//获取api
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent1);
                Toast.makeText(SetTime.this,"你设置了提醒时间",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
