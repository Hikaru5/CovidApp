package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.covidapp.models.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.Map;

//the button to send the user to SpecificStateStatsActivity has its code inside of StateAdapter
//this was done because of some issues with context

public class StateStatsActivity extends AppCompatActivity {

    public static final String TAG = "StateStatsActivity";

    Button btnBack;
    Button btnStateSelect;
    RecyclerView rvStates;
    List<State> states;
    StateAdapter adapter;
    Hashtable<String, String> stateNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_stats);

        stateNames = new Hashtable<>();
        setStateNames();

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnStateStatsBack);
        rvStates = findViewById(R.id.rvStates);
        btnStateSelect = findViewById(R.id.btnStateSelect);

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
        /*for(int i = 0; i < 10; i++){
            states.add(State.fromJson());
        }*/
        for (Map.Entry<String, String> e : stateNames.entrySet()) {
            states.add(State.setManual(e.getValue(), 1, 1, 1, e.getKey()));
        }
    }

    private void setStateNames(){
        stateNames.put("al", "Alabama");
        stateNames.put("ak", "Alaska");
        stateNames.put("az", "Arizona");
        stateNames.put("ar", "Arkansas");
        stateNames.put("ca", "California");

        stateNames.put("co", "Colorado");
        stateNames.put("ct", "Connecticut");
        stateNames.put("de", "Delaware");
        stateNames.put("fl", "Florida");
        stateNames.put("ga", "Georgia");

        stateNames.put("hi", "Hawaii");
        stateNames.put("id", "Idaho");
        stateNames.put("il", "Illinois");
        stateNames.put("in", "Indiana");
        stateNames.put("ia", "Iowa");

        stateNames.put("ks", "Kansas");
        stateNames.put("ky", "Kentucky");
        stateNames.put("la", "Louisiana");
        stateNames.put("me", "Maine");
        stateNames.put("md", "Maryland");

        stateNames.put("ma", "Massachusetts");
        stateNames.put("mi", "Michigan");
        stateNames.put("mn", "Minnesota");
        stateNames.put("ms", "Mississippi");
        stateNames.put("mo", "Missouri");

        stateNames.put("mt", "Montana");
        stateNames.put("ne", "Nebraska");
        stateNames.put("nv", "Nevada");
        stateNames.put("nh", "New Hampshire");
        stateNames.put("nj", "New Jersey");

        stateNames.put("nm", "New Mexico");
        stateNames.put("ny", "New York");
        stateNames.put("nc", "North Carolina");
        stateNames.put("nd", "North Dakota");
        stateNames.put("oh", "Ohio");

        stateNames.put("ok", "Oklahoma");
        stateNames.put("or", "Oregon");
        stateNames.put("pa", "Pennsylvania");
        stateNames.put("ri", "Rhode Island");
        stateNames.put("sc", "South Carolina");

        stateNames.put("sd", "South Dakota");
        stateNames.put("tn", "Tennessee");
        stateNames.put("tx", "Texas");
        stateNames.put("ut", "Utah");
        stateNames.put("vt", "Vermont");

        stateNames.put("va", "Virginia");
        stateNames.put("wa", "Washington");
        stateNames.put("wv", "West Virginia");
        stateNames.put("wi", "Wisconsin");
        stateNames.put("wy", "Wyoming");
    }
}