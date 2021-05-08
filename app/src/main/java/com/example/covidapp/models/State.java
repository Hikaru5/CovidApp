package com.example.covidapp.models;

import android.util.Log;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class State {

    public static final String TAG = "State";

    public String fullStateName;
    public String stateName;
    public String deathCount;
    public String infectedCount;
    public String fullyVaccinated;
    public String stateImage;

    public State(){}//empty constructor for parceler

    public static State fromJson(JSONObject JsonObject) throws JSONException
    {
        State state = new State();

        JSONObject actuals = JsonObject.getJSONObject("actuals");//stats we are interested in are stored in an array called "actuals"

        try{
            state.stateName = JsonObject.getString("state");
        } catch (JSONException e){
            state.stateName = "";
            Log.e(TAG, "Failed to load stat: " + e);
        }
        try{
            state.deathCount = "" + actuals.getInt("deaths");
        } catch (JSONException e){
            state.deathCount = "No data";
            Log.e(TAG, "Failed to load stat: " + e);
        }
        try{
            state.infectedCount = "" + actuals.getInt("cases");
        } catch (JSONException e){
            state.infectedCount = "No data";
            Log.e(TAG, "Failed to load stat: " + e);
        }
        try{
            state.fullyVaccinated = "" + actuals.getInt("vaccinationsCompleted");
        } catch (JSONException e){
            state.fullyVaccinated = "No data";
            Log.e(TAG, "Failed to load stat: " + e);
        }

        state.stateImage = "@drawable/" + state.stateName.toLowerCase();

        return state;
    }

    public static List<State> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<State> states = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            states.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return states;
    }

    public static State setManual(String stateName, int deathCount, int infectedCount, int vaccinatedCount, String stateAbbreviation){
        State state = new State();

        state.stateName = "" + stateName;
        state.deathCount = "" + deathCount;
        state.infectedCount = "" + infectedCount;
        state.fullyVaccinated = "" + vaccinatedCount;
        state.stateImage = stateAbbreviation.toLowerCase();

        return state;
    }

    public void setStateName(String name){
        fullStateName = name;
    }

}
