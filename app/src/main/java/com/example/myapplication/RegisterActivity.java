package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.registerFragment);
    }

    public void register(View view) {
        registerFragment.register();
    }
}
