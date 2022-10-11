package com.example.mytest1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv2 = findViewById(R.id.tv2);
        tv2.setText("这是我回给第二个活动的信息");
        Button bu2 = findViewById(R.id.bu2);

        bu2.setOnClickListener(this);

        // 取远程来的数据
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String v1 = (String) bundle.get("v1");
        tv2.setText(v1);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("v1", "这是我回给第二个活动的信息");
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}