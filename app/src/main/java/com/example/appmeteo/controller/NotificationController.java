package com.example.appmeteo.controller;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.appmeteo.DetailActivity;
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
        //NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManagerCompat notificationManager= NotificationManagerCompat.from(context);
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context, "default")
                .setContentTitle("Temperature alert")
                .setContentText(""+msg+temp)
                .setSmallIcon(R.drawable.image10d)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, DetailActivity.newIntent(context, PlacesHolder.get(context).getPlaces().get(0).getUuid()), 0));
        notificationManager.notify(0, builder.build());
    }
}
