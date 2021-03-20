package com.example.appmeteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmeteo.model.PlacesHolder;

public class SearchActivity extends AppCompatActivity {

    private Button goBackButton;
    private TextView searchText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();
        searchText=findViewById(R.id.searchText);
        goBackButton = findViewById(R.id.id_goBackB);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
        searchText.setOnEditorActionListener((v, actionId, event) -> {
            if(actionId==EditorInfo.IME_ACTION_DONE){
                /*Toast toast=Toast.makeText(getApplicationContext(), searchText.getText(), Toast.LENGTH_LONG);
                toast.show();*/
                requestLocation(searchText.getText());
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                //TODO è ROBA STRANA
                return true;
            }
            return false;
        });
    }

    private void requestLocation(CharSequence text) {
        PlacesHolder.get(getApplicationContext()).addPlace(text.toString(), null);
    }

    public void startMainActivity()
    {
        Intent intent = MainActivity.newIntent(SearchActivity.this);
        startActivityForResult(intent,1);
    }


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, SearchActivity.class);
        return intent;
    }

}