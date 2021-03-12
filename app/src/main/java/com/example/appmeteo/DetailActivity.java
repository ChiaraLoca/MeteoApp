package com.example.appmeteo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmeteo.model.Place;

import java.util.UUID;

public class DetailActivity extends AppCompatActivity {

    private static String PLACE;
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


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, DetailActivity.class);
        return intent;
    }
}
