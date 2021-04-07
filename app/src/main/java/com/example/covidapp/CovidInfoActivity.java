package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CovidInfoActivity extends AppCompatActivity {

    public static final String TAG = "CovidInfoActivity";
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_info);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnCovidInfoBack);

        //goes back to main page when btnBack is pressed
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}