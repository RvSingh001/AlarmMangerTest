package com.example.alarmmangertest.jobsechduler;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

@SuppressLint("SpecifyJobSchedulerIdRange")
public class Job extends JobService  {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        getApplicationContext().getMainExecutor()
                .execute(()->
                        Toast.makeText(getApplicationContext(),"Job Started",Toast.LENGTH_LONG).show());

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        getApplicationContext().getMainExecutor()
                .execute(()->
                        Toast.makeText(getApplicationContext(),"Job Stop",Toast.LENGTH_LONG).show());

        return true;
    }
}
