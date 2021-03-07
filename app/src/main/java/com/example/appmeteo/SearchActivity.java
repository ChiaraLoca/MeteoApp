package com.example.appmeteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();

        goBackButton = findViewById(R.id.goBack);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
    }

    public void startMainActivity()
    {
        //Intent intent = MainActivity.newIntent(SearchActivity.this);
        //startActivityForResult(intent,1);
    }


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, SearchActivity.class);
        //intent.putExtra(EXTRA_KEY, extraParam);
        return intent;
    }

}