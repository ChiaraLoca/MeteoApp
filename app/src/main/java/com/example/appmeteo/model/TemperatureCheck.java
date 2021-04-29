package com.example.appmeteo.model;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.appmeteo.R;
import com.example.appmeteo.controller.NotificationController;

public class TemperatureCheck extends Worker {
    private static final double KELVIN = 273.15;
    public TemperatureCheck(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Place here=PlacesHolder.get(getApplicationContext()).getPlaces().get(0);
        double temp=here.getMeteo().getMain().getTemp();
        if(temp<30+KELVIN){
            Log.i("Temp", "FREDDO");
            NotificationController.getInstance().tempNotification(getApplicationContext(), getApplicationContext().getResources().getString(R.string.freezing_temp), temp-KELVIN);
        } else if(temp>35+ KELVIN){
            Log.i("Temp", "CALDO");
            NotificationController.getInstance().tempNotification(getApplicationContext(), getApplicationContext().getResources().getString(R.string.freezing_temp), temp-KELVIN);

        }
        return Result.success();
    }
}
