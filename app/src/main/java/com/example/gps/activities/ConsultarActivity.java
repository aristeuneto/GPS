package com.example.gps.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gps.DAO.DaoEndereco;
import com.example.gps.R;
import com.example.gps.dbHelper.ConexaoSQLite;
import com.example.gps.model.ModelCEP;
import com.example.gps.model.ModelEndereco;
import com.example.gps.modelopenroute.OpenRouteService;
import com.example.gps.util.BuscarEndereco;
import com.example.gps.util.GPStracker;
import com.example.gps.util.HttpServiceORS;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ConsultarActivity extends AppCompatActivity {


    private GPStracker gpStracker;
    private Location location;
    private Address endereco;
    private String latitudeInicial;
    private String longitudeInicial;
    private String latitudeFinal;
    private String longitudeFinal;
    private ListView lvConsultar;
    private OpenRouteService retorno;


    public Address buscarEndereco(double latitude, double longitude) throws IOException {

        Geocoder geocoder;
        Address address = null;
        List<Address> addresses;

        geocoder = new Geocoder(getApplicationContext());

        addresses = geocoder.getFromLocation(latitude, longitude, 1);
        if (addresses.size() > 0) {
            address = addresses.get(0);

        }
        return address;
    }


    public Address buscarEndereco(String rua) throws IOException {

        Geocoder geocoder;
        Address address = null;
        List<Address> addresses;

        geocoder = new Geocoder(getApplicationContext());

        addresses = geocoder.getFromLocationName(rua, 1);
        if (addresses.size() > 0) {
            address = addresses.get(0);

        } else {
            return null;
        }
        return address;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        lvConsultar = (ListView) findViewById(R.id.lvConsultar);

        DaoEndereco daoEndereco = new DaoEndereco(ConexaoSQLite.getInstance(ConsultarActivity.this));

        ArrayList<ModelEndereco> listaLocais = (ArrayList) daoEndereco.getListaDeLocais();

        ArrayList<OpenRouteService> listaRetorno = new ArrayList<>();

        ArrayList<String> listaString = new ArrayList<>();

        BuscarEndereco buscarEndereco = null;

        gpStracker = new GPStracker(getApplicationContext());
        location = gpStracker.getLocation();

        if (listaLocais.size() > 0) {
            for (int i = 0; i < listaLocais.size(); i++) {
                try {
                    //   endereco = buscarEndereco(listaLocais.get(i).getModelCEP().getLogradouro() + ", " + listaLocais.get(i).getModelCEP().getBairro() + ", " + listaLocais.get(i).getModelCEP().getLocalidade());

                    String rua = listaLocais.get(i).getModelCEP().getLogradouro() + ", " + listaLocais.get(i).getModelCEP().getBairro() + ", " + listaLocais.get(i).getModelCEP().getLocalidade();
                    buscarEndereco = new BuscarEndereco(getApplicationContext(), rua);
                    endereco = buscarEndereco.execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                if (location != null) {
                 //   latitudeInicial = String.valueOf(location.getLatitude());
                 //   longitudeInicial = String.valueOf(location.getLongitude());
                } else {
                    Toast.makeText(this, "Location null!", Toast.LENGTH_SHORT).show();
                }
                latitudeInicial = "-12.97497";
                longitudeInicial = "-39.25804";
                latitudeFinal = null;
                longitudeFinal = null;
                if (endereco != null) {
                    latitudeFinal = String.valueOf(endereco.getLatitude());
                    longitudeFinal = String.valueOf(endereco.getLongitude());

                }

                try {
                    if (latitudeInicial != null && longitudeInicial != null && latitudeFinal != null && longitudeFinal != null) {
                        retorno = new HttpServiceORS(latitudeInicial, longitudeInicial, latitudeFinal, longitudeFinal).execute().get();

                        Double distanciaDouble = Double.parseDouble(retorno.getFeatures()[0].getProperties().getSegments()[0].getDistance().toString()) / 1000;
                        DecimalFormat decimalFormat = new DecimalFormat("###.##");
                        String distancia = decimalFormat.format(distanciaDouble);

                        listaString.add("Local: " + listaLocais.get(i).getNomeLocal() + " \nDistancia: " + distancia + " Km");
                    }

                } catch (ExecutionException e) {
                    Toast.makeText(this, "Endereço não encontrado!", Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    Toast.makeText(this, "Endereço não encontrado!", Toast.LENGTH_SHORT).show();
                }

            }

            if (listaString.size() > 0) {

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaString);
                lvConsultar.setAdapter(arrayAdapter);
            } else {
                Toast.makeText(this, "Lista String vazia!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "lista vazia!", Toast.LENGTH_LONG).show();
        }

    }
}