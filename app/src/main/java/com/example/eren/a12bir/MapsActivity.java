package com.example.eren.a12bir;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {



    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button button = (Button) findViewById(R.id.listele);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), pitchlist.class);
                startActivityForResult(myIntent, 0);
            }
        });





    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng saray = new LatLng(37.177881, 28.377158);
        mMap.addMarker(new MarkerOptions().position(saray).title("Saray halı saha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saray));


        LatLng kampus = new LatLng(37.175717, 28.374161);
        mMap.addMarker(new MarkerOptions().position(kampus).title("Kampüs halı saha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kampus));
    }




        }










