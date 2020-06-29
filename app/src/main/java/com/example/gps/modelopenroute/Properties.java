package com.example.gps.modelopenroute;

public class Properties
{
    private Summary summary;

    private Segments[] segments;

    private String[] way_points;

    public Summary getSummary ()
    {
        return summary;
    }

    public void setSummary (Summary summary)
    {
        this.summary = summary;
    }

    public Segments[] getSegments ()
    {
        return segments;
    }

    public void setSegments (Segments[] segments)
    {
        this.segments = segments;
    }

    public String[] getWay_points ()
    {
        return way_points;
    }

    public void setWay_points (String[] way_points)
    {
        this.way_points = way_points;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", segments = "+segments+", way_points = "+way_points+"]";
    }
}
