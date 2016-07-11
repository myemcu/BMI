package com.example.administrator.bmi;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Ctrl+Alt+F(提升局部变量为类属性)(这样即使在onCreate()外也能使用)
    private EditText weight;
    private EditText height;
    private Button bAbout;  // 若有淡黄色底纹，则表示该变量仅作了定义但未被使用
    private Toast toast;

    // 通过Ctrl+Alt+M实现的方法抽取
    private void findViews() {
        weight = (EditText) findViewById(R.id.yourWeight);
        height = (EditText) findViewById(R.id.yourHeight);
        bAbout = (Button) findViewById(R.id.btn2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 获取两个编辑框和最后一个按钮对象
        findViews();

        // 括号中的匿名类手码为new On才能出现补全提示
        bAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("亲的BMI值")
                        .setMessage("体重(Kg)/身高的平方(M)")
                        .setPositiveButton("确定", null)
                        .show();
            }
        });
    }

    // 对应于xml中onClick方法名btn_Click所实现的方法，该方法的功能是实现Bmi值的计算
    public void btn_Click(View v) {
        // 调用EditText的getText()方法取得编辑框对象,再调用toString()方法取得编辑框内的字符串
        // 即该过程为单纯获取字符串输入信息
        String w = weight.getText().toString(); // 获取体重(整数Kg)
        String h = height.getText().toString(); // 获取身高(小数X.xx)
        // 将字符串转为Float类型
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);

        float bmi = weight / (height*height);

        //之前要输入体重与身高参数
        Intent intent = new Intent(this, ResultActivity.class);     // 构建意图

        //光标旋停，按Alt+Enter抽取待传递的字符串
        Bundle bag = new Bundle();                                  // 构建空包

        //抽取前(相应的收方Activity的也要改)
        //bag.putFloat("BMI结果",bmi);                                 // bmi入包
        //bag.putString("传送信息","哥是MainActivity传来的数据包。");    // 信息入包

        bag.putFloat(getString(R.string.result_bmi),bmi);                                 // bmi入包
        bag.putString(getString(R.string.message), getString(R.string.str));    // 信息入包

        intent.putExtras(bag);                                      // 开始打包

        startActivity(intent);                                      // 发送意图
    }
}
