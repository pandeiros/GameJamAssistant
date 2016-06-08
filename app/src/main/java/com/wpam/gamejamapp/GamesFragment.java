package com.wpam.gamejamapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wpam.gamejamapp.db.DB;

public class GamesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    public GamesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // specify an adapter
//        Game arr[] = {
//                new Game("Rocket League", new Team("Psyonix")),
//                new Game("Grand Theft Auto", new Team("Rockstar Games")),
//                new Game("Overwatch", new Team("Blizzard")),
//                new Game("Assasins vs Pirates", new Team("Deadbit")),
//                new Game("The Vanishing of Ethan Carter", new Team("The Astronauts"))
//
//        };

        mAdapter = new RecyclerViewAdapterGames(DB.getInstance().getGamesAsArray());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_games);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
