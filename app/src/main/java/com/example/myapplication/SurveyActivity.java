package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.fragment.SurveyResult;

public class SurveyActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtEmail;
    Spinner tauAplikasi;
    Button onSubmit;
    RadioGroup rgJob;
    RadioButton rbJob;
    CheckBox cbA, cbB, cbC;
    String resultText;
    TextView textResult;
    LinearLayout fragment_survey_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        tauAplikasi = findViewById(R.id.tau_aplikasi);
        rgJob = findViewById(R.id.rg_job);
        onSubmit = findViewById(R.id.btn_submit);
        cbA = findViewById(R.id.cb_a);
        cbB = findViewById(R.id.cb_b);
        cbC = findViewById(R.id.cb_c);


        // Spinner setup
        Spinner tauAplikasi = findViewById(R.id.tau_aplikasi);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        );
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tauAplikasi.setAdapter(staticAdapter);

        onSubmit.setOnClickListener(view -> {
            // Assuming getResult() returns a String
            String result = getResult();

            // Create a new instance of the SurveyResult fragment
            SurveyResult fragment = new SurveyResult();

            // Pass the result to the fragment
            Bundle bundle = new Bundle();
            bundle.putString("result", result);
            fragment.setArguments(bundle);

            // Replace the current fragment with the SurveyResult fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_survey_result, fragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    public String getResult() {
        String resultText = "";

        resultText += "Nama : " + edtName.getText().toString() + "\n";

        resultText += "Email : " + edtEmail.getText().toString() + "\n";

        resultText += "Darimana anda mengetahui aplikasi ini? : " + tauAplikasi.getSelectedItem().toString() + "\n";

        int checkedIdRadioGroup = rgJob.getCheckedRadioButtonId();
        rbJob = findViewById(checkedIdRadioGroup);
        resultText += "Pilih profesi anda : " + rbJob.getText() + "\n";

        resultText += "Fitur yang anda sukai dari aplikasi ini? : ";
        if (cbA.isChecked()) {
            resultText += "A, ";
        }
        if (cbB.isChecked()) {
            resultText += "B, ";
        }
        if (cbC.isChecked()) {
            resultText += "C";
        }

        return resultText;
    }

}
