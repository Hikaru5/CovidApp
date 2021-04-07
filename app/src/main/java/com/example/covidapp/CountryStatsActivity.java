package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.covidapp.models.DoubleStat;

import java.util.ArrayList;
import java.util.List;

public class CountryStatsActivity extends AppCompatActivity {

    public static final String TAG = "CountryStatsActivity";

    Button btnBack;
    RecyclerView rvCountryStats;

    List<DoubleStat> stats;
    DoubleStatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stats);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnCountryStatsBack);
        rvCountryStats = findViewById(R.id.rvCountryStats);

        stats = new ArrayList<>();
        populateStatList();
        adapter = new DoubleStatAdapter(this, stats);

        rvCountryStats.setLayoutManager(new LinearLayoutManager(this));
        rvCountryStats.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void populateStatList() {
        for(int i = 0; i < 10; i++){
            stats.add(DoubleStat.fromJson());
        }
    }

}