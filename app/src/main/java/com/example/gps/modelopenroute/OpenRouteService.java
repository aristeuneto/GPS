package com.example.gps.modelopenroute;

public class OpenRouteService
{
    private Features[] features;

    private Metadata metadata;

    private String[] bbox;

    private String type;

    public Features[] getFeatures ()
    {
        return features;
    }

    public void setFeatures (Features[] features)
    {
        this.features = features;
    }

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

    public String[] getBbox ()
    {
        return bbox;
    }

    public void setBbox (String[] bbox)
    {
        this.bbox = bbox;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [features = "+features+", metadata = "+metadata+", bbox = "+bbox+", type = "+type+"]";
    }
}
