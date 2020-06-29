package com.example.gps.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

public class BuscarEndereco extends AsyncTask<Void, Void, Address> {

    private Context ctx;
    private String rua;
    private Geocoder geocoder;
    private Address address = null;
    private List<Address> addresses;

    public BuscarEndereco(Context ctx, String rua) {
        this.ctx = ctx;
        this.rua = rua;
    }

    @Override
    protected Address doInBackground(Void... voids) {
        try {
            geocoder = new Geocoder(ctx);
            addresses = geocoder.getFromLocationName(rua, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(addresses != null){
            if (addresses.size() > 0) {
                address = addresses.get(0);

            } else {
                return null;
            }
        }
        return address;
    }
}
