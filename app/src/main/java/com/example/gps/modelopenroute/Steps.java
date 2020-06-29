package com.example.gps.modelopenroute;

public class Steps
{
    private String duration;

    private String distance;

    private String instruction;

    private String name;

    private String type;

    private String[] way_points;

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

    public String getInstruction ()
    {
        return instruction;
    }

    public void setInstruction (String instruction)
    {
        this.instruction = instruction;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
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
        return "ClassPojo [duration = "+duration+", distance = "+distance+", instruction = "+instruction+", name = "+name+", type = "+type+", way_points = "+way_points+"]";
    }
}
