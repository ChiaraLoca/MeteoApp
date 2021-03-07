package com.example.appmeteo.fragments.placesList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceHolder> {
    private List<Place> places;
    private FragmentActivity activity;

    public PlaceAdapter(List<Place> places, FragmentActivity activity) {
        this.activity=activity;
        this.places = places;
    }

    @Override
    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        return new PlaceHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(PlaceHolder holder, int position) {
        Place place = places.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
