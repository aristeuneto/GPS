package com.example.gps.util;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import com.example.gps.modelopenroute.OpenRouteService;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HttpServiceORS extends AsyncTask<Void, Void, OpenRouteService> {

    private String latitudeInicial = "-12.9668";
    private String longitudeInicial = "-39.2617";
    private String latitudeFinal = "-12.6712";
    private String longitudeFinal = "-39.1041";
    private Context context;

    public HttpServiceORS(String latitudeInicial, String longitudeInicial, String latitudeFinal, String longitudeFinal) {
        this.latitudeInicial = latitudeInicial;
        this.longitudeInicial = longitudeInicial;
        this.latitudeFinal = latitudeFinal;
        this.longitudeFinal = longitudeFinal;
    }

    @Override
    protected OpenRouteService doInBackground(Void... voids) {

        try {
            Client client = Client.create();
            WebResource webResource = client.resource("https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248441302ee27774ea99bd6b65d8892b8bc" +
                    "&start=" + longitudeInicial + "," + latitudeInicial + "&end=" + longitudeFinal + "," + latitudeFinal + "");
            String retorno = webResource.get(String.class);

            return new Gson().fromJson(retorno, OpenRouteService.class);
        } catch (Exception e) {
            Toast.makeText(context, "Endereço não encontrado!", Toast.LENGTH_LONG).show();
        }
        return null;
    }

}

