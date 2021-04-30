package com.example.appmeteo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmeteo.controller.ImageController;
import com.example.appmeteo.controller.MeteoController;
import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;
import com.example.appmeteo.model.meteo.Meteo;

import java.util.UUID;

public class DetailActivity extends AppCompatActivity {

    private static String PLACE_UUID = "PLACE_UUID";
    private TextView id;
   private TextView nome;
   private TextView coordinate;
   private TextView meteoView;
   private TextView max;
   private TextView minima;
   private TextView attuale;
   private ImageView image;
   private Button goBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        goBackButton = findViewById(R.id.id_backB);

        id = findViewById(R.id.id_numeroL);
        nome = findViewById(R.id.id_nomeL);
        coordinate = findViewById(R.id.id_coordinateL);
        meteoView = findViewById(R.id.id_meteoL);
        max = findViewById(R.id.id_maxL);
        minima = findViewById(R.id.id_minL);
        attuale = findViewById(R.id.id_attualeL);
        image = findViewById(R.id.id_image);

        UUID uuid= (UUID) getIntent().getSerializableExtra(PLACE_UUID);
        Place place;
        if(uuid==null)
            place = PlacesHolder.get(getApplicationContext()).getPlaces().get(0);
        else
            place = PlacesHolder.get(getApplicationContext()).getPlaceByUUID(uuid);


        if(place.equals(PlacesHolder.get(getApplicationContext()).getPlaces().get(0)))
            MeteoController.getInstance().requestMeteoByCoordinates(place.getLocation().getLatitude(),place.getLocation().getLongitude(),getApplicationContext());




        id.setText(uuid.toString());
        Meteo meteo= place.getMeteo();
        if(meteo!=null){
            nome.setText(place.getMeteo().getName());
            String coordinateString= ""+meteo.getCoord().getLat() + " "+meteo.getCoord().getLon() ;
            coordinate.setText(coordinateString);
            meteoView.setText(meteo.getWeather()[0].getMain());
            String tmp=""+(int)(meteo.getMain().getTemp_max()-273.15)+"°";
            max.setText(tmp);
            tmp=""+(int)(meteo.getMain().getTemp_min()-273.15)+"°";
            minima.setText(tmp);
            tmp=""+(int)(meteo.getMain().getTemp()-273.15)+"°";
            attuale.setText(tmp);
            ImageController.getInstance().setImage(image,place.getMeteo().getWeather()[0].getIcon());

        } else {
            nome.setText(place.getName());
            coordinate.setText("ND");
        }



        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }


    public void startMainActivity()
    {
        Intent intent = MainActivity.newIntent(DetailActivity.this);
        startActivityForResult(intent,1);
    }


    public static Intent newIntent(Context packageContext, UUID uuid) {
        Intent intent = new Intent(packageContext, DetailActivity.class);
        intent.putExtra(PLACE_UUID, uuid);
        return intent;
    }

}
