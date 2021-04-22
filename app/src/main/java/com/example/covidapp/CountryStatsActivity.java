package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.covidapp.models.DoubleStat;
import com.example.covidapp.models.State;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class CountryStatsActivity extends AppCompatActivity {

    public static final String TAG = "CountryStatsActivity";
    public static final String COUNTRY_URL = "https://api.covidactnow.org/v2/country/US.json?apiKey=24ff4fc22bef4e859a94e50d8596472d";

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
        adapter = new DoubleStatAdapter(this, stats);

        rvCountryStats.setLayoutManager(new LinearLayoutManager(this));
        rvCountryStats.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(COUNTRY_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG,"onSuccess");
                JSONObject country = json.jsonObject;
                try {
                    country = country.getJSONObject("results");
                    Log.i(TAG,country.toString());
                    adapter.notifyDataSetChanged();
                    Log.i(TAG,"States: "+country.toString());
                } catch (JSONException e) {
                    Log.e(TAG,"Hit JsonException", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
    });
}}