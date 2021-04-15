package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.covidapp.models.State;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class StateStatsActivity extends AppCompatActivity {

    public static final String TAG = "StateStatsActivity";
    public static final String STATES_URL = "https://api.covidtracking.com/v2/states.json";

    Button btnBack;
    RecyclerView rvStates;
    List<State> states;
    StateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_stats);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnStateStatsBack);
        rvStates = findViewById(R.id.rvStates);

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
        client.get(STATES_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG,"onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray current = jsonObject.getJSONArray("current");
                    Log.i(TAG,current.toString());
                    states.addAll(State.fromJSONArray(current));
                    adapter.notifyDataSetChanged();
                    Log.i(TAG,"States: "+states.size());
                } catch (JSONException e) {
                    Log.e(TAG,"Hit JsonException", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}