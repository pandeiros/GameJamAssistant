package com.wpam.gamejamapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginIntroFragment extends Fragment {


    public LoginIntroFragment() {
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
        View view = inflater.inflate(R.layout.fragment_login_intro, container, false);

        Button button = (Button) view.findViewById(R.id.btn_login);
        assert button != null;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity a = (LoginActivity) getActivity();
                a.showLoginForm();
            }
        });

        button = (Button) view.findViewById(R.id. btn_register);
        assert button != null;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity a = (LoginActivity) getActivity();
                a.showRegisterForm();
            }
        });

        return view;
    }

}
