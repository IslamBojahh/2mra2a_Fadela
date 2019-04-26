package com.woman.orcas.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

/**
 * Created by ORCAS_ISLAM on 1/30/2018.
 */


public class AlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "com.singhajit.notificationDemo.channelId";
    Intent notificationIntent;


    PendingIntent pendingIntent;
    Notification notification;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {






        String b = intent.getStringExtra("aya");
        String s=intent.getStringExtra("name");


        notificationIntent = new Intent(context, com.woman.orcas.myapplication.NotificationActivity.class);
        notificationIntent.putExtra("aya", b);
        notificationIntent.putExtra("name",s);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(com.woman.orcas.myapplication.NotificationActivity.class);
        stackBuilder.addNextIntent(notificationIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);

        Notification notification = builder.setContentTitle(s)
                .setContentText(b)
                .setTicker("New Message Alert!")
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent).build();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "NotificationDemo",
                    IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0, notification);

    }


}
