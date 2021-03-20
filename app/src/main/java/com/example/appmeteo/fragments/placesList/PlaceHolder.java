package com.example.appmeteo.fragments.placesList;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmeteo.DetailActivity;
import com.example.appmeteo.R;
import com.example.appmeteo.model.Place;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class PlaceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Place place;
    private TextView nameTextView;
    private ViewGroup parent;
    private FragmentActivity activity;

    public PlaceHolder(LayoutInflater inflater, ViewGroup parent, FragmentActivity activity) {
        super(inflater.inflate(R.layout.list_item, parent, false));
        itemView.setOnClickListener(this);
        nameTextView= itemView.findViewById(R.id.listNameTextView);
        this.parent = parent;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        //TODO mettere il passaggio all'activity con il meteo della location
        Intent intent = DetailActivity.newIntent(activity, place.getUuid());
        activity.startActivity(intent);


    }

    public void bind(Place place){
        this.place=place;
        nameTextView.setText(place.getName());
    }
}
