package com.example.covidapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class State {

    public String fullStateName;
    public String stateName;
    public int deathCount;
    public int infectedCount;
    public int fullyVaccinated;
    public String stateImage;

    public State(){}//empty constructor for parceler

    public static State fromJson(JSONObject JsonObject) throws JSONException
    {
        State state = new State();

        try{
            state.stateName = JsonObject.getString("state");
        } catch (JSONException e){
            state.stateName = "Unknown";
        }
        try{
            state.deathCount = JsonObject.getInt("deaths");
        } catch (JSONException e){
            state.deathCount = 0;
        }
        try{
            state.infectedCount = JsonObject.getInt("cases");
        } catch (JSONException e){
            state.infectedCount = 0;
        }
        try{
            state.fullyVaccinated = JsonObject.getInt("vaccinationsCompleted");
        } catch (JSONException e){
            state.fullyVaccinated = 0;
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

        state.stateName = stateName;
        state.deathCount = deathCount;
        state.infectedCount = infectedCount;
        state.fullyVaccinated = vaccinatedCount;
        state.stateImage = stateAbbreviation.toLowerCase();

        return state;
    }

    public void setStateName(String name){
        fullStateName = name;
    }

}
