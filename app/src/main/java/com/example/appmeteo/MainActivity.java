package com.example.appmeteo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.appmeteo.controller.GPSController;
import com.example.appmeteo.fragments.placesList.PlacesListFragment;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

public class MainActivity extends SingleFragmentActivity {

    private GPSController gpsController;
    @Override
    protected Fragment createFragment() {
        gpsController=GPSController.getInstance();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.i("PER", "Permission not granted");
            requestPermissions();
        } else {
            Log.i("PER", "Permission granted");
            gpsController.startLocationListener(getApplicationContext());
        }
        return new PlacesListFragment();
    }


    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        } else {
            gpsController.startLocationListener(getApplicationContext());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    gpsController.startLocationListener(getApplicationContext());
                return;
            }
        }
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }
}