package com.rynfar.toast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        show();
    }

    private void show() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"直接输出",Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //获取一个View对象
                View view=li.inflate(R.layout.toastinfo,null);
                Toast toast=new Toast(MainActivity.this);
                toast.setView(view);
                toast.show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.创建Toast
                Toast toast=Toast.makeText(MainActivity.this,"图文显示",Toast.LENGTH_LONG);
                //2.创建Layout,并设置为水平布局
                LinearLayout mLayout=new LinearLayout(MainActivity.this);
                mLayout.setOrientation(LinearLayout.VERTICAL);
                ImageView mImage=new ImageView(MainActivity.this); //创建显示图像的ImageView
                mImage.setImageResource(R.mipmap.ic_launcher);
                View toastView=toast.getView(); //获取显示文字的Toast View
                mLayout.addView(mImage); //将图片添加到Layout
                mLayout.addView(toastView);
                //3.设置Toast显示的View,参数为上面生成的Layout
                toast.setView(mLayout);
                toast.show();

            }
        });
    }

    private void init() {
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
    }
}
