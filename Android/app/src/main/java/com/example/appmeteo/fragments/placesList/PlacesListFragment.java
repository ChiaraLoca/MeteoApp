package com.example.appmeteo.fragments.placesList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmeteo.R;
import com.example.appmeteo.SearchActivity;
import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;

import java.util.List;

public class PlacesListFragment extends Fragment {
    private RecyclerView placeRecyclerView;
    private PlaceAdapter placeAdapter;

    private Button addButton;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        placeRecyclerView = view.findViewById(R.id.recycler_view);
        placeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Place> places= PlacesHolder.get(getActivity()).getPlaces();
        placeAdapter=new PlaceAdapter(places, getActivity());
        placeRecyclerView.setAdapter(placeAdapter);

        addButton = view.findViewById(R.id.id_addB);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSearchActivity();
            }
        });


        return view;
    }

    public void startSearchActivity()
    {
        Intent intent = SearchActivity.newIntent(this.getContext());
        startActivityForResult(intent,2);
    }
}
