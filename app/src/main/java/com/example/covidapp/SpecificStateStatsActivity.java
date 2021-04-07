package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covidapp.models.DoubleStat;
import com.example.covidapp.models.State;

import java.util.ArrayList;
import java.util.List;

public class SpecificStateStatsActivity extends AppCompatActivity {

    public static final String TAG = "SpecificStateStatsActivity";

    Button btnBack;
    TextView tvStateName;
    ImageView ivStateImg;
    RecyclerView rvStateStats;

    List<DoubleStat> stats;
    DoubleStatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_state_stats);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnSpecificStateStatsBack);
        tvStateName = findViewById(R.id.tvSpecificStateStatsTitle);
        ivStateImg = findViewById(R.id.ivSpecificStateStatsPicture);
        rvStateStats = findViewById(R.id.rvSpecificStateStats);

        stats = new ArrayList<>();
        populateStatList();
        adapter = new DoubleStatAdapter(this, stats);

        rvStateStats.setLayoutManager(new LinearLayoutManager(this));
        rvStateStats.setAdapter(adapter);

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