package com.flashapps.androidbubblepickerdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.flashapps.androidbubblepickerdemo.R;


public class MainActivity extends AppCompatActivity {

    Button btnJava,btnKotlin;


    public void openJavaDemo(){
        Intent intent = new Intent(MainActivity.this, JavaDemoActivity.class);
        startActivity(intent);
    }

    public void openKotlinDemo(){
        Intent intent = new Intent(MainActivity.this,DemoActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJava = (Button)findViewById(R.id.btn_java);
        btnKotlin = (Button)findViewById(R.id.btn_kotlin);

        btnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJavaDemo();
            }
        });

        btnKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKotlinDemo();
            }
        });

    }
}
