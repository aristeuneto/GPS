package com.example.gps.modelopenroute;

public class Segments
{
    private String duration;

    private String distance;

    private Steps[] steps;

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

    public Steps[] getSteps ()
    {
        return steps;
    }

    public void setSteps (Steps[] steps)
    {
        this.steps = steps;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", distance = "+distance+", steps = "+steps+"]";
    }
}
