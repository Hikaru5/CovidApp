package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.covidapp.models.State;

import java.util.ArrayList;
import java.util.List;

public class StateStatsActivity extends AppCompatActivity {

    public static final String TAG = "StateStatsActivity";

    Button btnBack;
    RecyclerView rvStates;
    List<State> states;
    StateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_stats);

        btnBack = findViewById(R.id.btnStateStatsBack);
        rvStates = findViewById(R.id.rvStates);

        states = new ArrayList<>();
        populateStateList();
        adapter = new StateAdapter(this, states);

        rvStates.setLayoutManager(new LinearLayoutManager(this));
        rvStates.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void populateStateList(){
        for(int i = 0; i < 10; i++){
            states.add(State.fromJson());
        }
    }
}