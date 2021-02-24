package com.example.notificationalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    private int notificationId=1;
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"Alert")
                .setContentText("Appointment Alert")
                .setContentText("Your appointment is fixed")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);

        //to get notification from api level 26 and above
        notificationManagerCompat.notify(notificationId,builder.build());

    }
}
