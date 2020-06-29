package com.example.gps.modelopenroute;

public class Query
{
    private String profile;

    private String[][] coordinates;

    private String format;

    public String getProfile ()
    {
        return profile;
    }

    public void setProfile (String profile)
    {
        this.profile = profile;
    }

    public String[][] getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (String[][] coordinates)
    {
        this.coordinates = coordinates;
    }

    public String getFormat ()
    {
        return format;
    }

    public void setFormat (String format)
    {
        this.format = format;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [profile = "+profile+", coordinates = "+coordinates+", format = "+format+"]";
    }
}
