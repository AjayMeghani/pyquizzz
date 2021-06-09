package com.example.pyquizizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
  TextView tv;
  int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String score = intent.getStringExtra(MainActivity.EXTRA_score);
        tv = findViewById(R.id.tv);
        String  ha= intent.getStringExtra("About");


        tv.setText("your score is "+score +"/"+ha);
    }
}