package com.example.covidapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class DoubleStat {

    public String statTitle1;
    public int stat1;
    public String statTitle2;
    public int stat2;

    public DoubleStat(){}//empty constructor for parceler

    //Someone needs to do the API stuff in here  please
    public static DoubleStat fromJson(/*JSONObject JsonObject*/) /*throws JSONException*/ {
        DoubleStat stat = new DoubleStat();

        stat.statTitle1 = "stat 1";
        stat.statTitle2 = "stat 2";
        stat.stat1 = 1000;
        stat.stat2 = 2000;

        return stat;
    }

    public static List<DoubleStat> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<DoubleStat> stats = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            //stats.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return stats;
    }
}