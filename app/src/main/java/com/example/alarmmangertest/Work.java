package com.example.alarmmangertest;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class Work extends Worker {
    public Work(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            getApplicationContext().getMainExecutor()
                    .execute(()->
                            Toast.makeText(getApplicationContext(),"success work1",Toast.LENGTH_LONG).show());

            return Result.success();
        }catch (Throwable throwable)
        {
            getApplicationContext().getMainExecutor()
                    .execute(()->
                            Toast.makeText(getApplicationContext(),"failure work1",Toast.LENGTH_LONG).show());
            return Result.failure();
        }



    }

}
