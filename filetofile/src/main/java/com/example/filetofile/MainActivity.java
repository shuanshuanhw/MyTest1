package com.example.filetofile;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 外部存储的私有空间
                String path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
                path = path + File.separator+System.currentTimeMillis()+".txt";
                Log.d("path", "onClick: "+path);
                FileUtils.writeFile(path,"shuanshuan,huangwei");

                String content = FileUtils.readFile(path);
                Log.d("content",content);
                TextView textView = findViewById(R.id.tv);
                textView.setText(content);
                // 外部存储的公共空间
                String pathPublic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
            }
        });
    }
}