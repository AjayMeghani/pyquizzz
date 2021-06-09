package com.example.pyquizizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String [] que ={"Python is an interpreted language.\n","Python determines the beginning and end of a statement based on whitespace","Python has three high-level data structures: lists, dictionaries and hashes.",
            "Tuples are immutable data types; lists are mutable data types.\n","List method append adds an element to the end of the list.\n","Dictionary values must be immutable data types.\n",
    "Python supports multiple programming paradigms"};
    private final boolean[] answer={true, true ,false , true, true,false,true};
    int score =0;
    private int index = 0;
    Button b1, b2,result;
    TextView questions;
    public static final String EXTRA_score = "com.example.pyquizizz.SCORE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        questions= findViewById(R.id.questions);
        questions.setText(que[index]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=que.length-1) {
                    if (answer[index]) {
                        score++;
                    }
                    index++;
                    if (index <= que.length-1) {
                        questions.setText(que[index]);
                    }
//                    else {
//                        Toast.makeText(MainActivity.this, "your score is " + score + "/" + que.length, Toast.LENGTH_SHORT).show();
////                    }
                }
                else {
//                    Toast.makeText(MainActivity.this, "Restart the app for playing again", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Click Result button for quizz score", Toast.LENGTH_SHORT).show();
                }
            }


        });
        b2.setOnClickListener(v -> {
            if(index<=que.length-1){
                if (!answer[index]){
                    score++;
                }
                index++;
                if(index<=que.length-1){
                    questions.setText(que[index]);
                }
//                else {
//                    Toast.makeText(MainActivity.this, "your score is " + score + "/" + que.length, Toast.LENGTH_SHORT).show();
//                }
            }
            else {

//                    Toast.makeText(MainActivity.this, "Restart the app for playing again", Toast.LENGTH_SHORT).show();
                     Toast.makeText(MainActivity.this, "Click Result button for quizz score", Toast.LENGTH_SHORT).show();
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>=que.length){
                    Toast.makeText(MainActivity.this, "Result is opening", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                    String  result1 = Integer.toString(score);
                    int l= que.length;
                    String  length = Integer.toString(l);
                    intent.putExtra("About",length);
                    intent.putExtra(EXTRA_score,result1);
//                    String l = intent.getStringExtra("length");

                    startActivity(intent);


                }

            }
        });


    }}
