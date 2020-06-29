package com.example.gps.modelopenroute;

public class Metadata
{
    private Engine engine;

    private String service;

    private Query query;

    private String attribution;

    private String timestamp;

    public Engine getEngine ()
    {
        return engine;
    }

    public void setEngine (Engine engine)
    {
        this.engine = engine;
    }

    public String getService ()
    {
        return service;
    }

    public void setService (String service)
    {
        this.service = service;
    }

    public Query getQuery ()
    {
        return query;
    }

    public void setQuery (Query query)
    {
        this.query = query;
    }

    public String getAttribution ()
    {
        return attribution;
    }

    public void setAttribution (String attribution)
    {
        this.attribution = attribution;
    }

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [engine = "+engine+", service = "+service+", query = "+query+", attribution = "+attribution+", timestamp = "+timestamp+"]";
    }
}
