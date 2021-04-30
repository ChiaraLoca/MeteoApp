package com.example.appmeteo.controller;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.appmeteo.DetailActivity;
import com.example.appmeteo.MainActivity;
import com.example.appmeteo.R;
import com.example.appmeteo.model.PlacesHolder;

public class NotificationController {
    private static NotificationController instance= null;

    public static NotificationController getInstance() {
        if(instance==null)
            instance= new NotificationController();
        return instance;
    }

    private NotificationController() {

    }
    public void tempNotification(Context context,String msg, double temp){
        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "TEST_CHANNEL", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Test Channel Description");
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context, "default")
                .setContentTitle(context.getResources().getString(R.string.temp_al))
                .setContentText(""+msg+temp)
                .setSmallIcon(R.drawable.image10d)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, MainActivity.newIntent(context), 0));
        notificationManager.notify(0, builder.build());
    }
}
