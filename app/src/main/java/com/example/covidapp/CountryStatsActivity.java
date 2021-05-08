package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.covidapp.models.DoubleStat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class CountryStatsActivity extends AppCompatActivity {

    public static final String TAG = "CountryStatsActivity";
    public static final String COUNTRY_URL = "https://api.covidactnow.org/v2/country/US.json?apiKey=24ff4fc22bef4e859a94e50d8596472d";

    Button btnBack;
    TextView tvCountryStats;

    private double infectionRate;
    private double testPositivityRatio;
    private int positiveTests;
    private int negativeTests;
    private int vacDistr;
    private int vacAdmin;
    private int vacComp;
    private int icuCapacity;
    private int icuUsage;
    private String stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stats);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnCountryStatsBack);
        tvCountryStats = findViewById(R.id.tvCountryStats);

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
                    country = country.getJSONObject("");
                    Log.i(TAG,country.toString());
                    infectionRate = country.getDouble("infectionRate");
                    testPositivityRatio = country.getDouble("testPositivityRatio");
                    positiveTests = country.getInt("positiveTests");
                    negativeTests = country.getInt("negativeTests");
                    vacDistr = country.getInt("vaccinesDistributed");
                    vacAdmin = country.getInt("vaccinesAdministered");
                    vacComp = country.getInt("vaccinationsCompleted");
                    icuCapacity = country.getInt("capacity");
                    icuUsage = country.getInt("currentUsageTotal");
                    stats = "Current infection rate: "+infectionRate+"\nTest positivity ratio: "+testPositivityRatio+"\nPositive tests: "+positiveTests+"\nNegative tests: "+"\nTotal vaccines distributed: "+vacDistr+"\nTotal vaccines administered: "+vacAdmin+"\nTotal vaccines completed: "+"\nTotal ICU bed capacity: "+icuCapacity+"\nCurrent ICU bed usage: "+icuUsage;
                    tvCountryStats.setText(stats);
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