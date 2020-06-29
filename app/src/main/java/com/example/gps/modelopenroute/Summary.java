package com.example.gps.modelopenroute;

public class Summary
{
    private String duration;

    private String distance;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getDistance ()
    {
        return distance;
    }

    public void setDistance (String distance)
    {
        this.distance = distance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", distance = "+distance+"]";
    }
}
