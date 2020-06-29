package com.example.gps.modelopenroute;

public class Features
{
    private String[] bbox;

    private Geometry geometry;

    private String type;

    private Properties properties;

    public String[] getBbox ()
    {
        return bbox;
    }

    public void setBbox (String[] bbox)
    {
        this.bbox = bbox;
    }

    public Geometry getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (Geometry geometry)
    {
        this.geometry = geometry;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Properties getProperties ()
    {
        return properties;
    }

    public void setProperties (Properties properties)
    {
        this.properties = properties;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [bbox = "+bbox+", geometry = "+geometry+", type = "+type+", properties = "+properties+"]";
    }
}
