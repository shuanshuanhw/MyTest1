package com.example.mytest1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv1;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.tv1);
     //   tv1.setText("这是我要发给第二个活动的信息");
        Button bu1 = findViewById(R.id.bu1);
        bu1.setOnClickListener(this);


        intent = new Intent(MainActivity.this,MainActivity2.class);
        Bundle bundle = new Bundle();
        bundle.putString("v1", (String) tv1.getText());
        intent.putExtras(bundle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        String v1 = bundle.getString("v1");
        System.out.println(v1+requestCode+resultCode);
        Log.e("111",v1);
        Log.e("111", String.valueOf(requestCode));
        Log.e("111", String.valueOf(resultCode));
        tv1.setText(v1);
        
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bu1)
        {
            startActivityForResult(intent, 2);
        }
    }
}