package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StateStatsActivity extends AppCompatActivity {

    public static final String TAG = "StateStatsActivity";

    Button btnBack;
    RecyclerView rvStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_stats);

        btnBack = findViewById(R.id.btnStateStatsBack);
        rvStates = findViewById(R.id.rvStates);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}