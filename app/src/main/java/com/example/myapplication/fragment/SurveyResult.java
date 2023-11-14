package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SurveyResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurveyResult extends Fragment {

    private TextView text_result;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_survey_result, container, false);

        Log.d("SurveyResult", "onViewCreated called");


        // Find the TextView in the fragment layout
        text_result = view.findViewById(R.id.text_result);

        // Handle the result (assuming you have a setResult method in SurveyResult)
        Bundle bundle = getArguments();
        if (bundle != null) {
            String result = bundle.getString("result", "");
            setResult(result);
        }

        return view;
    }

    public void setResult(String result) {
        // Display the result in the TextView
        if (text_result != null) {
            text_result.setText(result);
        }
    }
}