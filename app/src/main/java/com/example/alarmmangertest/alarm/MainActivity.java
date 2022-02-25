package com.example.alarmmangertest.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alarmmangertest.R;

public class MainActivity extends AppCompatActivity {
    private EditText ed1;
    private Button btn;
    private int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.getMinute);
        btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ed1.getText().toString().matches("")) {
                    time=Integer.parseInt(ed1.getText().toString().trim());
                    activeAlarm(time);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Value",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

        public void activeAlarm(int time)
        {

            Intent intent=new Intent(getApplicationContext(),Alrm.class);
            AlarmManager alarmManager= (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);
            PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),0, intent,0);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(),
                    1000*60,
                    pendingIntent);
            Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
            //activeAlarm(time);
        }



}