package com.example.appmeteo;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        Place place= PlacesHolder.get(getApplicationContext()).getPlaceByUUID(uuid);
        //TODO qui mettiamo la chiamata alla API
        place.updateMeteo(testString);
        id.setText(uuid.toString());
        Meteo meteo= place.getMeteo();
        if(meteo!=null){
            nome.setText(place.getMeteo().getName());
            String coordinateString= ""+meteo.getCoord().getLat() + " "+meteo.getCoord().getLon() ;
            coordinate.setText(coordinateString);
            meteoView.setText(meteo.getWeather()[0].getMain());
            String tmp=""+meteo.getMain().getTemp_max();
            max.setText(tmp);
            tmp=""+meteo.getMain().getTemp_min();
            minima.setText(tmp);
            tmp=""+meteo.getMain().getTemp();
            attuale.setText(tmp);
            //TODO link img
        } else {
            nome.setText(place.getName());
            coordinate.setText("ND");
        }
        //TODO legare coordinate



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
    String test1= "{\"coord\": { \"lon\": 139,\"lat\": 35}}";
    String testString= "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
            "     \"weather\": [\n" +
            "       {\n" +
            "         \"id\": 800,\n" +
            "         \"main\": \"Clear\",\n" +
            "         \"description\": \"clear sky\",\n" +
            "         \"icon\": \"01n\"\n" +
            "       }\n" +
            "     ],\n" +
            "     \"base\": \"stations\",\n" +
            "     \"main\": {\n" +
            "       \"temp\": 281.52,\n" +
            "       \"feels_like\": 278.99,\n" +
            "       \"temp_min\": 280.15,\n" +
            "       \"temp_max\": 283.71,\n" +
            "       \"pressure\": 1016,\n" +
            "       \"humidity\": 93\n" +
            "     },\n" +
            "     \"wind\": {\n" +
            "       \"speed\": 0.47,\n" +
            "       \"deg\": 107.538\n" +
            "     },\n" +
            "     \"clouds\": {\n" +
            "       \"all\": 2\n" +
            "     },\n" +
            "     \"dt\": 1560350192,\n" +
            "     \"sys\": {\n" +
            "       \"type\": 3,\n" +
            "       \"id\": 2019346,\n" +
            "       \"message\": 0.0065,\n" +
            "       \"country\": \"JP\",\n" +
            "       \"sunrise\": 1560281377,\n" +
            "       \"sunset\": 1560333478\n" +
            "     },\n" +
            "     \"timezone\": 32400,\n" +
            "     \"id\": 1851632,\n" +
            "     \"name\": \"Shuzenji\",\n" +
            "     \"cod\": 200\n" +
            "     }";
}
