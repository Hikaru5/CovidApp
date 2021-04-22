package com.example.covidapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class State {

    public String stateName;
    public int deathCount;
    public int infectedCount;
    public String stateImage;

    public State(){}//empty constructor for parceler

    public State(JSONObject jsonObject) throws JSONException
    {
        stateName = jsonObject.getString("state");
        deathCount = jsonObject.getInt("deaths");
        infectedCount = jsonObject.getInt("cases");
    }

    public static List<State> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<State> states = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            states.add(new State(jsonArray.getJSONObject(i)));
        }
        return states;
    }
}
