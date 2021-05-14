package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.covidapp.models.DoubleStat;
import com.example.covidapp.models.State;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class SpecificStateStatsActivity extends AppCompatActivity {

    public static final String TAG = "SpecStateStatsActivity";

    List<DoubleStat> doubleStats;
    DoubleStatAdapter adapter;

    Button btnBack;
    TextView tvStateName;
    ImageView ivStateImg;
    RecyclerView rvStateStats;

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
    private String stateName;
    private String fullStateName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_state_stats);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        State parcelState = Parcels.unwrap(getIntent().getParcelableExtra("state"));
        stateName = parcelState.stateName;
        fullStateName = parcelState.fullStateName;

        doubleStats = new ArrayList<>();
        for(int i = 0; i < 4; i++){//fill with junk data
            doubleStats.add(DoubleStat.setManual("Loading...", "Loading...", "", ""));
        }

        adapter = new DoubleStatAdapter(this, doubleStats);

        btnBack = findViewById(R.id.btnSpecificStateStatsBack);
        tvStateName = findViewById(R.id.tvSpecificStateStatsTitle);
        ivStateImg = findViewById(R.id.ivSpecificStateStatsPicture);
        rvStateStats = findViewById(R.id.rvSpecificStateStatsList);

        rvStateStats.setAdapter(adapter);
        rvStateStats.setLayoutManager(new LinearLayoutManager(this));

        tvStateName.setText(fullStateName);
        Context context = ivStateImg.getContext();//setting the state picture
        int id = context.getResources().getIdentifier("@drawable/" + stateName.toLowerCase(), "drawable", context.getPackageName());

        ivStateImg.setImageResource(id);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        //Plug in the state's state code
        String stateCode = stateName;
        client.get("https://api.covidactnow.org/v2/state/"+stateCode+".json?apiKey=6b6dd78ca3d0478c8d18892239af23ca", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG,"onSuccess");
                JSONObject country = json.jsonObject;
                try {
                    country = country.getJSONObject("");
                    Log.i(TAG,country.toString());
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

                doubleStats.set(0, (DoubleStat.setManual("Cases", "Test Positivity", cases, ("" + (double)Integer.parseInt(positiveTests)/(double)Integer.parseInt(negativeTests) * 100).substring(0,5) + "%")));
                doubleStats.set(1, (DoubleStat.setManual("Positive Tests", "Negative Tests", positiveTests, negativeTests)));
                doubleStats.set(2, (DoubleStat.setManual("Vaccines Distributed", "Vaccines Administered", vacDistr, vacAdmin)));
                doubleStats.set(3, (DoubleStat.setManual("ICU Total Capacity", "ICU Covid Usage", icuCapacity, icuUsage)));

                //stats = "Current infection rate: "+infectionRate+"\nTest positivity ratio: "+testPositivityRatio+"\nPositive tests: "+positiveTests+"\nNegative tests: "+"\nTotal vaccines distributed: "+vacDistr+"\nTotal vaccines administered: "+vacAdmin+"\nTotal vaccines completed: "+"\nTotal ICU bed capacity: "+icuCapacity+"\nCurrent ICU bed usage: "+icuUsage;



                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}