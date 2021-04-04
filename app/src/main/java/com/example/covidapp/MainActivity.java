package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    Button btnCountryStats;//country stats button AKA US stats button (btnUSstats looked weird as a name)
    Button btnStateStats;
    Button btnCovidInfo;
    Button btnAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCountryStats = findViewById(R.id.btnCountryStats);
        btnStateStats = findViewById(R.id.btnStateStats);
        btnCovidInfo = findViewById(R.id.btnCovidInfo);
        btnAboutUs = findViewById(R.id.btnAboutUs);

        getSupportActionBar().hide();//hides the title bar on the top of the app

        btnCountryStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CountryStatsActivity.class);
                startActivity(i);
            }
        });

        btnStateStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StateStatsActivity.class);
                startActivity(i);
            }
        });

        btnCovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CovidInfoActivity.class);
                startActivity(i);
            }
        });

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(i);
            }
        });
    }


}