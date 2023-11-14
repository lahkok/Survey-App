package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private EditText nameEditText;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        textView = view.findViewById(R.id.textView);

        // If there is a Bundle object associated with the fragment, get the name from the Bundle object.
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString("name");
            textView.setText(name);
        }

        return view;
    }

    public void register() {
        String name = nameEditText.getText().toString();

        // Create a new Bundle object.
        Bundle bundle = new Bundle();

        // Put the name in the Bundle object.
        bundle.putString("name", name);

        // Set the Bundle object on the fragment.
        setArguments(bundle);
    }
}