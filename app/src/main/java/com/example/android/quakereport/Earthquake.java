package com.example.android.quakereport;

/**
 * Created by sanjeev on 15/6/17.
 */

public class Earthquake {
    private Double magnitude;
    private String place;
    private Long time;
    public String url;

    public Earthquake(Double mag , String pl , Long t , String url)
    {
        magnitude=mag;
        place=pl;
        time=t;
        this.url=url;
    }

    public Double getMag()
    {
        return magnitude;
    }

    public String getPlace()
    {
        return place;
    }
    public Long getTime()
    {
        return time;
    }


    public String getUrl()
    {
        return url;
    }
}
