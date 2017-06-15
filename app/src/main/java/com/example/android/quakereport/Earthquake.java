package com.example.android.quakereport;

/**
 * Created by sanjeev on 15/6/17.
 */

public class Earthquake {
    private String magnitude;
    private String place;
    private String time;

    public Earthquake(String mag , String pl , String t)
    {
        magnitude=mag;
        place=pl;
        time=t;
    }

    public String getMag()
    {
        return magnitude;
    }

    public String getPlace()
    {
        return place;
    }
    public String getTime()
    {
        return time;
    }
}
