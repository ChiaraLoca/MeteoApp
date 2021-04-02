package com.example.appmeteo.controller;

import android.content.Context;
import android.service.controls.Control;

import androidx.annotation.NonNull;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.appmeteo.model.TemperatureCheck;

import java.util.concurrent.TimeUnit;

public class TemperatureCheckController  {
    private static TemperatureCheckController instance=null;
    public static TemperatureCheckController getInstance(){
        if(instance==null){
            instance=new TemperatureCheckController();
        }
        return instance;
    }

    private TemperatureCheckController() {
    }

    public void startCheck(Context context){
        PeriodicWorkRequest workRequest= new PeriodicWorkRequest.Builder(TemperatureCheck.class, 15, TimeUnit.MINUTES).build();
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("TEMPCHECK", ExistingPeriodicWorkPolicy.REPLACE, workRequest);
    }
}
