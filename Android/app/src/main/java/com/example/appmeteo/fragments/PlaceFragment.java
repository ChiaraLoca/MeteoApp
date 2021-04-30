package com.example.appmeteo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.appmeteo.R;
import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;

import java.util.UUID;

public class PlaceFragment extends Fragment {
    private static final String ARG_PLACE_ID = "place_id";

    private Place place;
    private TextView nameTextView;

    public static PlaceFragment newInstance(UUID uuid){
        Bundle bundle= new Bundle();
        bundle.putSerializable(ARG_PLACE_ID, uuid);

        PlaceFragment fragment= new PlaceFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID placeId = (UUID) getArguments().getSerializable(ARG_PLACE_ID);
        place = PlacesHolder.get(getActivity()).getPlaceByUUID(placeId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_place, container, false);

        nameTextView= v.findViewById(R.id.nameTextView);
        nameTextView.setText(place.getName());


        return v;
    }
}
