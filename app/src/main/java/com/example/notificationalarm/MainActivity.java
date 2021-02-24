package com.example.notificationalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button notificationbtn,cancelbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotification();

        notificationbtn=findViewById(R.id.notificationbtn);
//        cancelbtn=findViewById(R.id.cancelbtn);
        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Reminder Set",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,ReminderBroadcast.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);

                AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick=System.currentTimeMillis();

                long tenSecondsInMills=1000*10;

                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick + tenSecondsInMills,pendingIntent);

            }
        });
    }

    private void createNotification(){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            CharSequence name="PatientReminderChannel";
            String description="Channel for patient reminder";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel=new NotificationChannel("Alert",name,importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
