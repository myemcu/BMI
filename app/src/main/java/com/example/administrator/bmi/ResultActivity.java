package com.example.administrator.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    float bmi;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();                    // 接收意图
        bmi = intent.getFloatExtra("Result_BMI", 0);    // 解析数据，0为无解析数据的默认值

        txt=(TextView) findViewById(R.id.result);       // 获取文本
        txt.setText("亲的BMI值为:"+bmi+"。");            // 显示文本
    }
}
