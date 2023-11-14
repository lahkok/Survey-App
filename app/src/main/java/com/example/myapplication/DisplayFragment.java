package com.example.myapplication;
// DisplayFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    private static final String ARG_USER_NAME = "userName";

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(String userName) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        TextView textViewDisplay = view.findViewById(R.id.textViewDisplay);

        if (getArguments() != null) {
            String userName = getArguments().getString(ARG_USER_NAME);
            textViewDisplay.setText("Welcome, " + userName + "!");
        }

        return view;
    }

}
