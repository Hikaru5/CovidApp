package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CountryStatsActivity extends AppCompatActivity {

    public static final String TAG = "CountryStatsActivity";

    Button btnBack;
    RecyclerView rvCountryStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stats);

        btnBack = findViewById(R.id.btnCountryStatsBack);
        rvCountryStats = findViewById(R.id.rvCountryStats);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}