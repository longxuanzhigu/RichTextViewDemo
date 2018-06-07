package com.showly.richtextviewdemo;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.showly.richtextviewdemo.util.CenterAlignImageSpan;
import com.showly.richtextviewdemo.util.ImageTextUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private TextView textOne;
    private TextView textTwo;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

        content = "“我最糟糕的时刻，就是我希望自己当初能与那个年轻人（科比-布莱恩特）有更好的沟通，”奥尼尔说道，“因为人们常说，如果我们俩没有分开，我们可能可以一起得到6、7个冠军。看着勒布朗（詹姆斯）过去7年做到的事情，我也常对自己说，如果我们当初能够解决好，我们可能会得到6、7个甚至8个冠军";

    }

    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn_one);
        btn2 = (Button) findViewById(R.id.btn_two);
        textOne = (TextView) findViewById(R.id.tv_text);
        textTwo = (TextView) findViewById(R.id.tv_text_another);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                setTextView();//富文本静态图
                break;
            case R.id.btn_two://gif动态图
                String html = "<img src=\"file:///android_asset/i8live_activity_jing.gif\">" + content;
                ImageTextUtil.setImageText(textTwo, html);
                break;
            default:

                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setTextView() {
        SpannableString sp = new SpannableString(content);
        //获取一张图片
        Drawable drawable = getDrawable(R.drawable.i8live_activity_jing);
        drawable.setBounds(0, 0, 20, 20);//设置展示图片的大小
        //drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//设置展示图片的大小

        //居中对齐imageSpan
        CenterAlignImageSpan imageSpan = new CenterAlignImageSpan(drawable);
        sp.setSpan(imageSpan, 0, 1, ImageSpan.ALIGN_BASELINE);//0,1表示展示图片的起始位置
        textOne.setText(sp);
    }
}
