package com.example.alarmmangertest.jobsechduler;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alarmmangertest.R;

public class JobShedulerTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_sheduler_test);
        findViewById(R.id.sechdule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleJob(view);
            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelJob(view);
            }
        });
    }
    public void scheduleJob(View v) {
        ComponentName componentName = new ComponentName(this, Job.class);
        JobInfo info = new JobInfo.Builder(123, componentName).setPeriodic(15 * 60 * 1000)
                .setRequiresCharging(false)
                .setPersisted(true)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(info);

    }

    public void cancelJob(View v) {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);

    }
}