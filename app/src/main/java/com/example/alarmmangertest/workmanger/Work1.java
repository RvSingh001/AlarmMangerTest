package com.example.alarmmangertest.workmanger;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class Work1 extends Worker {
    public Work1(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            getApplicationContext().getMainExecutor()
                    .execute(()->
                            Toast.makeText(getApplicationContext(),"success work2",Toast.LENGTH_LONG).show());

            return Result.success();
        }catch (Throwable throwable)
        {
            getApplicationContext().getMainExecutor()
                    .execute(()-> {
                        Toast.makeText(getApplicationContext(), "failure work2", Toast.LENGTH_LONG).show();
                    });
            return Result.failure();
        }



    }

}