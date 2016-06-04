package com.wpam.gamejamapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;


public class RegisterSummaryFragment extends Fragment {

    public RegisterSummaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_summary, container, false);

        view.findViewById(R.id.summary_check).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));

        return view;
    }
}
