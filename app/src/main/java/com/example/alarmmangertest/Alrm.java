package com.example.alarmmangertest;

import static android.content.Context.ALARM_SERVICE;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;

import java.security.Provider;

public class Alrm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context.getApplicationContext(), "This is a AlarmManger Example", Toast.LENGTH_LONG).show();

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

            AlarmManager alarmManager= (AlarmManager) context.getApplicationContext().getSystemService(ALARM_SERVICE);
            PendingIntent pendingIntent=PendingIntent.getBroadcast(context.getApplicationContext(),
                    0, new Intent(context.getApplicationContext(),Alrm.class),0);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),
                  1000*60,
                  pendingIntent);
            Toast.makeText(context,"Alarm Set After Boot",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context.getApplicationContext(), "Else Part", Toast.LENGTH_LONG).show();

            //Toast.makeText(context.getApplicationContext(),String.valueOf(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")),Toast.LENGTH_LONG).show();
        }

    }


}
