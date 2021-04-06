package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificStateStatsActivity extends AppCompatActivity {

    public static final String TAG = "SpecificStateStatsActivity";

    Button btnBack;
    TextView tvStateName;
    ImageView ivStateImg;
    RecyclerView rvStateStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_state_stats);

        btnBack = findViewById(R.id.btnSpecificStateStatsBack);
        tvStateName = findViewById(R.id.tvSpecificStateStatsTitle);
        ivStateImg = findViewById(R.id.ivSpecificStateStatsPicture);
        rvStateStats = findViewById(R.id.rvSpecificStateStats);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}