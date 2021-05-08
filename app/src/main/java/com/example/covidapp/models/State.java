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
    public int fullyVaccinated;
    public String stateImage;

    public State(){}//empty constructor for parceler

    public static State fromJson(JSONObject JsonObject) throws JSONException
    {
        State state = new State();

        state.stateName = JsonObject.getString("state");
        state.deathCount = JsonObject.getInt("deaths");
        state.infectedCount = JsonObject.getInt("cases");
        state.fullyVaccinated = JsonObject.getInt("vaccinationsCompleted");
        state.stateImage = "";

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

}
