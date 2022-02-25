package com.example.alarmmangertest.workmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alarmmangertest.R;

import java.util.concurrent.TimeUnit;

public class WorkMangerExample extends AppCompatActivity {

    Button one, perodic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manger_example);
        one = findViewById(R.id.btn);
        perodic = findViewById(R.id.btn1);
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

    public void oneTimeTask() {
        OneTimeWorkRequest oneTimeWorkRequest =
                new OneTimeWorkRequest.Builder(Work.class)
                        .build();

        OneTimeWorkRequest oneTimeWorkRequest1 =
                new OneTimeWorkRequest.Builder(Work1.class)
                        .build();

        WorkManager.getInstance(getApplicationContext()).beginWith(oneTimeWorkRequest).
                then(oneTimeWorkRequest1).
                enqueue();


    }

    public void perodicTask() {
        final PeriodicWorkRequest periodicWorkRequest =
                new PeriodicWorkRequest.Builder(Work.class, 15, TimeUnit.MINUTES)
                        .setInitialDelay(6000,TimeUnit.MILLISECONDS)
                        .build();

        WorkManager workManager = WorkManager.getInstance(getApplicationContext());
        workManager.enqueue(periodicWorkRequest);
    }
}