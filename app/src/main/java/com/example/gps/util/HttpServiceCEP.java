package com.example.gps.util;

import android.os.AsyncTask;

import com.example.gps.model.ModelCEP;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HttpServiceCEP extends AsyncTask<Void, Void, ModelCEP> {

    private String cep;

    public HttpServiceCEP(String cep) {
        this.cep = cep;
    }

    @Override
    protected ModelCEP doInBackground(Void... voids) {

        Client client = Client.create();
        WebResource webResource = client.resource("https://viacep.com.br/ws/" + this.cep + "/json/");
        String retorno = webResource.get(String.class);

        return new Gson().fromJson(retorno, ModelCEP.class);
    }


}
