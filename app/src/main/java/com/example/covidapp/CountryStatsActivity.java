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
    RecyclerView rvCountryStats;

    List<DoubleStat> doubleStats;
    DoubleStatAdapter adapter;

    private String cases = "No data";
    private String testPositivityRatio = "No data";
    private String positiveTests = "No data";
    private String negativeTests = "No data";
    private String vacDistr = "No data";
    private String vacAdmin = "No data";
    private String vacComp = "No data";
    private String icuCapacity = "No data";
    private String icuUsage = "No data";
    private String stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stats);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnBack = findViewById(R.id.btnCountryStatsBack);
        rvCountryStats = findViewById(R.id.rvCountryStatisticsList);

        doubleStats = new ArrayList<>();
        for(int i = 0; i < 4; i++){//fill with junk data
            doubleStats.add(DoubleStat.setManual("Loading...", "Loading...", "", ""));
        }
        adapter = new DoubleStatAdapter(this, doubleStats);

        rvCountryStats.setAdapter(adapter);
        rvCountryStats.setLayoutManager(new LinearLayoutManager(this));

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
                    country.getJSONObject("");
                } catch (JSONException e) {
                    Log.e(TAG,"Hit JsonException", e);
                }

                try{
                    cases = ("" + country.getJSONObject("actuals").getInt("cases"));
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    testPositivityRatio = ("" + country.getJSONObject("metrics").getDouble("testPositivityRatio") * 100).substring(0,5) + "%";
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    positiveTests = "" + country.getJSONObject("actuals").getInt("positiveTests");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    negativeTests = "" + country.getJSONObject("actuals").getInt("negativeTests");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    vacDistr = "" + country.getJSONObject("actuals").getInt("vaccinesDistributed");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    vacAdmin = "" + country.getJSONObject("actuals").getInt("vaccinesAdministered");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    vacComp = "" + country.getJSONObject("actuals").getInt("vaccinationsCompleted");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    icuCapacity = "" + country.getJSONObject("actuals").getJSONObject("icuBeds").getInt("capacity");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                try{
                    icuUsage = "" + country.getJSONObject("actuals").getJSONObject("icuBeds").getInt("currentUsageCovid");
                }catch(JSONException e){
                    Log.e(TAG,"Hit JsonException", e);
                }
                Log.d(TAG, "test1");

                doubleStats.set(0, (DoubleStat.setManual("Cases", "Test Positivity", cases, ("" + (double)Integer.parseInt(positiveTests)/(double)Integer.parseInt(negativeTests) * 100).substring(0,5) + "%" )));
                doubleStats.set(1, (DoubleStat.setManual("Positive Tests", "Negative Tests", positiveTests, negativeTests)));
                doubleStats.set(2, (DoubleStat.setManual("Vaccines Distributed", "Vaccines Administered", vacDistr, vacAdmin)));
                doubleStats.set(3, (DoubleStat.setManual("ICU Total Capacity", "ICU Covid Usage", icuCapacity, icuUsage)));

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}