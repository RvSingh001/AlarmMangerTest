package com.example.alarmmangertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class WorkMangerExample extends AppCompatActivity {

    Button one,perodic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manger_example);
        one=findViewById(R.id.btn);
        perodic=findViewById(R.id.btn1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneTimeTask();
            }
        });
        perodic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perodicTask();
            }
        });



    }
    public void oneTimeTask()
    {
        OneTimeWorkRequest uploadWorkRequest =
                new OneTimeWorkRequest.Builder(Work.class)
                        .build();

        OneTimeWorkRequest uploadWorkRequest1=
                new OneTimeWorkRequest.Builder(Work1.class)
                        .build();

        WorkManager.getInstance(getApplicationContext()).beginWith(uploadWorkRequest).then(uploadWorkRequest1).
                enqueue();


    }
    public void perodicTask()
    {
        PeriodicWorkRequest uploadWorkRequest =
                new PeriodicWorkRequest.Builder(Work.class,1, TimeUnit.MINUTES)
                        .build();

        WorkManager.getInstance(getApplicationContext())
                .enqueue(uploadWorkRequest);
    }
}