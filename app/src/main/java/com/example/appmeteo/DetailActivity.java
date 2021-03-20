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

import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;

import java.util.UUID;

public class DetailActivity extends AppCompatActivity {

    private static String PLACE_UUID = "PLACE_UUID";
    private TextView id;
   private TextView nome;
   private TextView coordinate;
   private TextView meteo;
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
        meteo = findViewById(R.id.id_meteoL);
        max = findViewById(R.id.id_maxL);
        minima = findViewById(R.id.id_minL);
        attuale = findViewById(R.id.id_attualeL);
        image = findViewById(R.id.id_image);

        UUID uuid= (UUID) getIntent().getSerializableExtra(PLACE_UUID);
        Place place= PlacesHolder.get(getApplicationContext()).getPlaceByUUID(uuid);
        id.setText(uuid.toString());
        nome.setText(place.getName());
        Location location= place.getLocation();
        if(location!=null){
            String coordinateString= ""+location.getLatitude() + " "+location.getLongitude();
            coordinate.setText(coordinateString);
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
}
