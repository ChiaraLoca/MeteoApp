package com.example.appmeteo.model;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

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
        if(temp<3+KELVIN){
            Log.i("Temp", "FREDDO FOTTUTO");
            NotificationController.getInstance().tempNotification(getApplicationContext(), "Freezing temperature: ", temp-KELVIN);
        } else if(temp>30+ KELVIN){
            Log.i("Temp", "CALDO FOTTUTO");
            NotificationController.getInstance().tempNotification(getApplicationContext(), "Scolding temperature: ", temp-KELVIN);

        }
        return Result.success();
    }
}
