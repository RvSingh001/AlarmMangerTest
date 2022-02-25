package com.example.alarmmangertest.backgroud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alarmmangertest.R;
import com.example.alarmmangertest.alarm.MainActivity;
import com.example.alarmmangertest.jobsechduler.JobShedulerTest;
import com.example.alarmmangertest.workmanger.WorkMangerExample;

public class BackgroudTask extends AppCompatActivity {

    Button am,wm,js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backgroud_task);
        findViewById(R.id.alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        findViewById(R.id.work).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WorkMangerExample.class));
            }
        });
        findViewById(R.id.JobSechduler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), JobShedulerTest.class));
            }
        });
    }
}