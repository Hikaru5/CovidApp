package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.codepath.asynchttpclient.AsyncHttpClient;


import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.covidapp.models.State;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import okhttp3.Headers;

//the button to send the user to SpecificStateStatsActivity has its code inside of StateAdapter
//this was done because of some issues with context

public class StateStatsActivity extends AppCompatActivity {

    public static final String TAG = "StateStatsActivity";
    public static final String STATES_URL = "https://api.covidactnow.org/v2/states.json?apiKey=6b6dd78ca3d0478c8d18892239af23ca";

    ProgressBar pbLoading;
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
        pbLoading = (ProgressBar) findViewById(R.id.pbStateStats);

        states = new ArrayList<>();
        adapter = new StateAdapter(this, states);

        rvStates.setLayoutManager(new LinearLayoutManager(this));
        rvStates.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(STATES_URL, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json)
            {
                pbLoading.setVisibility(View.VISIBLE);

                Log.d(TAG,"onSuccess");
                JSONArray statesList = json.jsonArray;
                try
                {
                    states.addAll(State.fromJSONArray(statesList));

                    for(int i = 0; i < states.size(); i++){//assigns the state name based on state abbreviation
                        State state = states.get(i);
                        state.setStateName( stateNames.get(state.stateName) );
                    }

                    adapter.notifyDataSetChanged();
                    pbLoading.setVisibility(View.GONE);
                    Log.i(TAG,"States: "+states.size());
                }
                catch (JSONException e)
                {
                    Log.e(TAG,"Hit JsonException", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable)
            {
                Log.d(TAG,"onFailure");
            }
        });
    }

    private void setStateNames(){
        stateNames.put("", "Unknown");
        stateNames.put("MP", "Northern Mariana Islands");
        stateNames.put("PR", "Puerto Rico");
        stateNames.put("DC", "District of Colombia");

        stateNames.put("AL", "Alabama");
        stateNames.put("AK", "Alaska");
        stateNames.put("AZ", "Arizona");
        stateNames.put("AR", "Arkansas");
        stateNames.put("CA", "California");

        stateNames.put("CO", "Colorado");
        stateNames.put("CT", "Connecticut");
        stateNames.put("DE", "Delaware");
        stateNames.put("FL", "Florida");
        stateNames.put("GA", "Georgia");

        stateNames.put("HI", "Hawaii");
        stateNames.put("ID", "Idaho");
        stateNames.put("IL", "Illinois");
        stateNames.put("IN", "Indiana");
        stateNames.put("IA", "Iowa");

        stateNames.put("KS", "Kansas");
        stateNames.put("KY", "Kentucky");
        stateNames.put("LA", "Louisiana");
        stateNames.put("ME", "Maine");
        stateNames.put("MD", "Maryland");

        stateNames.put("MA", "Massachusetts");
        stateNames.put("MI", "Michigan");
        stateNames.put("MN", "Minnesota");
        stateNames.put("MS", "Mississippi");
        stateNames.put("MO", "Missouri");

        stateNames.put("MT", "Montana");
        stateNames.put("NE", "Nebraska");
        stateNames.put("NV", "Nevada");
        stateNames.put("NH", "New Hampshire");
        stateNames.put("NJ", "New Jersey");

        stateNames.put("NM", "New Mexico");
        stateNames.put("NY", "New York");
        stateNames.put("NC", "North Carolina");
        stateNames.put("ND", "North Dakota");
        stateNames.put("OH", "Ohio");

        stateNames.put("OK", "Oklahoma");
        stateNames.put("OR", "Oregon");
        stateNames.put("PA", "Pennsylvania");
        stateNames.put("RI", "Rhode Island");
        stateNames.put("SC", "South Carolina");

        stateNames.put("SD", "South Dakota");
        stateNames.put("TN", "Tennessee");
        stateNames.put("TX", "Texas");
        stateNames.put("UT", "Utah");
        stateNames.put("VT", "Vermont");

        stateNames.put("VA", "Virginia");
        stateNames.put("WA", "Washington");
        stateNames.put("WV", "West Virginia");
        stateNames.put("WI", "Wisconsin");
        stateNames.put("WY", "Wyoming");
    }
}