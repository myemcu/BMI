package com.example.administrator.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    float bmi;
    String str;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //--------------------------------------------------------------

        Bundle bag = this.getIntent().getExtras();        // 取得Intent包

        bmi=bag.getFloat(getString(R.string.result_bmi), 0);                // 取浮点数
        str=bag.getString(getString(R.string.message), null);              // 取字符串

        //--------------------------------------------------------------

        txt=(TextView) findViewById(R.id.result);         // 获取文本
        txt.setText("亲的BMI值为:"+bmi+"。");              // 显示文本

        txt=(TextView) findViewById(R.id.str);            // 获取文本
        txt.setText(str);                                 // 显示文本
    }
}
