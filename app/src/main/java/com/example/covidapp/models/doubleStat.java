package com.example.covidapp.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class doubleStat {

    public String statTitle1;
    public int stat1;
    public String statTitle2;
    public int stat2;

    public doubleStat(){}//empty constructor for parceler

    //Someone needs to do the API stuff in here  please
    public static doubleStat fromJson(JSONObject JsonObject) throws JSONException {
        doubleStat stat = new doubleStat();

        //stat.statTitle1 =
        //stat.statTitle2 =
        //stat.stat1 =
        //stat.stat2 =

        return stat;
    }
}
