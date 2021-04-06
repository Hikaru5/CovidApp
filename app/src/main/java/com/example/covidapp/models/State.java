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
    public int recoveredCount;
    public String stateImageUrl;

    public State(){}//empty constructor for parceler

    //Someone needs to do the API stuff in here please
    public static State fromJson(/*JSONObject JsonObject*/) /*throws JSONException */{
        State state = new State();

        state.stateName = "State name";
        state.deathCount = 1000;
        state.infectedCount = 2000;
        state.recoveredCount = 3000;
        state.stateImageUrl = "";

        return state;
    }

    public static List<State> fromJSONArray(JSONArray jsonArray) throws JSONException {
        List<State> states = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            //states.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return states;
    }
}
