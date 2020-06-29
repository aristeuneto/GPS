package com.example.gps.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.gps.R;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity {

    private Button btnConsultar;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        if (Build.VERSION.SDK_INT >= M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                String[] permissoes = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
                requestPermissions(permissoes, 1);
            }
        }


        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConsultar = new Intent(MainActivity.this, ConsultarActivity.class);
                startActivity(intentConsultar);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadastrar = new Intent(MainActivity.this, CadastrarEnderecoActivity.class);
                startActivity(intentCadastrar);

            }
        });


    }
}